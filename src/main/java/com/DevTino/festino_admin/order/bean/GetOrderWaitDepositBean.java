package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderWaitDepositGetDTOsBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderWaitDepositDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderWaitDepositGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetOrderWaitDepositBean {

    GetOrderWaitDepositDAOBean getOrderWaitDepositDAOBean;
    CreateOrderWaitDepositGetDTOsBean createOrderWaitDepositGetDTOsBean;

    @Autowired
    public GetOrderWaitDepositBean(GetOrderWaitDepositDAOBean getOrderWaitDepositDAOBean, CreateOrderWaitDepositGetDTOsBean createOrderWaitDepositGetDTOsBean){
        this.getOrderWaitDepositDAOBean = getOrderWaitDepositDAOBean;
        this.createOrderWaitDepositGetDTOsBean = createOrderWaitDepositGetDTOsBean;
    }



    // 입금대기 주문 조회
    public List<ResponseOrderWaitDepositGetDTO> exec(){

        // 입금 대기 중인 Order 최신순 전체 조회 -> DAO 리스트
        List<OrderDAO> daoList = getOrderWaitDepositDAOBean.exec();
        if (daoList == null) return null;

        // DAO 리스트를 DTO 리스트로 변환해 리턴
        return createOrderWaitDepositGetDTOsBean.exec(daoList);

    }

}
