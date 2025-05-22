package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.GetTableNumDAOBean;
import com.DevTino.festino_admin.order.bean.small.SaveTableNumDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.RequestAllTableNumPriorityUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestTableNumPriorityUpdateDTO;
import com.DevTino.festino_admin.order.domain.TableNumDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class UpdateTableNumPriorityBean {

    GetTableNumDAOBean getTableNumDAOBean;
    SaveTableNumDAOBean saveTableNumDAOBean;

    @Autowired
    public UpdateTableNumPriorityBean(GetTableNumDAOBean getTableNumDAOBean, SaveTableNumDAOBean saveTableNumDAOBean) {
        this.getTableNumDAOBean = getTableNumDAOBean;
        this.saveTableNumDAOBean = saveTableNumDAOBean;
    }

    // 테이블 시각화 시 순서 변경
    public UUID exec(RequestAllTableNumPriorityUpdateDTO requestAllTableNumPriorityUpdateDTO) {

        UUID boothId = requestAllTableNumPriorityUpdateDTO.getBoothId();
        List<RequestTableNumPriorityUpdateDTO> tableNumPriorityList = requestAllTableNumPriorityUpdateDTO.getTableNumPriorityList();

        // 전체 tableNumPriorityList를 순회하며
        // TableNumIndex랑 boothId로 tableNumDAO를 가져온다.
        // 해당 DAO의 priority를 업데이트 한다.
        for (RequestTableNumPriorityUpdateDTO requestTableNumPriorityUpdateDTO : tableNumPriorityList) {
            TableNumDAO tableNumDAO = getTableNumDAOBean.exec(boothId, requestTableNumPriorityUpdateDTO.getTableNumIndex());
            tableNumDAO.setTablePriority(requestTableNumPriorityUpdateDTO.getTablePriority());
            saveTableNumDAOBean.exec(tableNumDAO);
        }

        return boothId;

    }
}
