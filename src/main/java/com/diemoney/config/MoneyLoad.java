package com.diemoney.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoneyLoad {

    public static int Money;
    public static String MoneyValue = "";


    public static void main(String[] args) {

    }

    public static void extractDoubleFromTextFile() {
        File modsFolder = new File("mods");
        File modFolder = new File(modsFolder, "nashiro");
        File configFile = new File(modFolder, "config.txt");

        if (configFile.exists()) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(configFile));
                String line = reader.readLine();
                reader.close();

                // ファイルから読み取ったテキストを整数に変換
                Money = Integer.parseInt(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
