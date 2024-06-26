package com.DevTino.festino_admin.notice.controller;


import com.DevTino.festino_admin.notice.domain.DTO.*;
import com.DevTino.festino_admin.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



    // 공지사항 조회
    @GetMapping("/notice/{noticeId}")
    public ResponseEntity<Map<String, Object>> getNotice(@PathVariable UUID noticeId){

        // 공지사항 조회 service 실행
        ResponseNoticeGetDTO responseNoticeGetDTO = noticeService.getNotice(noticeId);

        // 공지사항 조회 성공 여부 설정
        boolean success = (responseNoticeGetDTO == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "공지사항 조회 성공" : "공지사항 조회 시 DAO 검색 실패");
        requestMap.put("noticeInfo", responseNoticeGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

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



    // 공지사항 수정
    @PutMapping("/notice")
    public ResponseEntity<Map<String, Object>> updateNotice(@RequestBody RequestNoticeUpdateDTO requestNoticeUpdateDTO){
        
        // 공지사항 수정 service 실행
        UUID noticeId = noticeService.updateNotice(requestNoticeUpdateDTO);
        
        // 공지사항 수정 성공 여부 설정
        boolean success = (noticeId == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "공지사항 수정 성공" : "공지사항 수정 시 DAO 검색 실패");
        requestMap.put("noticeId", noticeId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }



    // 공지사항 pin 수정
    @PutMapping("/notice/pin")
    public ResponseEntity<Map<String, Object>> updateNoticePin(@RequestBody RequestNoticePinUpdateDTO requestNoticePinUpdateDTO){

        // 공지사항 pin 수정 service 실행
        UUID noticeId = noticeService.updateNoticePin(requestNoticePinUpdateDTO);

        // 공지사항 pin 수정 성공 여부 설정
        boolean success = (noticeId == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "공지사항 pin 수정 성공" : "공지사항 pin 수정 시 DAO 검색 실패");
        requestMap.put("noticeId", noticeId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
    }



    // 공지사항 삭제
    @DeleteMapping("/notice")
    public ResponseEntity<Map<String, Object>> deleteNotice(@RequestBody RequestNoticeDeleteDTO requestNoticeDeleteDTO){

        // 공지사항 삭제 service 실행 & 삭제 성공 여부 설정
        boolean success = noticeService.deleteNotice(requestNoticeDeleteDTO);

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "공지사항 삭제 성공" : "공지사항 삭제 시 DAO 검색 실패");

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }

}
