package com.DevTino.festino_admin.order.domain.DTO;

import com.DevTino.festino_admin.order.others.StringListConverter;
import jakarta.persistence.Convert;
import lombok.Data;

import java.util.List;

@Data
public class RequestOrderServiceSaveDTO {

    Integer tableNum;

    @Convert(converter = StringListConverter.class)
    List<MenuInfoDTO> menuInfo;

    Integer totalPrice;
    Boolean isCoupon;

}
