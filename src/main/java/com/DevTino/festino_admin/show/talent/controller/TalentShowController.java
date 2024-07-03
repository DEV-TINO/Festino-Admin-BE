package com.DevTino.festino_admin.show.talent.controller;

import com.DevTino.festino_admin.show.talent.domain.DTO.RequestTalentShowSaveDTO;
import com.DevTino.festino_admin.show.talent.service.TalentShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin/talent/show")
public class TalentShowController {

    TalentShowService talentShowService;

    @Autowired
    public TalentShowController(TalentShowService talentShowService){
        this.talentShowService = talentShowService;
    }



    // 연예인 공연 저장
    @PostMapping("")
    public ResponseEntity<Map<String, Object>> saveTalentShow(@RequestBody RequestTalentShowSaveDTO requestTalentShowSaveDTO){

        // 연예인 공연 저장 service 실행
        UUID talentId = talentShowService.saveTalentShow(requestTalentShowSaveDTO);

        // 연예인 공연 저장 성공 여부 설정
        boolean success = (talentId == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "연예인 공연 저장 성공" : "연예인 공연 저장 시 DAO 생성 실패");
        requestMap.put("talentId", talentId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }

}
