package com.example.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.dao.FileDao;
import com.example.entity.File;
import com.example.exception.UploadException;
import com.example.service.FileService;
import com.example.utils.Code;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 2500728177@qq.com
 * @Date: 2024/1/11
 * @Description: com.example.controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/files")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping
    public Result upload(@RequestParam("file") MultipartFile file, @RequestParam("path") String path, @RequestParam("doctorId") Long doctorId) {
        boolean filesStorage = fileService.filesStorage(file, path, doctorId);
        if (filesStorage) {
            return new Result(Code.SAVE_OK);
        } else {
            return new Result(Code.SAVE_ERR, null, "上传失败！");
        }
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam("filePath") String filePath) {
        try {
            byte[] fileData = fileService.fileDownload(filePath);
            return ResponseEntity
                    .ok()
                    .header("Content-Disposition", "attachment; filename=\"" + filePath + "\"")
                    .body(fileData);
        } catch (IOException e) {
            // 适当的异常处理，比如返回404状态码
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/page")
    public Result getPageFile(@RequestParam("current") Long current, @RequestParam("pageSize") Long pageSize) {
        Page<File> filePage = fileService.selectPageFile(current, pageSize);
        if (filePage != null) {
            Map<String, Object> fileMap = new HashMap<>();
            fileMap.put("total", filePage.getTotal());
            fileMap.put("fileData", filePage.getRecords());
            return new Result(Code.GET_OK, fileMap);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }

    @GetMapping("/like")
    public Result getLikeFile(@RequestParam("fileOldName") String fileOldName) {
        List<File> fileList = fileService.selectLikeFile(fileOldName);
        if (!fileList.isEmpty()) {
            return new Result(Code.GET_OK, fileList);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }

    @GetMapping("/id")
    public Result getFileByFileId(@RequestParam("fileId") Long fileId) {
        File file = fileService.selectFileByFileId(fileId);
        if (file != null) {
            return new Result(Code.GET_OK, file);
        } else {
            return new Result(Code.GET_ERR, null, "请求失败！");
        }
    }

    @DeleteMapping
    public Result removeFileByFileId(@RequestParam("path") String path, @RequestParam("fileId") Long fileId) {
        boolean flag = fileService.deleteFileByFileId(path, fileId);
        if (flag) {
            return new Result(Code.DELETE_OK);
        } else {
            return new Result(Code.DELETE_ERR, null, "请求失败！");
        }
    }
}
