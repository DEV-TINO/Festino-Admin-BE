package com.DevTino.festino_admin.image.bean;

import com.DevTino.festino_admin.image.bean.small.SaveS3ImagesDAOBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Component
public class SaveS3ImagesBean {

    SaveS3ImagesDAOBean saveS3ImagesDAOBean;

    @Autowired
    public SaveS3ImagesBean(SaveS3ImagesDAOBean saveS3ImagesDAOBean) {
        this.saveS3ImagesDAOBean = saveS3ImagesDAOBean;
    }

    // 여러 이미지 저장
    public List<String> exec(List<MultipartFile> fileList) throws IOException {

        // 이미지가 없는 경우
        if (fileList == null || fileList.isEmpty()) {
            return null;
        }

        // S3 이미지 저장
        return saveS3ImagesDAOBean.exec(fileList);

    }
}
