package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderAllGetDTOBean;
import com.DevTino.festino_admin.order.bean.small.GetOrdersDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderAllGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetOrderAllBean {

    GetOrdersDAOBean getOrdersDAOBean;
    CreateOrderAllGetDTOBean createOrderAllGetDTOBean;

    @Autowired
    public GetOrderAllBean(GetOrdersDAOBean getOrdersDAOBean, CreateOrderAllGetDTOBean createOrderAllGetDTOBean){
        this.getOrdersDAOBean = getOrdersDAOBean;
        this.createOrderAllGetDTOBean = createOrderAllGetDTOBean;
    }



    // 주문 전체 조회
    public List<ResponseOrderAllGetDTO> exec(){

        // Order 최신순 전체 조회 -> DAO 리스트
        List<OrderDAO> daoList = getOrdersDAOBean.exec();
        if (daoList == null) return null;

        // 반환할 DTO 리스트 생성
        List<ResponseOrderAllGetDTO> dtoList = new ArrayList<>();

        // DAO 리스트를 DTO 리스트로 변환
        for (OrderDAO orderDAO : daoList){

            dtoList.add(createOrderAllGetDTOBean.exec(orderDAO));

        }

        // 생성된 DTO 리스트 반환
        return dtoList;

    }

}
