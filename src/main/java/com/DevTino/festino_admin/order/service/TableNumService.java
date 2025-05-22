package com.DevTino.festino_admin.order.service;

import com.DevTino.festino_admin.order.bean.GetTableNumBean;
import com.DevTino.festino_admin.order.bean.SaveTableNumBean;
import com.DevTino.festino_admin.order.bean.UpdateTableNumPriorityBean;
import com.DevTino.festino_admin.order.domain.DTO.RequestAllTableNumPriorityUpdateDTO;
import com.DevTino.festino_admin.order.domain.DTO.RequestTableNumSaveDTO;
import com.DevTino.festino_admin.order.domain.DTO.ResponseTableNumGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TableNumService {

    GetTableNumBean getTableNumBean;
    SaveTableNumBean saveTableNumBean;
    UpdateTableNumPriorityBean updateTableNumPriorityBean;

    @Autowired
    public TableNumService(GetTableNumBean getTableNumBean, SaveTableNumBean saveTableNumBean, UpdateTableNumPriorityBean updateTableNumPriorityBean) {
        this.getTableNumBean = getTableNumBean;
        this.saveTableNumBean = saveTableNumBean;
        this.updateTableNumPriorityBean = updateTableNumPriorityBean;
    }

    // 전체 테이블 조회
    public List<ResponseTableNumGetDTO> getTableNum(UUID boothId) {
        return getTableNumBean.exec(boothId);
    }

    // 테이블 저장
    public UUID saveTableNum(RequestTableNumSaveDTO requestTableNumSaveDTO) {
        return saveTableNumBean.exec(requestTableNumSaveDTO);
    }

    // 테이블 우선순위 수정
    public UUID updateTableNumPriority(RequestAllTableNumPriorityUpdateDTO requestAllTableNumPriorityUpdateDTO) {
        return updateTableNumPriorityBean.exec(requestAllTableNumPriorityUpdateDTO);
    }
}
