package com.DevTino.festino_admin.order.domain;

import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
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
public class MachineCookDAO {
    @Id
    UUID cookId;
    UUID orderId;
    UUID boothId;
    UUID menuId;
    Integer tableNum;
    Integer date;
    Integer totalCount;
    Integer servedCount;
    LocalDateTime createAt;
    Boolean isFinish;

    public static MachineCookDAO fromCookDTO(CookDTO cookDTO) {
        return MachineCookDAO.builder()
                .cookId(cookDTO.getCookId())
                .orderId(cookDTO.getOrderId())
                .boothId(cookDTO.getBoothId())
                .menuId(cookDTO.getMenuId())
                .tableNum(cookDTO.getTableNum())
                .date(cookDTO.getDate())
                .totalCount(cookDTO.getTotalCount())
                .servedCount(cookDTO.getServedCount())
                .createAt(cookDTO.getCreateAt())
                .isFinish(cookDTO.getIsFinish())
                .build();
    }
}
