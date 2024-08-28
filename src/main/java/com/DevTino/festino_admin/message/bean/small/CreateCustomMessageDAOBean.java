package com.DevTino.festino_admin.message.bean.small;

import com.DevTino.festino_admin.message.domain.CustomMessageDAO;
import com.DevTino.festino_admin.message.domain.DTO.CustomMessageDTO;
import com.DevTino.festino_admin.message.domain.DTO.RequestCustomMessageSaveDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateCustomMessageDAOBean {

    public List<CustomMessageDAO> exec(RequestCustomMessageSaveDTO requestCustomMessageSaveDTO) {

        List<CustomMessageDTO> customMessageList = requestCustomMessageSaveDTO.getCustomMessageList();

        return customMessageList.stream()
                .map(customMessageDTO -> CustomMessageDAO.builder()
                        .boothId(requestCustomMessageSaveDTO.getBoothId())
                        .message(customMessageDTO.getMessage())
                        .messageType(customMessageDTO.getMessageType())
                        .build())
                .toList();
    }
}
