package com.DevTino.festino_admin.message.bean.small;

import com.DevTino.festino_admin.message.domain.CustomMessageDAO;
import com.DevTino.festino_admin.message.domain.DTO.ResponseCustomMessageGetDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateCustomMessageDTOBean {

    public List<ResponseCustomMessageGetDTO> exec(List<CustomMessageDAO> customMessageDAOList){

        return customMessageDAOList.stream()
                .map(customMessageDAO -> ResponseCustomMessageGetDTO.builder()
                        .boothId(customMessageDAO.getBoothId())
                        .message(customMessageDAO.getMessage())
                        .messageType(customMessageDAO.getMessageType())
                        .build())
                .toList();
    }
}
