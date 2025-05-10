package com.DevTino.festino_admin.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<Map<String, Object>> handleServiceException(ServiceException ex) {

        // 성공 여부 실패로 설정, 예외 메시지 설정
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", false);
        requestMap.put("code", ex.exceptionEnum.getCode());
        requestMap.put("message", ex.getMessage());

        // 응답 리턴
        return ResponseEntity.status(ex.exceptionEnum.getHttpStatus()).body(requestMap);

    }



    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException e) {

        // 성공 여부 실패로 설정, 예외 메시지 설정
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("success", false);
        requestMap.put("code", ExceptionEnum.INTERNAL_ERROR.getCode());
        requestMap.put("message", ExceptionEnum.INTERNAL_ERROR.getMessage());

        // 응답 리턴
        return ResponseEntity.status(ExceptionEnum.INTERNAL_ERROR.getHttpStatus()).body(requestMap);

    }

}
