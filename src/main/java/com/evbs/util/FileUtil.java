package com.evbs.util;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * Created by squirrel-chen on 7/12/17.
 */
public class FileUtil {

    private static final Logger logger= LoggerFactory.getLogger(FileUtil.class);

    public static boolean writeToFile(String filepath,String data)
    {
        File outputfile=new File(filepath);
        try {
            if(!outputfile.exists())
            {
                logger.info("目标文件不存在");
                outputfile.createNewFile();
                logger.info("创建新文件"+outputfile.getName());
            }
            FileUtils.writeStringToFile(outputfile,data,"UTF-8");
            return true;
        } catch (IOException e) {
            logger.info("写入文件数据出错");
            e.printStackTrace();
            return false;
        }
    }

    public static String readFromFile(String filepath)
    {
        File inputfile=new File(filepath);
        try{
            if(!inputfile.exists())
            {
                logger.info("目标文件不存在");
                return "";
            }
           return FileUtils.readFileToString(inputfile,"UTF-8");
        }
        catch(IOException e)
        {
            logger.error("读取文件数据出错");
            e.printStackTrace();
            return "";
        }
    }

    public static boolean appendDataToFile(String filepath,String data)
    {
        File appendfile=new File(filepath);
        try{
            if(!appendfile.exists()){
                appendfile.createNewFile();
                logger.info("文件不存在,创建新文件");
            }
            FileUtils.writeStringToFile(appendfile,data,"UTF-8",true);
            return true;
        }
        catch(Exception e)
        {
            logger.error("追加文件数据出错");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean createUserDir(String dirpath)
    {
        File userdir=new File(dirpath);
        try{
            if(!userdir.exists())
            {
                userdir.mkdirs();
                logger.info("创建用户目录");
            }
            return true;
        }
        catch(Exception e)
        {
            logger.error("目录创建失败");
            e.printStackTrace();
            return false;
        }
    }

    public static int countLines(String filepath)
    {
        File countfile=new File(filepath);
        try{

            if(!countfile.exists())
            {
            logger.info("目标文件不存在");
            return 0;
            }
           return (FileUtils.readLines(countfile,"UTF-8")).size();
        }
        catch(Exception e)
        {
            logger.error("统计文件行数异常");
            e.printStackTrace();
        }
        return 0;
    }

    public static String readDataByLineNumber(String filepath,int linenum)
    {
        File resouce=new File(filepath);
        String str="";
        try {
            List<String> result=FileUtils.readLines(resouce,"UTF-8");
            str=result.get(linenum-1);
            logger.info("读取的行数是"+linenum+"读取的对应数据是"+str);
        } catch (IOException e) {
            logger.error("读取数据错误");
            e.printStackTrace();
        }
        return str;
    }

}
