package com.DevTino.festino_admin.image.bean.small;


import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class SaveS3ImageDAOBean {

    private final AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    // 허용된 MIME 타입 목록
    private static final List<String> ALLOWED_CONTENT_TYPES = Arrays.asList(
            "image/jpeg",
            "image/jpg",
            "image/png",
            "image/svg+xml"
    );

    // S3 이미지 업로드
    public String exec(MultipartFile multipartFile) throws IOException {
        String contentType = multipartFile.getContentType();

        // 파일 형식이 허용된 MIME 타입인지 확인
        if (contentType == null || !ALLOWED_CONTENT_TYPES.contains(contentType)) {
            throw new IOException("Unsupported file type: " + contentType);
        }

        // S3에 저장될 파일 이름
        String s3FileName = "festino/" + UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();

        // S3에 저장될 파일 메타데이터
        ObjectMetadata objMeta = new ObjectMetadata();
        objMeta.setContentLength(multipartFile.getInputStream().available());
        objMeta.setContentType(contentType);

        // S3에 파일 저장
        amazonS3Client.putObject(bucket, s3FileName, multipartFile.getInputStream(), objMeta);

        // S3에 저장된 파일 URL 반환
        return amazonS3Client.getUrl(bucket, s3FileName).toString();
    }
}