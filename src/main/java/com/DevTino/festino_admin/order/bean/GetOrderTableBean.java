package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderTableGetDTOsBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderCookingDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderTableGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetOrderTableBean {

    GetOrderCookingDAOBean getOrderCookingDAOBean;
    CreateOrderTableGetDTOsBean createOrderTableGetDTOsBean;

    @Autowired
    public GetOrderTableBean(GetOrderCookingDAOBean getOrderCookingDAOBean, CreateOrderTableGetDTOsBean createOrderTableGetDTOsBean){
        this.getOrderCookingDAOBean = getOrderCookingDAOBean;
        this.createOrderTableGetDTOsBean = createOrderTableGetDTOsBean;
    }



    // 테이블 주문 현황 조회
    public List<ResponseOrderTableGetDTO> exec(Integer date){

        // 해당 날짜의 조리중인 Order 최신순 전체 조회
        List<OrderDAO> orderDAOList = getOrderCookingDAOBean.exec(date);

        // DAO 리스트를 DTO 리스트로 변환해 리턴
        return createOrderTableGetDTOsBean.exec(orderDAOList);

    }

}
