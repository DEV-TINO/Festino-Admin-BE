package com.DevTino.festino_admin.message.controller;

import com.DevTino.festino_admin.ApiResponse;
import com.DevTino.festino_admin.message.domain.DTO.RequestCustomMessageSaveDTO;
import com.DevTino.festino_admin.message.domain.DTO.RequestMessageSendDTO;
import com.DevTino.festino_admin.message.domain.DTO.ResponseCustomMessageGetDTO;
import com.DevTino.festino_admin.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

    // 커스텀 메세지 전체 조회
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<Object>> getCustomMessages(@RequestParam("boothId") UUID boothId) {

        List<ResponseCustomMessageGetDTO> responseCustomMessageGetDTOList = messageService.getCustomMessages(boothId);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "커스텀 메세지 전체 조회 성공", responseCustomMessageGetDTOList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // 커스텀 메시지 저장
    @PostMapping("")
    public ResponseEntity<ApiResponse<Object>> saveCustomMessage(@RequestBody RequestCustomMessageSaveDTO requestCustomMessageSaveDTO) throws IOException {

        UUID boothId = messageService.saveCustomMessage(requestCustomMessageSaveDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "커스텀 메시지 저장 성공", boothId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
