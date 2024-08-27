package com.DevTino.festino_admin.message.controller;

import com.DevTino.festino_admin.message.domain.DTO.RequestCustomMessageSaveDTO;
import com.DevTino.festino_admin.message.domain.DTO.RequestMessageSendDTO;
import com.DevTino.festino_admin.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

    // 커스텀 메시지 저장
    @PostMapping("")
    public ResponseEntity<Map<String, Object>> saveCustomMessage(@RequestBody RequestCustomMessageSaveDTO requestCustomMessageSaveDTO) throws IOException {
        UUID boothId = messageService.saveCustomMessage(requestCustomMessageSaveDTO);

        // 주문 상세 조회 성공 여부 설정
        boolean success = (boothId == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "커스텀 메세지 수정 완료" : "커스텀 메세지 수정 실패");
        requestMap.put("boothId", boothId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }


}
