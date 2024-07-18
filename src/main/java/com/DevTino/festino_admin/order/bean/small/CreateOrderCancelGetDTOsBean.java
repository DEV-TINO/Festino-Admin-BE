package com.DevTino.festino_admin.order.bean.small;

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
    public List<ResponseOrderCancelGetDTO> exec(List<OrderDAO> daoList){

        // 반환할 DTO 리스트 생성
        List<ResponseOrderCancelGetDTO> dtoList = new ArrayList<>();

        // DAO 리스트를 DTO 리스트로 변환
        for (OrderDAO orderDAO : daoList){

            dtoList.add(createOrderCancelGetDTOBean.exec(orderDAO));

        }

        // 생성된 DTO 리스트 반환
        return dtoList;

    }
}
