package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.*;
import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderFinishUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderFinishUpdateDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import com.DevTino.festino_admin.order.domain.OrderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateOrderFinishBean {

    GetOrderDAOBean getOrderDAOBean;
    GetCooksDAOBean getCooksDAOBean;
    SaveCookDAOBean saveCookDAOBean;
    SaveOrderDAOBean saveOrderDAOBean;
    CreateOrderFinishUpdateDTOBean createOrderFinishUpdateDTOBean;

    @Autowired
    public UpdateOrderFinishBean(GetOrderDAOBean getOrderDAOBean, GetCooksDAOBean getCooksDAOBean, SaveCookDAOBean saveCookDAOBean, SaveOrderDAOBean saveOrderDAOBean, CreateOrderFinishUpdateDTOBean createOrderFinishUpdateDTOBean){
        this.getOrderDAOBean = getOrderDAOBean;
        this.getCooksDAOBean = getCooksDAOBean;
        this.saveCookDAOBean = saveCookDAOBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
        this.createOrderFinishUpdateDTOBean = createOrderFinishUpdateDTOBean;
    }



    // Order 조리 완료
    public ResponseOrderFinishUpdateDTO exec(RequestOrderFinishUpdateDTO requestOrderFinishUpdateDTO){

        // orderId로 해당 Order DAO 찾기
        OrderDAO orderDAO = getOrderDAOBean.exec(requestOrderFinishUpdateDTO.getOrderId());
        if (orderDAO == null) return null;

        // DTO / DAO의 OrderType 비교, 다르다면 null 리턴
        if (!orderDAO.getOrderType().name().equals(requestOrderFinishUpdateDTO.getOrderType())) return null;

        // orderId에 해당하는 Cook DAO 모두 찾아서 isFinish를 true로 변경
        List<CookDAO> cookDAOList = getCooksDAOBean.exec(orderDAO.getOrderId());
        for (CookDAO cookDAO : cookDAOList){ cookDAO.setIsFinish(true); }

        // 변경된 cookDAOList 저장
        saveCookDAOBean.exec(cookDAOList);

        // DAO 수정
        orderDAO.setOrderType(OrderType.FINISH);

        // 수정된 DAO 저장
        saveOrderDAOBean.exec(orderDAO);

        // DTO 설정 및 반환
        return createOrderFinishUpdateDTOBean.exec(orderDAO);

    }


}
