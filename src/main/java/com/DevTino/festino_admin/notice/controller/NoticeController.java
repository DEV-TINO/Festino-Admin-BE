package com.DevTino.festino_admin.notice.controller;


import com.DevTino.festino_admin.ApiResponse;
import com.DevTino.festino_admin.notice.domain.DTO.*;
import com.DevTino.festino_admin.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
// @CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/admin/notice")
public class NoticeController {

    NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService){
        this.noticeService = noticeService;
    }



    // 공지사항 조회
    @GetMapping("/{noticeId}")
    public ResponseEntity<ApiResponse<Object>> getNotice(@PathVariable("noticeId") UUID noticeId){

        // 공지사항 조회 service 실행
        ResponseNoticeGetDTO responseNoticeGetDTO = noticeService.getNotice(noticeId);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "공지사항 조회 성공", responseNoticeGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 공지사항 전체 조회
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<Object>> getNoticeAll(@RequestParam(required = false, defaultValue = "0", value = "page") int pageNo){

        // 공지사항 전체 조회 service 실행
        ResponseNoticesGetDTO responseNoticesGetDTO = noticeService.getNoticeAll(pageNo);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "공지사항 전체 조회 성공", responseNoticesGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



    // 공지사항 저장
    @PostMapping("")
    public ResponseEntity<ApiResponse<Object>> saveNotice(@RequestBody RequestNoticeSaveDTO requestNoticeSaveDTO){

        // 공지사항 저장 service 실행
        UUID noticeId = noticeService.saveNotice(requestNoticeSaveDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "공지사항 저장 성공", noticeId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 공지사항 수정
    @PutMapping("")
    public ResponseEntity<ApiResponse<Object>> updateNotice(@RequestBody RequestNoticeUpdateDTO requestNoticeUpdateDTO){
        
        // 공지사항 수정 service 실행
        UUID noticeId = noticeService.updateNotice(requestNoticeUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "공지사항 수정 성공", noticeId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



    // 공지사항 pin 수정
    @PutMapping("/pin")
    public ResponseEntity<ApiResponse<Object>> updateNoticePin(@RequestBody List<RequestNoticePinUpdateDTO> requestNoticePinUpdateDTOList){

        // 공지사항 pin 수정 service 실행
        List<ResponseNoticePinUpdateDTO> responseNoticePinUpdateDTOList = noticeService.updateNoticePin(requestNoticePinUpdateDTOList);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "공지사항 pin 수정 성공", responseNoticePinUpdateDTOList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



    // 공지사항 삭제
    @DeleteMapping("")
    public ResponseEntity<ApiResponse<Object>> deleteNotice(@RequestBody RequestNoticeDeleteDTO requestNoticeDeleteDTO){

        // 공지사항 삭제 service 실행
        noticeService.deleteNotice(requestNoticeDeleteDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "공지사항 삭제 성공", null);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
