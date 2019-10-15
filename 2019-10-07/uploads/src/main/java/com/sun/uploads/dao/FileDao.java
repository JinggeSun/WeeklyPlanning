package com.sun.uploads.dao;

import com.sun.uploads.model.FileModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @ClassName FileDao
 * @Description: TODO
 * @Author zcm
 * @Date 2019-10-13
 * @Version V1.0
 **/
@Mapper
public interface FileDao {

    /**
     * 通过主键获取一行数据
     * @return
     */
    FileModel getById(Long id);

    /**
     * 插入一行数据
     * @param file
     * @return
     */
    int save(FileModel file);

    /**
     * 更新一行数据
     * @param file
     * @return
     */
    int update(FileModel file);

    /**
     * 删除一行数据
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据一个或多个属性获取File
     * @param file
     * @return
     */
    List<FileModel> getByFile(FileModel file);
}
