package com.DevTino.festino_admin.show.talent.bean.small;

import com.DevTino.festino_admin.show.talent.domain.DTO.ResponseTalentShowGetDTO;
import com.DevTino.festino_admin.show.talent.domain.TalentShowDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreateTalentShowsDTOBean {

    CreateTalentShowDTOBean createTalentShowDTOBean;

    @Autowired
    public CreateTalentShowsDTOBean(CreateTalentShowDTOBean createTalentShowDTOBean) {
        this.createTalentShowDTOBean = createTalentShowDTOBean;
    }



    // 연예인 공연 DTO List 생성
    public List<ResponseTalentShowGetDTO> exec(List<TalentShowDAO> talentShowDAOList){

        // DTO 리스트 생성
        List<ResponseTalentShowGetDTO> talentShowDTOList = new ArrayList<>();

        // DAO 리스트에서 DAO 하나씩 꺼내서
        for (TalentShowDAO talentShowDAO : talentShowDAOList){

            // 연예인 공연 DTO 생성
            ResponseTalentShowGetDTO dto = createTalentShowDTOBean.exec(talentShowDAO);

            // 생성한 DTO를 DTO 리스트에 삽입
            talentShowDTOList.add(dto);

        }

        // 생성한 DTO 리스트 리턴
        return talentShowDTOList;
    }

}
