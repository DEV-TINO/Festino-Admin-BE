package com.DevTino.festino_admin.order.domain;

import com.DevTino.festino_admin.order.domain.DTO.CookDTO;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor(force = true)
@Getter
@Setter
@SuperBuilder
public class ComputerCookDAO extends AbstractCookDAO{

    public static ComputerCookDAO fromCookDTO(CookDTO cookDTO) {
        return ComputerCookDAO.builder()
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
                .isService(cookDTO.getIsService())
                .build();
    }
}
