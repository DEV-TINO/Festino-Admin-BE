package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderTableGetDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateOrderTableGetDTOsBean {

    GetCooksDAOBean getCooksDAOBean;
    CreateOrderTableGetDTOBean createOrderTableGetDTOBean;

    @Autowired
    public CreateOrderTableGetDTOsBean(GetCooksDAOBean getCooksDAOBean, CreateOrderTableGetDTOBean createOrderTableGetDTOBean){
        this.getCooksDAOBean = getCooksDAOBean;
        this.createOrderTableGetDTOBean = createOrderTableGetDTOBean;
    }



    // DAO 리스트를 DTO 리스트로 변환
    public List<ResponseOrderTableGetDTO> exec(List<OrderDAO> orderDAOList){

        // 반환할 DTO 리스트 생성
        List<ResponseOrderTableGetDTO> dtoList = new ArrayList<>();

        // DAO 리스트를 DTO 리스트로 변환
        for (OrderDAO orderDAO : orderDAOList){

            // orderId에 해당하는 Cook 검색 -> cookDAOList
            List<CookDAO> cookDAOList = getCooksDAOBean.exec(orderDAO.getOrderId());

            // orderDAO, cookDAOList의 정보로 DTO 생성해 DTO 리스트에 삽입
            dtoList.add(createOrderTableGetDTOBean.exec(orderDAO, cookDAOList));

        }

        // DTO 리스트 리턴
        return dtoList;

    }
}
