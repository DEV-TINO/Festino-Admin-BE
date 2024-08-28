package com.DevTino.festino_admin.message.service;

import com.DevTino.festino_admin.message.bean.GetCustomMessagesBean;
import com.DevTino.festino_admin.message.bean.SaveCustomMessageBean;
import com.DevTino.festino_admin.message.bean.SendMessageBean;
import com.DevTino.festino_admin.message.domain.DTO.RequestCustomMessageSaveDTO;
import com.DevTino.festino_admin.message.domain.DTO.RequestMessageSendDTO;
import com.DevTino.festino_admin.message.domain.DTO.ResponseCustomMessageGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class MessageService {

    SendMessageBean sendMessageBean;
    GetCustomMessagesBean getCustomMessagesBean;
    SaveCustomMessageBean saveCustomMessageBean;

    @Autowired
    public MessageService(SendMessageBean sendMessageBean, GetCustomMessagesBean getCustomMessagesBean, SaveCustomMessageBean saveCustomMessageBean) {
        this.sendMessageBean = sendMessageBean;
        this.getCustomMessagesBean = getCustomMessagesBean;
        this.saveCustomMessageBean = saveCustomMessageBean;
    }

    // 메세지 전송
    public String sendMessage(RequestMessageSendDTO requestMessageSendDTO) throws IOException {
        return sendMessageBean.exec(requestMessageSendDTO);
    }

    // 커스텀 메세지 전체 조회
    public List<ResponseCustomMessageGetDTO> getCustomMessages(UUID boothId) {
        return getCustomMessagesBean.exec(boothId);
    }

    // 커스텀 메시지 저장
    public UUID saveCustomMessage(RequestCustomMessageSaveDTO requestCustomMessageSaveDTO) {
        return saveCustomMessageBean.exec(requestCustomMessageSaveDTO);
    }
}
