package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import com.DevTino.festino_admin.order.bean.small.GetTableNumDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.ResponseTableNumGetDTO;
import com.DevTino.festino_admin.order.domain.TableNumDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetTableNumBean {

    GetTableNumDAOBean getTableNumDAOBean;

    @Autowired
    public GetTableNumBean(GetTableNumDAOBean getTableNumDAOBean) {
        this.getTableNumDAOBean = getTableNumDAOBean;
    }

    public List<ResponseTableNumGetDTO> exec(UUID boothId) {

        List<TableNumDAO> tableNumDAOList = getTableNumDAOBean.exec(boothId);
        /*if (tableNumDAOList.isEmpty()) throw new ServiceException(ExceptionEnum.EMPTY_LIST);*/

        return tableNumDAOList.stream().map(tableNumDAO -> ResponseTableNumGetDTO.builder()
                .tableNumIndex(tableNumDAO.getTableNumIndex())
                .customTableNum(tableNumDAO.getCustomTableNum())
                .orderUrl(tableNumDAO.getOrderUrl())
                .build()).toList();
    }
}
