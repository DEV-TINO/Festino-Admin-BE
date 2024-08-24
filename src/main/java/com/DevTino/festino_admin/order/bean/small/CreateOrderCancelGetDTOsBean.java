package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderCancelGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateOrderCancelGetDTOsBean {

    CreateOrderCancelGetDTOBean createOrderCancelGetDTOBean;

    @Autowired
    public CreateOrderCancelGetDTOsBean(CreateOrderCancelGetDTOBean createOrderCancelGetDTOBean){
        this.createOrderCancelGetDTOBean = createOrderCancelGetDTOBean;
    }



    // DAO 리스트를 DTO 리스트로 변환
    public List<ResponseOrderCancelGetDTO> exec(List<OrderDTO> dtoList){

        // 반환할 DTO 리스트 생성
        List<ResponseOrderCancelGetDTO> responseOrderCancelGetDTOList = new ArrayList<>();

        // DAO 리스트를 DTO 리스트로 변환
        for (OrderDTO orderDTO : dtoList){

            responseOrderCancelGetDTOList.add(createOrderCancelGetDTOBean.exec(orderDTO));

        }

        // 생성된 DTO 리스트 반환
        return responseOrderCancelGetDTOList;

    }
}
