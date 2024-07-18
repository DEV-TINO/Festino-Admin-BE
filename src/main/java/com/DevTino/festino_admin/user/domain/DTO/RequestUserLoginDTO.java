package com.DevTino.festino_admin.user.domain.DTO;

import lombok.Data;

@Data
public class RequestUserLoginDTO {
    String adminId;
    String passWord;
}