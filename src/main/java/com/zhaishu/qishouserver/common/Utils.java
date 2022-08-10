package com.zhaishu.qishouserver.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class Utils {

    /**
     * 获得当前日期 yyyy-MM-dd HH:mm:ss
     *
     * @return 2019-08-27 14:12:40
     */
    public static String getCurrentTime() {
        // 小写的hh取得12小时，大写的HH取的是24小时
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return df.format(date);
    }
    /**
     * 获取当前日期 yy-MM-dd
     *
     * @return 2019-08-27
     */
    public static Integer getDateByInteger(Integer i) {
        Calendar c = Calendar.getInstance();

        c.add(Calendar.DATE, +i);
        Date date = c.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return Integer.valueOf(sdf.format(date));
    }
    public static Integer getMonthId(){
        // 1、普通的时间转换
        String string = new SimpleDateFormat("yyyyMM").format(new Date()).toString();
        return Integer.valueOf(string);
    }
    public static Integer getDateId(){
        // 1、普通的时间转换
        String string = new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();
        return Integer.valueOf(string);
    }
    public static synchronized Integer getShortId(Integer length){
        if (length>=10){
            throw new RuntimeExceptions("400","out of range");
        }
        int first;
        int second;
        if (length%2==0){
            first= RandomUtils.nextInt(pow(10,length/2),pow(10,length/2+1));
            second=RandomUtils.nextInt(pow(10,length/2),pow(10,length/2+1));
        }else {
           first= RandomUtils.nextInt(pow(10,length/2+1),pow(10,length/2+2));
           second=RandomUtils.nextInt(pow(10,length/2),pow(10,length/2+1));
        }
        System.out.println("--------"+first+"-----------"+second);

        return first*pow(10,length/2+1)+second;
    }
    public  static synchronized  Long getLongId(Integer length){
        if (length>=19){
           throw new RuntimeExceptions("400","out of range");
        }

        Long l=RandomUtils.nextLong(powl(10,length),powl(10,length+1));

        return l;
    }
    public static synchronized String getStringNum(Integer length){
        String str;
        if (length<10){
            str=String.valueOf(RandomUtils.nextInt(pow(10,length),pow(10,length+1)));
            return str;
        }
        if (length<19){
           str=String.valueOf(RandomUtils.nextLong(powl(10,length),powl(10,length+1)));
            return str;
        }else{
         StringBuilder builder=new StringBuilder();
         do {
             length=length-9;
             builder.append(String.valueOf(RandomUtils.nextInt(pow(10,9),pow(10,10))));


         }while (length>=19);
         builder.append(String.valueOf(RandomUtils.nextLong(powl(10,length),powl(10,length+1))));
         return builder.toString();
        }
    }
    public static Long powl(Integer a,Integer b){

        long r=a;
        for (int i = 0; i < b-2; i++) {
            r=r*a;
        }
        return r;

    }
    public static Integer pow(Integer a,Integer b){

        int r=a;
        for (int i = 0; i < b-2; i++) {
            r=r*a;
        }
        return r;

    }
    /**
     *  根据路径删除指定的目录或文件，无论存在与否
     *@param sPath  要删除的目录或文件
     *@return 删除成功返回 true，否则返回 false。
     */
    public static boolean DeleteFolder(String sPath) {
        Boolean flag = false;
        File file = new File(sPath);
        // 判断目录或文件是否存在
        if (!file.exists()) {  // 不存在返回 false
            return flag;
        } else {
            // 判断是否为文件
            if (file.isFile()) {  // 为文件时调用删除文件方法
                return deleteFile(sPath);
            } else {  // 为目录时调用删除目录方法
                return deleteDirectory(sPath);
            }
        }
    }
    /**
     * 删除单个文件
     * @param   sPath    被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String sPath) {
       Boolean flag = false;
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }
    /**
     * 删除目录（文件夹）以及目录下的文件
     * @param   sPath 被删除目录的文件路径
     * @return  目录删除成功返回true，否则返回false
     */
    public static boolean deleteDirectory(String sPath) {
        //如果sPath不以文件分隔符结尾，自动添加文件分隔符
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }
        File dirFile = new File(sPath);
        //如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            log.info("not exist or not drectory");
            return false;
        }
        Boolean flag = true;
        //删除文件夹下的所有文件(包括子目录)
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            //删除子文件
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag) break;
            } //删除子目录
            else {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag) break;
            }
        }
        if (!flag) return false;
        //删除当前目录
        if (dirFile.delete()) {

            return true;
        } else {
            log.info("删除失败");
            return false;
        }
    }

}
