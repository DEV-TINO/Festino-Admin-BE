package com.DevTino.festino_admin.image.controller;

import com.DevTino.festino_admin.ApiResponse;
import com.DevTino.festino_admin.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
// @CrossOrigin("*")
@RequestMapping("/admin/image")
public class ImageController {

    ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    // 이미지 저장
    @PostMapping("")
    public ResponseEntity<ApiResponse<Object>> saveImage(@RequestParam("file") MultipartFile file) throws IOException {

        String imageUrl = imageService.saveImage(file);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "이미지 저장 성공", imageUrl);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 여러 이미지 저장
    @PostMapping("/all")
    public ResponseEntity<ApiResponse<Object>> saveImages(@RequestParam("files") List<MultipartFile> fileList) throws IOException {
        List<String> imageUrlList = imageService.saveImages(fileList);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "여러 이미지 저장 성공", imageUrlList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}

