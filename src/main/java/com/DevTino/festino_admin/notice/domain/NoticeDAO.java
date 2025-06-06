package com.DevTino.festino_admin.notice.domain;

import com.DevTino.festino_admin.booth.others.StringConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
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

    @Convert(converter = StringConverter.class)
    List<String> imageUrl;
    String content;
    Boolean isPin;
    LocalDateTime createAt;
    LocalDateTime updateAt;

}
