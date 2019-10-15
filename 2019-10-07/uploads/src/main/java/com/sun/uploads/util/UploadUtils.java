package com.sun.uploads.util;

import javafx.scene.shape.VLineTo;

import java.util.HashMap;
import java.util.Map;

import static com.sun.uploads.util.FileUtil.generateFileName;

/**
 * @ClassName UploadUtils
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-13
 * @Version V1.0
 **/
public class UploadUtils {

    private static class Value{
        String name;
        boolean[] status;

        Value(int n){
            this.name = generateFileName();
            this.status = new boolean[n];
        }
    }


    private static Map<String, Value> chunkMap = new HashMap<>();

    public static boolean isUploaded(String key){
        if (isExist(key)){
            for (boolean b : chunkMap.get(key).status){
                if (!b){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static boolean isExist(String key) {
        return chunkMap.containsKey(key);
    }

    /**
     * 为文件上传分块记录
     * @param key
     * @param chunk
     */
    public static void addChunk(String key,int chunk){
        chunkMap.get(key).status[chunk] = true;
    }

    public static void removeKey(String key){
        if (isExist(key)){
            chunkMap.remove(key);
        }
    }

    public static String getFileName(String key,int chunks){
        if (!isExist(key)){
            synchronized (UploadUtils.class){
                if (!isExist(key)){
                    chunkMap.put(key,new Value(chunks));
                }
            }
        }
        return chunkMap.get(key).name;
    }


}
