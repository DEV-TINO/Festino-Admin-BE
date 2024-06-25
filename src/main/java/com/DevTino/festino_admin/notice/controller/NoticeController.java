package com.DevTino.festino_admin.notice.controller;


import com.DevTino.festino_admin.notice.domain.DTO.RequestNoticeSaveDTO;
import com.DevTino.festino_admin.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class NoticeController {

    NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService){
        this.noticeService = noticeService;
    }



    // 공지사항 저장
    @PostMapping("/notice")
    public ResponseEntity<Map<String, Object>> saveNotice(@RequestBody RequestNoticeSaveDTO requestNoticeSaveDTO){

        // 공지사항 저장 service 실행
        UUID noticeId = noticeService.saveNotice(requestNoticeSaveDTO);

        // 공지사항 저장 성공 여부 설정
        boolean success = (noticeId == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "공지사항 저장 성공" : "공지사항 저장 시 DAO 생성 실패");
        requestMap.put("noticeId", noticeId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }

}
