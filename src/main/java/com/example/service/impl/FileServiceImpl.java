package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.FileDao;
import com.example.exception.UploadException;
import com.example.service.FileService;
import com.example.utils.Code;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/11
 * @Description: com.example.service.impl
 * @Version: 1.0
 */
@Service
public class FileServiceImpl implements FileService {
    //绑定文件上传路径到uploadPath
    @Value("${spring.web.upload-path}")
    private String uploadPath;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    private FileDao fileDao;

    @Override
    public boolean filesStorage(MultipartFile file, String path, Long doctorId) {
        //获取文件原始名
        String fileOldName = file.getOriginalFilename();
        //避免文件重复获取唯一标识
        String fileNewName = UUID.randomUUID() + file.getOriginalFilename();
        String fileUploadTime = dateFormat.format(new Date());
        File uploadParentFile = new File(uploadPath, path);
        //判断文件是否存在
        if (!uploadParentFile.isDirectory()) {
            uploadParentFile.mkdirs();
        }
        File uploadFile = new File(uploadParentFile, fileNewName);
        String filePath = uploadPath + "/" + path + "/" + fileNewName;
        try {
            // 文件保存
            file.transferTo(uploadFile);
            com.example.entity.File fileData = new com.example.entity.File(null, doctorId, fileNewName, fileOldName, fileUploadTime, filePath, null);
            return fileDao.insert(fileData) != 0;

        } catch (IOException e) {
            throw new UploadException(Code.UPDATE_ERR, "文件上传失败");
        }
    }

    @Override
    public byte[] fileDownload(String path) throws IOException {
        //读取目标文件
        File f = new File(path);
        if (!f.exists()) {
            throw new IOException("文件找不到！");
        }
        try (FileInputStream inputStream = new FileInputStream(f)) {
            return StreamUtils.copyToByteArray(inputStream);
        } catch (IOException e) {
            // 适当的异常处理
            throw new IOException("文件下载失败！");
        }
    }

    /**
     * 分页查询
     * @param current 当前页
     * @param pageSize 每页条数
     * @return page
     */
    @Override
    public Page<com.example.entity.File> selectPageFile(Long current, Long pageSize) {
        Page<com.example.entity.File> page = new Page<>(current, pageSize);
        return fileDao.selectPage(page, null);
    }

    /**
     * 模糊查询
     * @param fileOldName 文件名
     * @return 返回fileList
     */
    @Override
    public List<com.example.entity.File> selectLikeFile(String fileOldName) {
        LambdaQueryWrapper<com.example.entity.File> lqw = new LambdaQueryWrapper<>();
        lqw.like(com.example.entity.File::getFileOldName,fileOldName);
        return fileDao.selectList(lqw);
    }

    /**
     * 查找file
     * @param fileId 文件id
     * @return file
     */
    @Override
    public com.example.entity.File selectFileByFileId(Long fileId) {
        return fileDao.selectById(fileId);
    }

    @Override
    public boolean deleteFileByFileId(String path, Long fileId) {
        try {
            Path filePath = Paths.get(path);
            // 如果文件存在，则删除该文件
            if (Files.exists(filePath)) {
                Files.delete(filePath);
                return fileDao.deleteById(fileId) != 0;
            } else {
                return false;
            }
        } catch (Exception e) {
            // 处理异常情况
            e.printStackTrace();
            return false;
        }
    }
}
