package com.DevTino.festino_admin.order.service;

import com.DevTino.festino_admin.order.bean.SaveTableNumBean;
import com.DevTino.festino_admin.order.domain.DTO.RequestTableNumSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TableNumService {

    SaveTableNumBean saveTableNumBean;

    @Autowired
    public TableNumService(SaveTableNumBean saveTableNumBean) {
        this.saveTableNumBean = saveTableNumBean;
    }

    public UUID saveTableNum(RequestTableNumSaveDTO requestTableNumSaveDTO) {
        return saveTableNumBean.exec(requestTableNumSaveDTO);
    }
}
