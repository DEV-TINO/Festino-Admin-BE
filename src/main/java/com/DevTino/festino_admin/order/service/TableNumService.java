package com.DevTino.festino_admin.order.service;

import com.DevTino.festino_admin.order.bean.GetTableNumBean;
import com.DevTino.festino_admin.order.bean.SaveTableNumBean;
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

    @Autowired
    public TableNumService(GetTableNumBean getTableNumBean, SaveTableNumBean saveTableNumBean) {
        this.getTableNumBean = getTableNumBean;
        this.saveTableNumBean = saveTableNumBean;
    }

    public List<ResponseTableNumGetDTO> getTableNum(UUID boothId) {
        return getTableNumBean.exec(boothId);
    }

    public UUID saveTableNum(RequestTableNumSaveDTO requestTableNumSaveDTO) {
        return saveTableNumBean.exec(requestTableNumSaveDTO);
    }
}
