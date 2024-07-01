package com.DevTino.festino_admin.booth.domain.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
public class RequestDayBoothOpenUpdateDTO {
    UUID boothId;
}