package com.DevTino.festino_admin.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDAO {
    @Id
    UUID userId;

    String adminId;
    String passWord;
    String adminName;
    RoleType role;
    CategoryType adminCategory;
}
