package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderAllGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateOrderAllGetDTOsBean {

    CreateOrderAllGetDTOBean createOrderAllGetDTOBean;

    @Autowired
    public CreateOrderAllGetDTOsBean(CreateOrderAllGetDTOBean createOrderAllGetDTOBean){
        this.createOrderAllGetDTOBean = createOrderAllGetDTOBean;
    }



    // DAO 리스트를 DTO 리스트로 변환
    public List<ResponseOrderAllGetDTO> exec(List<OrderDAO> daoList){

        // 반환할 DTO 리스트 생성
        List<ResponseOrderAllGetDTO> dtoList = new ArrayList<>();

        // DAO 리스트를 DTO 리스트로 변환
        for (OrderDAO orderDAO : daoList){

            dtoList.add(createOrderAllGetDTOBean.exec(orderDAO));

        }

        // DTO 리스트 리턴
        return dtoList;
    }

}
