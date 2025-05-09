package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderAllGetDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderTableAllGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateOrderTableAllGetDTOsBean {

    CreateOrderTableAllGetDTOBean createOrderTableAllGetDTOBean;

    @Autowired
    public CreateOrderTableAllGetDTOsBean(CreateOrderTableAllGetDTOBean createOrderTableAllGetDTOBean){
        this.createOrderTableAllGetDTOBean = createOrderTableAllGetDTOBean;
    }

    // DAO 리스트를 DTO 리스트로 변환
    public List<ResponseOrderTableAllGetDTO> exec(List<OrderDTO> orderDTOS){

        // 반환할 DTO 리스트 생성
        List<ResponseOrderTableAllGetDTO> responseOrderTableAllGetDTOS = new ArrayList<>();

        // DAO 리스트를 DTO 리스트로 변환
        for (OrderDTO orderDTO : orderDTOS){

            responseOrderTableAllGetDTOS.add(createOrderTableAllGetDTOBean.exec(orderDTO));

        }

        // DTO 리스트 리턴
        return responseOrderTableAllGetDTOS;
    }
}