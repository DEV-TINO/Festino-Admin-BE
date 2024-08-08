package com.DevTino.festino_admin.message.service;

import com.DevTino.festino_admin.message.bean.SendMessageBean;
import com.DevTino.festino_admin.message.domain.DTO.RequestMessageSendDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MessageService {

    SendMessageBean sendMessageBean;

    @Autowired
    public MessageService(SendMessageBean sendMessageBean) {
        this.sendMessageBean = sendMessageBean;
    }

    public String sendMessage(RequestMessageSendDTO requestMessageSendDTO) throws IOException {
        return sendMessageBean.exec(requestMessageSendDTO);
    }
}
