package org.nagarro.utilities;


import java.io.*;
import java.util.Properties;

public class PropertyHandler {

    public static void main(String[] args) throws Exception{
       System.out.println(readConfig("webDriver"));

    }
    public static String readConfig(String key){
        FileReader reader= null;
        Properties properties= null;
        String value = null;
        try{
            reader=new FileReader("src/main/resources/dataSource/config.properties");
            properties =new Properties();
            properties.load(reader);
            value = properties.getProperty(key);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return value;
    }
    public static String readData(String key){
        FileReader reader= null;
        Properties properties= null;
        String value = null;
        try{
            reader=new FileReader("src/main/resources/dataSource/testData.properties");
            properties =new Properties();
            properties.load(reader);
            value = properties.getProperty(key);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return value;
    }

    public static void writeProperty (String fileName,String key,String value) throws IOException {

        FileReader reader= null;
        Properties properties= null;
        FileOutputStream fileOutputStream = null;
        try{
            reader=new FileReader(fileName);
            properties =new Properties();
            properties.load(reader);
            properties.setProperty(key,value);
            fileOutputStream = new FileOutputStream(fileName);
            properties.store(fileOutputStream,"");

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
            if(fileOutputStream != null){
                fileOutputStream.close();
            }
        }

    }

    public static void logToFile(String filePath, String text)
    {
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filePath,true)))) {
            out.println(text);
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
