package com.DevTino.festino_admin.image.service;

import com.DevTino.festino_admin.image.bean.SaveS3ImageBean;
import com.DevTino.festino_admin.image.bean.SaveS3ImagesBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageService {

    SaveS3ImageBean saveS3ImageBean;
    SaveS3ImagesBean saveS3ImagesBean;

    @Autowired
    public ImageService(SaveS3ImageBean saveS3ImageBean, SaveS3ImagesBean saveS3ImagesBean) {
        this.saveS3ImageBean = saveS3ImageBean;
        this.saveS3ImagesBean = saveS3ImagesBean;
    }

    // 이미지 저장
    public String saveImage(MultipartFile file) throws IOException {
        return saveS3ImageBean.exec(file);
    }

    // 여러 이미지 저장
    public List<String> saveImages(List<MultipartFile> fileList) throws IOException {
        return saveS3ImagesBean.exec(fileList);
    }
}
