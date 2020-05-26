package com.shaw.springbootlogin;

import org.junit.jupiter.api.Test;

import java.io.*;

public class DataPreProcess {

    private static final String[] genreList = {
            "unknown",
            "action",
            "adventure",
            "animation",
            "children's",
            "comedy",
            "crime",
            "documentary",
            "drama",
            "fantasy",
            "film-noir",
            "horror",
            "musical",
            "mystery",
            "sci-fi",
            "thriller",
            "war",
            "western"
    };

    @Test
    public void run() throws Exception{
        //读取文件(字符流)
        //BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("d:\\1.txt"),"GBK"));
        BufferedReader in = new BufferedReader(new FileReader("d:\\u.item.txt"));
        //写入相应的文件
        //BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d:\\2.txt"),"GBK"));
        BufferedWriter out = new BufferedWriter(new FileWriter("d:\\4.txt"));
        //读取数据
        //循环取出数据
        String str = null;


        while ((str = in.readLine()) != null) {
            System.out.println(str);
            //写入相关文件
            String[] columns = str.split("\\|");
            //for(String column: columns){
            //    System.out.println(column);
            //}

            int n = columns.length;
            System.out.println(n);
            for(int i=5;i<n;++i){
                if(columns[i].equals("1")){
                    columns[5] = genreList[i-5];
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(columns[0]);
            for(int i=1;i<6;++i){
                sb.append("|"+columns[i]);
            }
            out.write(sb.toString());
            out.newLine();
            //break;
        }

        //清楚缓存
        out.flush();
        //关闭流
        in.close();
        out.close();
    }
}
