package com.sun.uploads.service;

import com.sun.uploads.config.UploadConfig;
import com.sun.uploads.dao.FileDao;
import com.sun.uploads.model.FileModel;
import com.sun.uploads.util.FileUtil;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import static com.sun.uploads.util.FileUtil.generateFileName;
import static com.sun.uploads.util.UploadUtils.*;

/**
 * @ClassName FileService
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-13
 * @Version V1.0
 **/
@Service
public class FileService {

    @Autowired
    private FileDao fileDao;

    /**
     * 上传文件
     * @param name
     * @param md5
     * @param file
     */
    public void upload(String name, String md5, MultipartFile file) throws IOException {
        //生成 路径 + 文件名
        String path  = UploadConfig.path + generateFileName();
        FileUtil.write(path,file.getInputStream());
        fileDao.save(new FileModel(name, md5, path, new Date()));
    }

    /**
     * 检查是否保存过
     * @param md5
     * @return
     */
    public boolean checkMd5(String md5) {

        FileModel file = new FileModel();
        file.setMd5(md5);
        return fileDao.getByFile(file).size() == 0;
    }

    public void uploadWithBlock(String name, String md5, Long size, Integer chunks, Integer chunk, MultipartFile file) throws IOException {
        String fileName = getFileName(md5, chunks);
        FileUtil.writeWithBlok(UploadConfig.path + fileName, size, file.getInputStream(), file.getSize(), chunks, chunk);
        addChunk(md5,chunk);
        if (isUploaded(md5)) {
            removeKey(md5);
            fileDao.save(new FileModel(name, md5,UploadConfig.path + fileName, new Date()));
        }
    }
}
