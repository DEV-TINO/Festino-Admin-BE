package com.DevTino.festino_admin.message.controller;

import com.DevTino.festino_admin.message.domain.DTO.RequestMessageSendDTO;
import com.DevTino.festino_admin.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/message")
public class MessageController {

    MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    // 메세지 전송
    @PostMapping("/send")
    public String sendMessage(@RequestBody RequestMessageSendDTO requestMessageSendDTO) throws IOException {
        return messageService.sendMessage(requestMessageSendDTO);
    }


}
