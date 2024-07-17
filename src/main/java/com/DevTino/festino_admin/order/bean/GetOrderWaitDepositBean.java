package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderWaitDepositGetDTOBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderWaitDepositDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderWaitDepositGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetOrderWaitDepositBean {

    GetOrderWaitDepositDAOBean getOrderWaitDepositDAOBean;
    CreateOrderWaitDepositGetDTOBean createOrderWaitDepositGetDTOBean;

    @Autowired
    public GetOrderWaitDepositBean(GetOrderWaitDepositDAOBean getOrderWaitDepositDAOBean, CreateOrderWaitDepositGetDTOBean createOrderWaitDepositGetDTOBean){
        this.getOrderWaitDepositDAOBean = getOrderWaitDepositDAOBean;
        this.createOrderWaitDepositGetDTOBean = createOrderWaitDepositGetDTOBean;
    }



    // 입금대기 주문 조회
    public List<ResponseOrderWaitDepositGetDTO> exec(){

        // 입금 대기 중인 Order 전체 조회 -> DAO 리스트
        List<OrderDAO> daoList = getOrderWaitDepositDAOBean.exec();
        if (daoList == null) return null;

        // 반환할 DTO 리스트 생성
        List<ResponseOrderWaitDepositGetDTO> dtoList = new ArrayList<>();

        // DAO 리스트를 DTO 리스트로 변환
        for (OrderDAO orderDAO : daoList){

            dtoList.add(createOrderWaitDepositGetDTOBean.exec(orderDAO));

        }

        // 생성된 DTO 리스트 반환
        return dtoList;

    }

}
