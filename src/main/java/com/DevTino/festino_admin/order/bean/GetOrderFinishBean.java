package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderFinishGetDTOBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderFinishDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderFinishGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetOrderFinishBean {

    GetOrderFinishDAOBean getOrderFinishDAOBean;
    CreateOrderFinishGetDTOBean createOrderFinishGetDTOBean;

    @Autowired
    public GetOrderFinishBean(GetOrderFinishDAOBean getOrderFinishDAOBean, CreateOrderFinishGetDTOBean createOrderFinishGetDTOBean){
        this.getOrderFinishDAOBean = getOrderFinishDAOBean;
        this.createOrderFinishGetDTOBean = createOrderFinishGetDTOBean;
    }



    // 조리완료 주문 조회
    public List<ResponseOrderFinishGetDTO> exec(){

        // 입금 대기 중인 Order 최신순 전체 조회 -> DAO 리스트
        List<OrderDAO> daoList = getOrderFinishDAOBean.exec();
        if (daoList == null) return null;

        // 반환할 DTO 리스트 생성
        List<ResponseOrderFinishGetDTO> dtoList = new ArrayList<>();

        // DAO 리스트를 DTO 리스트로 변환
        for (OrderDAO orderDAO : daoList){

            dtoList.add(createOrderFinishGetDTOBean.exec(orderDAO));

        }

        // 생성된 DTO 리스트 반환
        return dtoList;

    }

}
