package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.entity.File;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/11
 * @Description: com.example.service
 * @Version: 1.0
 */
@Transactional
public interface FileService {
    boolean filesStorage(MultipartFile file, String path, Long doctorId);

    byte[] fileDownload(String path) throws IOException;
    Page<File> selectPageFile(Long current, Long pageSize);
    List<File> selectLikeFile(String fileOldName);

    File selectFileByFileId(Long fileId);
    boolean deleteFileByFileId(String path,Long fileId);
}
