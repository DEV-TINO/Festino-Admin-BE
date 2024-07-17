package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderCancelGetDTOBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderCancelDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderCancelGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetCancelOrdersBean {

    GetOrderCancelDAOBean getOrderCancelDAOBean;
    CreateOrderCancelGetDTOBean createOrderCancelGetDTOBean;

    @Autowired
    public GetCancelOrdersBean(GetOrderCancelDAOBean getOrderCancelDAOBean, CreateOrderCancelGetDTOBean createOrderCancelGetDTOBean){
        this.getOrderCancelDAOBean = getOrderCancelDAOBean;
        this.createOrderCancelGetDTOBean = createOrderCancelGetDTOBean;
    }



    // 취소 주문 조회
    public List<ResponseOrderCancelGetDTO> exec(){

        // 취소된 Order 전체 조회 -> DAO 리스트
        List<OrderDAO> daoList = getOrderCancelDAOBean.exec();
        if (daoList == null) return null;

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
