package com.DevTino.festino_admin.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ExceptionEnum {

    // 커스텀 예외
    ENTITY_NOT_FOUND(HttpStatus.NOT_FOUND, "E001", "해당 데이터를 찾을 수 없습니다."),
    EMPTY_LIST(HttpStatus.NO_CONTENT, "E002", "조건에 해당하는 항목이 없습니다."),
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "E003", "입력값이 올바르지 않습니다."),
    STATUS_MISMATCH(HttpStatus.CONFLICT, "E004", "상태 정보가 일치하지 않습니다."),
    ALREADY_PROCESSED(HttpStatus.CONFLICT, "E005", "이미 처리된 요청입니다."),
    BOOTH_CLOSED(HttpStatus.FORBIDDEN, "E006", "부스가 닫혀 있습니다."),
    ORDER_DISABLED(HttpStatus.FORBIDDEN, "E007", "주문이 비활성화된 상태입니다."),
    RESERVATION_ALREADY_EXIST(HttpStatus.CONFLICT, "E008", "이미 예약이 존재합니다."),
    PASSWORD_MISMATCH(HttpStatus.UNAUTHORIZED, "E009", "비밀번호가 일치하지 않습니다."),
    DUPLICATE_TABLE_INDEX(HttpStatus.BAD_REQUEST, "E010", "중복된 테이블 번호(index)가 존재합니다."),


    // 공통 예외
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E999", "서버 오류가 발생했습니다. 잠시 후 다시 시도해 주세요.");



    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    ExceptionEnum(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

}