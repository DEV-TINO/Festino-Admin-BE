package com.DevTino.festino_admin.image.bean.small;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SaveS3ImagesDAOBean {

    SaveS3ImageDAOBean saveS3ImageDAOBean;

    @Autowired
    public SaveS3ImagesDAOBean(SaveS3ImageDAOBean saveS3ImageDAOBean) {
        this.saveS3ImageDAOBean = saveS3ImageDAOBean;
    }

    // 여러 이미지 저장
    public List<String> exec(List<MultipartFile> fileList) throws IOException {

        List<String> imageUrls = new ArrayList<>();

        // 하나씩 확인해가면서 저장 후 url 반환
        for (MultipartFile file : fileList) {
            imageUrls.add(saveS3ImageDAOBean.exec(file));
        }
        return imageUrls;
    }
}
