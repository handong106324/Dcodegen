package com.souyidai.oa;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by handong on 16/5/31.
 */
public class Test {

    public static void main(String[] args) {
        String cmd = "/opt/gen/risk_jar_file/cpjar.sh";
        Test codeGenService = new Test();
        try {
            codeGenService.rsync(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void rsync(String cmd) throws IOException, InterruptedException {
        Runtime run = Runtime.getRuntime();
        // 返回与当前 Java 应用程序相关的运行时对象
        // String cmd =
        // configService.getConfigByKey(ConfigConstant.SYS_RSYNCCMD);
        Process p = run.exec(cmd);// 启动另一个进程来执行命令
        try (BufferedInputStream in = new BufferedInputStream(p.getInputStream());
             BufferedReader inBr = new BufferedReader(new InputStreamReader(in, "UTF-8"))) {
            String lineStr = "";
            while ((lineStr = inBr.readLine()) != null) {
                System.out.println(lineStr);
            }
            // 检查命令是否执行失败。
            if (p.waitFor() != 0) {
                if (p.exitValue() != 0) {// p.exitValue()==0表示正常结束，1：非正常结束
                    System.out.println(p.exitValue());
                }
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw ex;
        } finally {
            p.destroy();
        }
    }

}
