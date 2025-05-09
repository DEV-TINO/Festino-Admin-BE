package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.CreateOrderTableAllGetDTOsBean;
import com.DevTino.festino_admin.order.bean.small.GetOrdersTableAllDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.OrderDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseOrderTableAllGetDTO;
import com.DevTino.festino_admin.order.others.BoothNameResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetOrderTableAllBean {

    BoothNameResolver boothNameResolver;
    GetOrdersTableAllDAOBean getOrdersTableAllDAOBean;
    CreateOrderTableAllGetDTOsBean createOrderTableAllGetDTOsBean;

    @Autowired
    public GetOrderTableAllBean(BoothNameResolver boothNameResolver, GetOrdersTableAllDAOBean getOrdersTableAllDAOBean, CreateOrderTableAllGetDTOsBean createOrderTableAllGetDTOsBean) {
        this.boothNameResolver = boothNameResolver;
        this.getOrdersTableAllDAOBean = getOrdersTableAllDAOBean;
        this.createOrderTableAllGetDTOsBean = createOrderTableAllGetDTOsBean;
    }

    public List<ResponseOrderTableAllGetDTO> exec(UUID boothId, Integer tableNum){

        List<OrderDTO> orderDTOS = getOrdersTableAllDAOBean.exec(boothId, tableNum);
        if (orderDTOS == null) return null;

        return createOrderTableAllGetDTOsBean.exec(orderDTOS);
    }
}
