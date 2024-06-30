package com.DevTino.festino_admin.show.club.controller;

import com.DevTino.festino_admin.show.club.damain.DTO.RequestClubShowSaveDTO;
import com.DevTino.festino_admin.show.club.service.ClubShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/club/show")
public class ClubShowController {

    ClubShowService clubShowService;
    @Autowired
    public ClubShowController(ClubShowService clubShowService){
        this.clubShowService = clubShowService;
    }



    // 동아리 공연 저장
    @PostMapping("")
    public ResponseEntity<Map<String, Object>> saveClubShow(@RequestBody RequestClubShowSaveDTO requestClubShowSaveDTO){

        // 동아리 공연 저장 service 실행
        UUID clubId = clubShowService.saveClubShow(requestClubShowSaveDTO);


        // 동아리 공연 저장 성공 여부 설정
        boolean success = (clubId == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "동아리 공연 저장 성공" : "동아리 공연 저장 시 DAO 생성 실패");
        requestMap.put("noticeId", clubId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }

}
