package com.sun.uploads.util;

import java.io.*;
import java.util.UUID;

/**
 * @ClassName FileUtil
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-13
 * @Version V1.0
 **/
public class FileUtil {

    /**
     * 写入文件
     * @param target
     * @param src
     * @throws IOException
     */
    public static void write(String target, InputStream src) throws IOException {
        OutputStream os = new FileOutputStream(target);
        byte[] buf = new byte[1024];
        int len;
        while (-1 !=(len = src.read(buf))){
            os.write(buf,0,len);
        }
        os.flush();
        os.close();
    }


    /**
     * 分块写入文件
     * @param target
     * @param targetSize
     * @param src
     * @param srcSize
     * @param chunks
     * @param chunk
     * @throws IOException
     */
    public static void writeWithBlok(String target, Long targetSize, InputStream src, Long srcSize, Integer chunks, Integer chunk) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(target,"rw");
        randomAccessFile.setLength(targetSize);
        if (chunk == chunks - 1 && chunk != 0) {
            randomAccessFile.seek(chunk * (targetSize - srcSize) / chunk);
        } else {
            randomAccessFile.seek(chunk * srcSize);
        }
        byte[] buf = new byte[1024];
        int len;
        while (-1 != (len = src.read(buf))) {
            randomAccessFile.write(buf,0,len);
        }
        randomAccessFile.close();
    }

    /**
     * 生成随机I，作为文件名
     * @return
     */
    public static String generateFileName(){
        return UUID.randomUUID().toString();
    }
}
