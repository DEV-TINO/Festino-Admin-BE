package com.DevTino.festino_admin.order.domain.DTO;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class RequestTableNumSaveDTO {
    UUID boothId;
    List<TableNumDTO> tableNumDTOList;
}
