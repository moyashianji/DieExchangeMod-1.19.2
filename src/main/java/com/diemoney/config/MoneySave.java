package com.diemoney.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static com.diemoney.config.MoneyLoad.Money;

public class MoneySave {
    public static void onSave(){
        File modsFolder = new File("mods");
        File modFolder = new File(modsFolder, "nashiro");
        File configFile = new File(modFolder, "config.txt");

        try {
            FileWriter writer = new FileWriter(configFile);
            writer.write(Integer.toString(Money));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
