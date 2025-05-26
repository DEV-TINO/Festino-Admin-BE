package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.DateTimeUtils;
import com.DevTino.festino_admin.order.bean.small.DeleteTableNumDAOBean;
import com.DevTino.festino_admin.order.bean.small.GetTableNumDAOBean;
import com.DevTino.festino_admin.order.bean.small.SaveTableNumDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.RequestTableNumSaveDTO;
import com.DevTino.festino_admin.order.domain.DTO.TableNumDTO;
import com.DevTino.festino_admin.order.domain.TableNumDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SaveTableNumBean {

    DeleteTableNumDAOBean deleteTableNumDAOBean;
    SaveTableNumDAOBean saveTableNumDAOBean;

    @Autowired
    public SaveTableNumBean(DeleteTableNumDAOBean deleteTableNumDAOBean, SaveTableNumDAOBean saveTableNumDAOBean) {

        this.deleteTableNumDAOBean = deleteTableNumDAOBean;
        this.saveTableNumDAOBean = saveTableNumDAOBean;
    }

    public UUID exec(RequestTableNumSaveDTO requestTableNumSaveDTO) {

        UUID boothId = requestTableNumSaveDTO.getBoothId();

        // 싹 다 삭제
        deleteTableNumDAOBean.exec(boothId);

        List<TableNumDTO> tableNumDTOList = requestTableNumSaveDTO.getTableNumList();

        List<TableNumDAO> newTableNumDAOList = new ArrayList<>();

        // 전체 저장
        for (TableNumDTO tableNumDTO : tableNumDTOList) {
            TableNumDAO tableNumDAO = TableNumDAO.builder()
                    .boothId(boothId)
                    .tableNumIndex(tableNumDTO.getTableNumIndex())
                    .customTableNum(tableNumDTO.getCustomTableNum())
                    .orderUrl("https://festino.dev-tino.com/order/" + boothId + "/" + tableNumDTO.getTableNumIndex())
                    .createAt(DateTimeUtils.nowZone())
                    .updateAt(DateTimeUtils.nowZone())
                    .build();
            newTableNumDAOList.add(tableNumDAO);
        }

        saveTableNumDAOBean.exec(newTableNumDAOList);

        return boothId;
    }
}
