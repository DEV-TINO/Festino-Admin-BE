package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderTableGetDTOBean;
import com.DevTino.festino_admin.order.bean.small.GetCooksDAOBean;
import com.DevTino.festino_admin.order.bean.small.GetOrderCookingDAOBean;
import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderTableGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetOrderTableBean {

    GetOrderCookingDAOBean getOrderCookingDAOBean;
    GetCooksDAOBean getCooksDAOBean;
    CreateOrderTableGetDTOBean createOrderTableGetDTOBean;

    @Autowired
    public GetOrderTableBean(GetOrderCookingDAOBean getOrderCookingDAOBean, GetCooksDAOBean getCooksDAOBean, CreateOrderTableGetDTOBean createOrderTableGetDTOBean){
        this.getOrderCookingDAOBean = getOrderCookingDAOBean;
        this.getCooksDAOBean = getCooksDAOBean;
        this.createOrderTableGetDTOBean = createOrderTableGetDTOBean;
    }



    // 테이블 주문 현황 조회
    public List<ResponseOrderTableGetDTO> exec(){

        // 조리중인 Order 최신순 전체 조회
        List<OrderDAO> orderDAOList = getOrderCookingDAOBean.exec();

        // 반환할 DTO 리스트 생성
        List<ResponseOrderTableGetDTO> dtoList = new ArrayList<>();

        // orderDAO, orderId에 해당하는 Cook 리스트로 DTO 생성해 DTO 리스트에 삽입
        for (OrderDAO orderDAO : orderDAOList){

            // orderId에 해당하는 Cook 검색 -> cookDAOList
            List<CookDAO> cookDAOList = getCooksDAOBean.exec(orderDAO.getOrderId());

            // DTO 생성, DTO 리스트에 삽입
            dtoList.add(createOrderTableGetDTOBean.exec(orderDAO, cookDAOList));
            
        }

        // 생성된 DTO 리스트 반환
        return dtoList;

    }

}
