package com.DevTino.festino_admin.show.club.controller;

import com.DevTino.festino_admin.show.club.domain.DTO.RequestClubShowDeleteDTO;
import com.DevTino.festino_admin.show.club.domain.DTO.RequestClubShowSaveDTO;
import com.DevTino.festino_admin.show.club.domain.DTO.RequestClubShowUpdateDTO;
import com.DevTino.festino_admin.show.club.domain.DTO.ResponseClubShowGetDTO;
import com.DevTino.festino_admin.show.club.service.ClubShowService;
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
@RequestMapping("/admin/club/show")
public class ClubShowController {

    ClubShowService clubShowService;
    @Autowired
    public ClubShowController(ClubShowService clubShowService){
        this.clubShowService = clubShowService;
    }



    // 동아리 공연 조회
    @GetMapping("/{clubId}")
    public ResponseEntity<Map<String, Object>> getClubShow(@PathVariable UUID clubId){

        // 동아리 공연 조회 service 실행
        ResponseClubShowGetDTO responseClubShowGetDTO = clubShowService.getClubShow(clubId);

        // 동아리 공연 조회 성공 여부 설정
        boolean success = (responseClubShowGetDTO == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "동아리 공연 조회 성공" : "동아리 공연 조회 시 DAO 검색 실패");
        requestMap.put("clubInfo", responseClubShowGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // 동아리 공연 전체 조회
    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getClubShowAll(){

        // 동아리 공연 전체 조회 service 실행
        List<ResponseClubShowGetDTO> clubShowDTOList = clubShowService.getClubShowAll();

        // 동아리 공연 전체 조회 성공 여부 설정
        boolean success = (clubShowDTOList == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "동아리 공연 전체 조회 성공" : "동아리 공연 전체 조회 시 DAO 검색 실패");
        requestMap.put("clubList", clubShowDTOList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);
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
        requestMap.put("clubId", clubId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // 동아리 공연 수정
    @PutMapping("")
    public ResponseEntity<Map<String, Object>> updateClubShow(@RequestBody RequestClubShowUpdateDTO requestClubShowUpdateDTO){

        // 동아리 공연 수정 service 실행
        UUID clubId = clubShowService.updateClubShow(requestClubShowUpdateDTO);

        // 동아리 공연 수정 성공 여부 설정
        boolean success = (clubId == null) ? false : true;

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "동아리 공연 수정 성공" : "동아리 공연 수정 시 DAO 검색 실패");
        requestMap.put("clubId", clubId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }



    // 동아리 공연 삭제
    @DeleteMapping("")
    public ResponseEntity<Map<String, Object>> deleteClubShow(@RequestBody RequestClubShowDeleteDTO requestClubShowDeleteDTO){

        // 동아리 공연 삭제 service 실행 & 삭제 성공 여부 설정
        boolean success = clubShowService.deleteClubShow(requestClubShowDeleteDTO);

        // Map 이용해서 메시지와 id 값 json 데이터로 변환
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", success);
        requestMap.put("message", success ? "동아리 공연 삭제 성공" : "동아리 공연 삭제 시 DAO 검색 실패");

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(requestMap);

    }

}
