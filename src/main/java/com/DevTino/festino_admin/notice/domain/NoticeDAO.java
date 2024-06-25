package com.DevTino.festino_admin.notice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NoticeDAO {

    @Id
    UUID noticeId;

    String title;
    String writerName;
    String imageUrl;
    String content;
    Boolean isPin;
    LocalDateTime createAt;
    LocalDateTime updateAt;

}
