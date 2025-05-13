package com.DevTino.festino_admin.show.talent.controller;

import com.DevTino.festino_admin.ApiResponse;
import com.DevTino.festino_admin.show.talent.domain.DTO.RequestTalentShowDeleteDTO;
import com.DevTino.festino_admin.show.talent.domain.DTO.RequestTalentShowSaveDTO;
import com.DevTino.festino_admin.show.talent.domain.DTO.RequestTalentShowUpdateDTO;
import com.DevTino.festino_admin.show.talent.domain.DTO.ResponseTalentShowGetDTO;
import com.DevTino.festino_admin.show.talent.service.TalentShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<ApiResponse<Object>> getTalentShow(@PathVariable UUID talentId){

        // 연예인 공연 조회 service 실행
        ResponseTalentShowGetDTO responseTalentShowGetDTO = talentShowService.getTalentShow(talentId);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "연예인 공연 조회 성공", responseTalentShowGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 연예인 공연 전체 조회
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<Object>> getTalentShowAll(){

        // 연예인 공연 전체 조회 service 실행
        List<ResponseTalentShowGetDTO> talentShowDTOList = talentShowService.getTalentShowAll();

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "연예인 공연 전체 조회 성공", talentShowDTOList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



    // 연예인 공연 저장
    @PostMapping("")
    public ResponseEntity<ApiResponse<Object>> saveTalentShow(@RequestBody RequestTalentShowSaveDTO requestTalentShowSaveDTO){

        // 연예인 공연 저장 service 실행
        UUID talentId = talentShowService.saveTalentShow(requestTalentShowSaveDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "연예인 공연 저장 성공", talentId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 연예인 공연 수정
    @PutMapping("")
    public ResponseEntity<ApiResponse<Object>> updateTalentShow(@RequestBody RequestTalentShowUpdateDTO requestTalentShowUpdateDTO){

        // 연예인 공연 수정 service 실행
        UUID talentId = talentShowService.updateTalentShow(requestTalentShowUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "연예인 공연 수정 성공", talentId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 연예인 공연 삭제
    @DeleteMapping("")
    public ResponseEntity<ApiResponse<Object>> deleteTalentShow(@RequestBody RequestTalentShowDeleteDTO requestTalentShowDeleteDTO){

        // 연예인 공연 삭제 service 실행 & 삭제 성공 여부 설정
        talentShowService.deleteTalentShow(requestTalentShowDeleteDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "연예인 공연 삭제 성공", null);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
