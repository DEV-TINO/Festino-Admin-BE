package com.DevTino.festino_admin.message.service;

import com.DevTino.festino_admin.message.bean.CustomMessageSaveBean;
import com.DevTino.festino_admin.message.bean.SendMessageBean;
import com.DevTino.festino_admin.message.domain.DTO.RequestCustomMessageSaveDTO;
import com.DevTino.festino_admin.message.domain.DTO.RequestMessageSendDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Service
public class MessageService {

    SendMessageBean sendMessageBean;
    CustomMessageSaveBean customMessageSaveBean;

    @Autowired
    public MessageService(SendMessageBean sendMessageBean, CustomMessageSaveBean customMessageSaveBean) {
        this.sendMessageBean = sendMessageBean;
        this.customMessageSaveBean = customMessageSaveBean;
    }

    // 메세지 전송
    public String sendMessage(RequestMessageSendDTO requestMessageSendDTO) throws IOException {
        return sendMessageBean.exec(requestMessageSendDTO);
    }

    // 커스텀 메시지 저장
    public UUID saveCustomMessage(RequestCustomMessageSaveDTO requestCustomMessageSaveDTO) {
        return customMessageSaveBean.exec(requestCustomMessageSaveDTO);
    }
}
