package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderCancelGetDTOsBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderCancelDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderCancelGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetOrderCancelBean {

    GetOrderCancelDAOBean getOrderCancelDAOBean;
    CreateOrderCancelGetDTOsBean createOrderCancelGetDTOsBean;

    @Autowired
    public GetOrderCancelBean(GetOrderCancelDAOBean getOrderCancelDAOBean, CreateOrderCancelGetDTOsBean createOrderCancelGetDTOsBean){
        this.getOrderCancelDAOBean = getOrderCancelDAOBean;
        this.createOrderCancelGetDTOsBean = createOrderCancelGetDTOsBean;
    }



    // 취소 주문 조회
    public List<ResponseOrderCancelGetDTO> exec(Integer date){

        // 해당 날짜의 취소된 Order 최신순 전체 조회 -> DAO 리스트
        List<OrderDAO> daoList = getOrderCancelDAOBean.exec(date);
        if (daoList == null) return null;

        // DAO 리스트를 DTO 리스트로 변환해 리턴
        return createOrderCancelGetDTOsBean.exec(daoList);

    }

}
