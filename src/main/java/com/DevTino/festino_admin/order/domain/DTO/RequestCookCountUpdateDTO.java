package com.DevTino.festino_admin.order.domain.DTO;

import lombok.Data;
import java.util.UUID;

@Data
public class RequestCookCountUpdateDTO {

    UUID cookId;
    Integer servedCount;

}