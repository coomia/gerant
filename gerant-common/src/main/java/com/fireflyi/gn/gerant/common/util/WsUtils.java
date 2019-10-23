package com.fireflyi.gn.gerant.common.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author by lishihao
 * @date 2019/10/23
 * DESC TODO
 */
public class WsUtils {

    public static void flushFileByte2(String data, String filePath){
        File file = new File(filePath);
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), "UTF-8"));
            writer.write(data);

        } catch (IOException e) {
            System.out.printf("写入失败"+e.getMessage());
            e.printStackTrace();
        }
    }

    public static void flushFileByte( byte[] data, String filePath){
        try {
            Files.write(Paths.get(filePath), data);
        } catch (IOException e) {
            System.out.printf("写入失败"+e.getMessage());
            e.printStackTrace();
        }
    }

    public static void flushFile( String data, String filePath){
        File file =new File(filePath);
        Writer out = null;
        try {
            out = new FileWriter(file);
            out.write(data);
            out.close();
        } catch (IOException e) {
            System.out.printf("写入失败"+e.getMessage());
            e.printStackTrace();
        }
    }

}
