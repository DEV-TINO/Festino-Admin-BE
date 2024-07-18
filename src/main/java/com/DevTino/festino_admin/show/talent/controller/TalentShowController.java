package com.DevTino.festino_admin.show.talent.controller;

import com.DevTino.festino_admin.show.talent.domain.DTO.RequestTalentShowDeleteDTO;
import com.DevTino.festino_admin.show.talent.domain.DTO.RequestTalentShowSaveDTO;
import com.DevTino.festino_admin.show.talent.domain.DTO.RequestTalentShowUpdateDTO;
import com.DevTino.festino_admin.show.talent.domain.DTO.ResponseTalentShowGetDTO;
import com.DevTino.festino_admin.show.talent.service.TalentShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
// @CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/admin/talent/show")
public class TalentShowController {

    TalentShowService talentShowService;

    @Autowired
    public TalentShowController(TalentShowService talentShowService){
        this.talentShowService = talentShowService;
    }



    // 연예인 공연 조회
    @GetMapping("/{talentId}")
    public ResponseEntity<Map<String, Object>> getTalentShow(@PathVariable UUID talentId){

        // 연예인 공연 조회 service 실행
        ResponseTalentShowGetDTO responseTalentShowGetDTO = talentShowService.getTalentShow(talentId);

        // 연예인 공연 조회 성공 여부 설정
        boolean success = (responseTalentShowGetDTO == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "연예인 공연 조회 성공" : "연예인 공연 조회 시 DAO 검색 실패");
        requestMap.put("talentInfo", responseTalentShowGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // 연예인 공연 전체 조회
    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getTalentShowAll(){

        // 연예인 공연 전체 조회 service 실행
        List<ResponseTalentShowGetDTO> talentShowDTOList = talentShowService.getTalentShowAll();

        // 연예인 공연 전체 조회 성공 여부 설정
        boolean success = (talentShowDTOList == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "연예인 공연 전체 조회 성공" : "연예인 공연 전체 조회 시 DAO 검색 실패");
        requestMap.put("talentList", talentShowDTOList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
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



    // 연예인 공연 수정
    @PutMapping("")
    public ResponseEntity<Map<String, Object>> updateTalentShow(@RequestBody RequestTalentShowUpdateDTO requestTalentShowUpdateDTO){

        // 연예인 공연 수정 service 실행
        UUID talentId = talentShowService.updateTalentShow(requestTalentShowUpdateDTO);

        // 동아리 공연 수정 성공 여부 설정
        boolean success = (talentId == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "연예인 공연 수정 성공" : "연예인 공연 수정 시 DAO 검색 실패");
        requestMap.put("talentId", talentId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // 연예인 공연 삭제
    @DeleteMapping("")
    public ResponseEntity<Map<String, Object>> deleteTalentShow(@RequestBody RequestTalentShowDeleteDTO requestTalentShowDeleteDTO){

        // 연예인 공연 삭제 service 실행 & 삭제 성공 여부 설정
        boolean success = talentShowService.deleteTalentShow(requestTalentShowDeleteDTO);

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "연예인 공연 삭제 성공" : "연예인 공연 삭제 시 DAO 검색 실패");

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }

}
