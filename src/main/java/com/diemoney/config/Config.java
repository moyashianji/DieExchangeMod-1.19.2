package com.diemoney.config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Config {
    public void Config(){

    }
    public static void generateConfigFile(){
        File modsFolder = new File("mods");
        File modFolder = new File(modsFolder, "nashiro");

        System.out.println("Already File Created");

        //モッド名のフォルダが存在しなければ生成する
        if(!modFolder.exists()){
            modFolder.mkdirs();
            System.out.println("Folder Created");
        }

        File configFile = new File(modFolder, "config.txt");
        System.out.println("Already Config Created");

        if(!configFile.exists()){
            try{
                configFile.createNewFile();

                FileWriter writer = new FileWriter(configFile);
                writer.write("0");

            } catch (IOException e) {

                e.printStackTrace();
            }

        }
    }
}
