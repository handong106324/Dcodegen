package review;

import system.SystemUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by handong on 16/2/6.
 */
public class MyClass {
    private String name;
    public static void main(String[] args) {
        MyClass m1 = new MyClass();
        MyClass m2 = new MyClass();
        m1.name = m2.name = "m1";
        callMe(m1,m2);
        SystemUtils.println(m1+";"+m2);
    }

    private static void callMe(MyClass... m) {
        m[0]=m[1];
        m[1].name="nm";
    }
    /**
     * 题目大意：这个程序的打印结果是？

     a.m1 & new name

     b.以上都是错误的

     c.m1&m1

     d.new name & new name

     这道题实际上简单得多，我们只要看到第十二行，它直接打印了m1和m2，而不是m1.name和m2.name。这段代码狡猾的地方在于，当我们要打印一个对象时，Java使用的是toString方法。“name”属性是我们自己加入的，如果你忘记这点，其他地方都判断正确的话，你可能会错误地选择m1&new name这个答案。

     这行代码将两个对象的name属性都赋值为”m1”。

     m1.name = m2.name = “m1";

     然后callMe方法将m2对象的name属性设置成”new name”，然后代码就结束了。

     但是，这个代码片段实际上将会打印出如下信息，包括类名称以及它们的哈希码：

     MyClass@3d0bc85 & MyClass@7d08c1b7

     所以正确的答案是“None of the above”
     */

    private static final List<String> NAMES = new ArrayList<String>(){
        {
            add("John");
            SystemUtils.println(NAMES);
        }
    };

    /**
     * 题目大意：这段代码错误的地方在哪？

     a.没有错误

     b.可能获得null值

     c.代码不能编译

     d.打印出不正确的结果

     这个问题是代码最少的问题之一，但是足以迷惑绝大部分的开发者。这道题只有26%的答题者回答正确。

     很少有开发者知道这个初始化常量集合的简便语法，虽然这个语法会带来一些副作用。但事实上，这个语法鲜为人知未免不是一件好事。在感叹之后，你看到，我们往list里添加了一个元素，然后打印这个list。正常情况下，你期望看到打印的结果是[John]，但是利用两个花括号进行初始化是有另一套初始化过程的。这里，我们用了一个匿名类来初始化一个List，当要打印NAMES时，实际上打印出来的是null，这是因为初始化程序尚未完成，此时的list是空的。

     关于使用两个花括号进行容器的初始化，可参考这里（right here）。
     */

//    public void test(){
//        Map<String,Object> collections = new TreeMap<String, Object>();
//        SystemUtils.println(collections.compute("foo",(k,v) -> (v == null) ? new ArrayList<Object>() : ((List)v).add("bar")));
//        SystemUtils.println(collections.compute("foo",(k,v) -> (v == null) ? new ArrayList<Object>() : ((List)v).add("bar")));
//    }
}
