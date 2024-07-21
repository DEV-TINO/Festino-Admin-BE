package com.DevTino.festino_admin.user.domain.DTO;

import com.DevTino.festino_admin.user.domain.CategoryType;
import com.DevTino.festino_admin.user.domain.RoleType;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ResponseUsersGetDTO {
    UUID userId;
    String adminName;
    String adminId;
    String passWord;
    RoleType role;
    CategoryType category;
}
