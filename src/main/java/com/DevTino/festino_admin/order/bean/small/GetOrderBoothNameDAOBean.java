package com.DevTino.festino_admin.order.bean.small;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetOrderBoothNameDAOBean {

    // 부스 id로 이름 가져오기
    public String exec(UUID boothId) {
        return switch (boothId.toString()) {
            case "bcb6ddc2-1116-4729-a643-fa8f3bb5408f" -> "computer";
            case "8414328c-f765-4741-bf22-59f5a52e06bf" -> "game";
            case "3aacd1de-57c1-4685-a94a-63c1664f51bf" -> "new_material";
            case "71ced602-eb69-4e0e-96cd-3bcded85fd76" -> "machine";
            case "5167a573-3a5f-4b40-ab9e-22c8fdf16c84" -> "energy";
            case "f0fe6e61-e530-4606-a003-cf224833b11b" -> "electronics";
            case "3d6eda5d-d9fd-427e-9335-61e70754f7fe" -> "nano";
            default -> "";
        };
    }
}
