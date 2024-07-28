package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.*;
import com.DevTino.festino_admin.order.domain.CookDAO;
import com.DevTino.festino_admin.order.domain.DTO.RequestOrderDepositRestoreUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderDepositRestoreUpdateDTO;
import com.DevTino.festino_admin.order.domain.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UpdateOrderDepositRestoreBean {

    GetOrderDAOBean getOrderDAOBean;
    GetCooksDAOBean getCooksDAOBean;
    DeleteCooksDAOBean deleteCooksDAOBean;
    SaveOrderDAOBean saveOrderDAOBean;
    CreateOrderDepositRestoreUpdateDTOBean createOrderDepositRestoreUpdateDTOBean;

    @Autowired
    public UpdateOrderDepositRestoreBean(GetOrderDAOBean getOrderDAOBean, GetCooksDAOBean getCooksDAOBean, DeleteCooksDAOBean deleteCooksDAOBean, SaveOrderDAOBean saveOrderDAOBean, CreateOrderDepositRestoreUpdateDTOBean createOrderDepositRestoreUpdateDTOBean){
        this.getOrderDAOBean = getOrderDAOBean;
        this.getCooksDAOBean = getCooksDAOBean;
        this.deleteCooksDAOBean = deleteCooksDAOBean;
        this.saveOrderDAOBean = saveOrderDAOBean;
        this.createOrderDepositRestoreUpdateDTOBean = createOrderDepositRestoreUpdateDTOBean;
    }



    // 입금 확인 복구
    public ResponseOrderDepositRestoreUpdateDTO exec(RequestOrderDepositRestoreUpdateDTO requestOrderDepositRestoreUpdateDTO){

        // orderId로 해당 Order DAO 찾기
        OrderDAO orderDAO = getOrderDAOBean.exec(requestOrderDepositRestoreUpdateDTO.getOrderId());

        // orderDAO를 찾을 수 없거나 이미 입금 전 상태인 주문이라면 null 리턴
        if ((orderDAO == null) || (orderDAO.getIsDeposit() == false)) return null;

        // orderId에 해당하는 Cook DAO 모두 검색
        List<CookDAO> cookDAOList = getCooksDAOBean.exec(orderDAO.getOrderId());

        // 검색한 Cook 리스트 삭제
        deleteCooksDAOBean.exec(cookDAOList);

        // DAO 수정
        orderDAO.setIsDeposit(false);

        // 수정된 DAO 저장
        saveOrderDAOBean.exec(orderDAO);

        // 반환할 DTO 생성 및 반환
        return createOrderDepositRestoreUpdateDTOBean.exec(orderDAO);

    }

}
