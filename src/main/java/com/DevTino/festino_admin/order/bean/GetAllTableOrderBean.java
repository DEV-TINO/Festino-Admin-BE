package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.GetAllTableOrderDAOBean;
import com.DevTino.festino_admin.order.bean.small.GetTableNumDAOBean;
import com.DevTino.festino_admin.order.bean.small.GetTableNumDeleteCheckDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseAllTableOrderGetDTO;
import com.DevTino.festino_admin.order.domain.OrderType;
import com.DevTino.festino_admin.order.domain.TableNumDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GetAllTableOrderBean {

    GetTableNumDeleteCheckDAOBean getTableNumDeleteCheckDAOBean;
    GetAllTableOrderDAOBean getAllTableOrderDAOBean;

    @Autowired
    public GetAllTableOrderBean(GetTableNumDeleteCheckDAOBean getTableNumDeleteCheckDAOBean, GetAllTableOrderDAOBean getAllTableOrderDAOBean) {
        this.getTableNumDeleteCheckDAOBean = getTableNumDeleteCheckDAOBean;
        this.getAllTableOrderDAOBean = getAllTableOrderDAOBean;
    }

    // 테이블 시각화에 따른 전체 테이블 주문 조회
    public List<ResponseAllTableOrderGetDTO> exec(UUID boothId, Integer date){

        // 일단 해당 학과에 모든 테이블을 가져와
        List<TableNumDAO> tableNumDAOList = getTableNumDeleteCheckDAOBean.exec(boothId);

        // 최근 한시간에 주문을 테이블 번호로 정렬해서 가져와
        List<OrderDTO> orderDTOList = getAllTableOrderDAOBean.exec(boothId, date);

        // 테이블 번호 기준으로 그룹핑
        Map<Integer, List<OrderDTO>> tableOrderMap = new HashMap<>();
        for (OrderDTO order : orderDTOList) {
            tableOrderMap.computeIfAbsent(order.getTableNum(), k -> new ArrayList<>()).add(order);
        }

        List<ResponseAllTableOrderGetDTO> responseAllTableOrderGetDTOS = new ArrayList<>();

        for (TableNumDAO table : tableNumDAOList) {
            Integer tableNum = table.getTableNumIndex();
            List<OrderDTO> tableOrderList = tableOrderMap.getOrDefault(tableNum, new ArrayList<>());

            String type = "ready";
            // 1. 입금 대기 상태
            OrderDTO selectedOrder = tableOrderList.stream()
                    .filter(order -> Boolean.FALSE.equals(order.getIsDeposit()))
                    .findFirst()
                    .orElse(null);

            // 2. 조리중 상태
            if (selectedOrder == null) {
                type = "cooking";
                selectedOrder = tableOrderList.stream()
                        .filter(order -> Boolean.TRUE.equals(order.getIsDeposit()) &&
                                OrderType.COOKING.equals(order.getOrderType()))
                        .findFirst()
                        .orElse(null);
            }

            // 3. 최근 주문 (리스트가 이미 정렬된 상태라면 마지막이 최신)
            if (selectedOrder == null && !tableOrderList.isEmpty()) {
                type = "complete";
                selectedOrder = tableOrderList.get(tableOrderList.size() - 1);
            }

            if (tableOrderList.isEmpty()) {
                type = "complete";
            }

            responseAllTableOrderGetDTOS.add(ResponseAllTableOrderGetDTO.builder()
                    .tableNumIndex(tableNum)
                    .type(type)
                    .orderInfo(selectedOrder)
                    .build());
        }

        return responseAllTableOrderGetDTOS;

        // 1. 1번 테이블부터 확인해서 1번 테이블 주문에서 입금대기 상태인 주문이 있으면 해당 주문 보여줌
        // orderDTO에서 isDeposit 필드가 false인 주문이 입금대기 상태
        // List<OrderDTO>가 이미 테이블 번호로 정렬이 되어있음
        // TableNumDAO의 테이블 번호를 가져와서 orderDTOList에서 해당 테이블 번호의 주문을 찾음
        // 가장 오래전부터 하나씩 확인해서 isDeposit 필드가 false인 주문이 있으면 해당 주문을 보여줌

        // 2. 1번 테이블 주문에서 조리중 상태인 주문이 있으면 해당 주문 보여줌
        // orderDTO에서 isDeposit 필드가 true이고 OrderType orderType 이 COOKING인 주문이 조리중 상태
        // 가장 오래전부터 하나씩 확인해서 isDeposit 필드가 true이고 OrderType orderType 이 COOKING인 주문이 있으면 해당 주문을 보여줌

        // 3. 아무것도 없거나 1번 2번이 해당이 안되면 마지막 주문을 보여줌
        // 가장 최근 주문을 가져옴

        // 이렇게 List<TableNumDAO>를 반복함

        /*tableInfo : [
                    {
                        tableNumIndex: 1,
                        order: {

                    }

                ]*/
        // 이런식으로 표현하고 싶어

    }
}
