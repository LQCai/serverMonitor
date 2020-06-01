package com.luoqincai.tool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class CommandTool {
    /**
     * exec cmd
     * @param cmd command
     * @return result
     */
    public static String execCMD(String cmd) {
        StringBuilder stringBuilder = null;
        try {
            Process process = Runtime.getRuntime().exec(cmd);

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    process.getInputStream(),
                    Charset.forName("GBK")
            ));

            stringBuilder = new StringBuilder();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return stringBuilder.toString();
    }
}
