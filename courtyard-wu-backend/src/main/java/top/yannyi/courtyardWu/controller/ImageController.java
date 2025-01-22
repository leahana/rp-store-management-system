package top.yannyi.courtyardWu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Value;
import top.yannyi.courtyardWu.model.common.BaseResponse;
import top.yannyi.courtyardWu.model.common.ErrorCode;
import top.yannyi.courtyardWu.model.common.ResultUtils;
import top.yannyi.courtyardWu.model.exception.BusinessException;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Value("${image.upload.dir}")  // 配置图片存储目录
    private String uploadDir;

    @PostMapping("/upload")
    public BaseResponse uploadImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResultUtils.error(ErrorCode.NOT_FOUND_ERROR, "No file uploaded.");
        }
        try {
            // 获取文件名
            UUID uuid = UUID.randomUUID();
            String originalFilename = file.getOriginalFilename();
            // 保存文件到本地磁盘
            String filename = uuid + "-" + originalFilename;
            String filePath = uploadDir + "/" + filename;
            File targetFile = new File(filePath);
            file.transferTo(targetFile);

            // 返回文件的访问路径
            return ResultUtils.success(filename);
        } catch (IOException e) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "图片上传失败");
        }
    }

    // 获取图片展示的接口
    @GetMapping("/display/{fileName}")
    public ResponseEntity<byte[]> displayImage(@PathVariable("fileName") String fileName) throws IOException {
        File imageFile = new File(uploadDir + "/" + fileName);
        if (!imageFile.exists()) {
            return ResponseEntity.notFound().build();
        }
        byte[] imageBytes = java.nio.file.Files.readAllBytes(imageFile.toPath());
        return ResponseEntity.ok().body(imageBytes);
    }

}
