package review;

import java.sql.SQLException;

/**
 * Created by handong on 16/2/6.
 */
public class Mocker <T extends Exception>{
    private void pleaseThrow(final Exception t) throws T {
        throw (T)t;
    }

    public static void main(String[] args) {
        try {
            new Mocker<RuntimeException>().pleaseThrow(new SQLException());
        }catch (final RuntimeException ex) {//SQLException is wrong
            ex.printStackTrace();
        }
    }
/*
    这段代码错在哪儿？

    a.编译错误，因为没有SQLException被抛出

    b.抛出ClassCastException，因为SQLException并不是RuntimeException的一个实例
        RuntimeException和SQLException都继承自Exception，但是在这个代码中RuntimeException是未检查的异常，而SQLException是受检异常。

    c.没有错误，程序打印出抛出的SQLException堆栈跟踪信息---当SQLException 改为RuntimeException 时。

    d.编译错误，因为我们不能将SQLException类型转换成RuntimeException
        不是转换错误

    好，我们能从题目中得到什么信息？题目中的泛型涉及到了类型擦除，以及一些异常。这里需要回忆一些知识：

RuntimeException和SQLException都继承自Exception，但是在这个代码中RuntimeException是未检查的异常，而SQLException是受检异常。

2.Java的泛型并不是具体化的。这意味着在编译时，泛型的类型信息会“丢失”，并且泛型参数像是被它的限定类型替换了一样，或者当限定类型不存在时，泛型参数被替换成了Object。这就是大家所说的类型“擦除”。

我们天真地希望第七行能产生一个编译错误，因为我们不能将SQLException转换成RuntimeException，但是这并不会发生。发生的是将T替换成了Exception，所以我们有：

throw (Exception) t; // t is also an Exception

pleaseThrow方法期望一个Exception，并且T被替换成了Exception，因此类型转换被擦除了，就像没写这个代码一样。这一点我们可从下面的字节码中得到佐证：

private pleaseThrow(Ljava/lang/Exception;)V throws java/lang/Exception

L0

LINENUMBER 8 L0

ALOAD 1

ATHROW

L1

LOCALVARIABLE this LTemp; L0 L1 0

// signature LTemp<TT;>;

// declaration: Temp<T>

LOCALVARIABLE t Ljava/lang/Exception; L0 L1 1

MAXSTACK = 1

MAXLOCALS = 2

我们再看一下，如果代码中没有涉及泛型，那么编译产生的字节码是什么样的，我们看到，在ATHROW前会有如下的代码：

CHECKCAST java/lang/RuntimeException

现在，我们可以确信，代码中并没有涉及到类型转换，因此我们可以排除下面这两个选项：

“编译错误，因为我们不能将SQLException类型转换为RuntimeException”

“抛出ClassCastException，因为SQLException不是RuntimeException的一个实例”

因此毕竟我们抛出了SQLException，然后你希望它能被catch代码块捕获，然后打印它的堆栈跟踪信息。然而，事与愿违。

这个代码具有欺骗性，它使得编译器和我们一样变得困惑。这段代码让编译器认为catch代码块是不能到达的。对于不知情的旁观者来说，代码中并没有SQLException。所以，正确答案是：编译失败，因为编译器认为SQLException不会从try代码块中抛出－但是实际上它确实能抛出！

再次感谢Alexandru与我们分享这个问题！我们可以用另一个很酷的方式来查看代码中的错误以及SQLException实际上是怎样抛出的，这个方法是：修改catch代码块，把它修改为接收一个RuntimeException。这样你就可以看到SQLException的堆栈信息了。（实际上SQLException也并没有被catch代码段捕获，而是被虚拟机捕获并打印出异常栈的信息。）
*/
}
