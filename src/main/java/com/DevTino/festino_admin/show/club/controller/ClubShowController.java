package com.DevTino.festino_admin.show.club.controller;

import com.DevTino.festino_admin.ApiResponse;
import com.DevTino.festino_admin.show.club.domain.DTO.RequestClubShowDeleteDTO;
import com.DevTino.festino_admin.show.club.domain.DTO.RequestClubShowSaveDTO;
import com.DevTino.festino_admin.show.club.domain.DTO.RequestClubShowUpdateDTO;
import com.DevTino.festino_admin.show.club.domain.DTO.ResponseClubShowGetDTO;
import com.DevTino.festino_admin.show.club.service.ClubShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<ApiResponse<Object>> getClubShow(@PathVariable UUID clubId){

        // 동아리 공연 조회 service 실행
        ResponseClubShowGetDTO responseClubShowGetDTO = clubShowService.getClubShow(clubId);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "동아리 공연 조회 성공", responseClubShowGetDTO);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 동아리 공연 전체 조회
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<Object>> getClubShowAll(){

        // 동아리 공연 전체 조회 service 실행
        List<ResponseClubShowGetDTO> clubShowDTOList = clubShowService.getClubShowAll();

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "동아리 공연 전체 조회 성공", clubShowDTOList);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }



    // 동아리 공연 저장
    @PostMapping("")
    public ResponseEntity<ApiResponse<Object>> saveClubShow(@RequestBody RequestClubShowSaveDTO requestClubShowSaveDTO){

        // 동아리 공연 저장 service 실행
        UUID clubId = clubShowService.saveClubShow(requestClubShowSaveDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "동아리 공연 저장 성공", clubId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 동아리 공연 수정
    @PutMapping("")
    public ResponseEntity<ApiResponse<Object>> updateClubShow(@RequestBody RequestClubShowUpdateDTO requestClubShowUpdateDTO){

        // 동아리 공연 수정 service 실행
        UUID clubId = clubShowService.updateClubShow(requestClubShowUpdateDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "동아리 공연 수정 성공", clubId);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }



    // 동아리 공연 삭제
    @DeleteMapping("")
    public ResponseEntity<ApiResponse<Object>> deleteClubShow(@RequestBody RequestClubShowDeleteDTO requestClubShowDeleteDTO){

        // 동아리 공연 삭제 service 실행
        clubShowService.deleteClubShow(requestClubShowDeleteDTO);

        // Map 이용해서 반환값 json 데이터로 변환
        ApiResponse<Object> response = new ApiResponse<>(true, "동아리 공연 삭제 성공", null);

        // status, body 설정해서 응답 리턴
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

}
