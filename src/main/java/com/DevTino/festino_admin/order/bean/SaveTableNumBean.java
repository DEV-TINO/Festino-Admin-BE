package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.order.bean.small.DeleteTableNumDAOBean;
import com.DevTino.festino_admin.order.bean.small.GetTableNumDAOBean;
import com.DevTino.festino_admin.order.bean.small.SaveTableNumDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.RequestTableNumSaveDTO;
import com.DevTino.festino_admin.order.domain.DTO.TableNumDTO;
import com.DevTino.festino_admin.order.domain.TableNumDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class SaveTableNumBean {

    GetTableNumDAOBean getTableNumDAOBean;
    DeleteTableNumDAOBean deleteTableNumDAOBean;
    SaveTableNumDAOBean saveTableNumDAOBean;

    @Autowired
    public SaveTableNumBean(GetTableNumDAOBean getTableNumDAOBean, DeleteTableNumDAOBean deleteTableNumDAOBean, SaveTableNumDAOBean saveTableNumDAOBean) {
        this.getTableNumDAOBean = getTableNumDAOBean;
        this.deleteTableNumDAOBean = deleteTableNumDAOBean;
        this.saveTableNumDAOBean = saveTableNumDAOBean;
    }



    public UUID exec(RequestTableNumSaveDTO requestTableNumSaveDTO) {

        UUID boothId = requestTableNumSaveDTO.getBoothId();

        // boothId로 테이블 번호 인덱스로 정렬해서 찾기
        List<TableNumDAO> tableNumDAOList = getTableNumDAOBean.exec(boothId);

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
                    .build();
            newTableNumDAOList.add(tableNumDAO);
        }

        saveTableNumDAOBean.exec(newTableNumDAOList);

        return boothId;
    }
}
