package com.DevTino.festino_admin.order.bean;

import com.DevTino.festino_admin.exception.ExceptionEnum;
import com.DevTino.festino_admin.exception.ServiceException;
import com.DevTino.festino_admin.order.bean.small.CheckFieldMatchingTableNumBean;
import com.DevTino.festino_admin.order.bean.small.DeleteTableNumDAOBean;
import com.DevTino.festino_admin.order.bean.small.GetTableNumDAOBean;
import com.DevTino.festino_admin.order.bean.small.SaveTableNumDAOBean;
import com.DevTino.festino_admin.order.domain.DTO.RequestTableNumSaveDTO;
import com.DevTino.festino_admin.order.domain.DTO.TableNumDTO;
import com.DevTino.festino_admin.order.domain.TableNumDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class SaveTableNumBean {

    GetTableNumDAOBean getTableNumDAOBean;
    SaveTableNumDAOBean saveTableNumDAOBean;

    @Autowired
    public SaveTableNumBean(GetTableNumDAOBean getTableNumDAOBean, SaveTableNumDAOBean saveTableNumDAOBean) {
        this.getTableNumDAOBean = getTableNumDAOBean;
        this.saveTableNumDAOBean = saveTableNumDAOBean;
    }


    // 커스텀 테이블 번호 저장
    public UUID exec(RequestTableNumSaveDTO requestTableNumSaveDTO) {

        UUID boothId = requestTableNumSaveDTO.getBoothId();
        List<TableNumDTO> tableNumDTOList = requestTableNumSaveDTO.getTableNumList();

        // 1. 기존 테이블 목록 가져오기
        // boothId로 전부 다 가져와
        List<TableNumDAO> tableNumDAOList = getTableNumDAOBean.exec(boothId);
        Map<Integer, TableNumDAO> existingTableNumDAOMap = tableNumDAOList.stream()
                .collect(Collectors.toMap(TableNumDAO::getTableNumIndex, tableNumDAO -> tableNumDAO));

        // 2. dto에 있는 ID들만 수집
        Set<Integer> newTableNumIndexes = tableNumDTOList.stream()
                .map(TableNumDTO::getTableNumIndex)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());

        // 3. 삭제 처리: 기존에 있는데 dto에는 없는 것들
        for (TableNumDAO tableNumDAO : tableNumDAOList) {
            if (!newTableNumIndexes.contains(tableNumDAO.getTableNumIndex())) {
                tableNumDAO.setIsDeleted(true);
                saveTableNumDAOBean.exec(tableNumDAO);
            }
        }

        // 4. 추가 or 수정 처리
        for (TableNumDTO tableNumDTO : tableNumDTOList) {
            if (tableNumDTO.getTableNumIndex() == null) {
                // 새로 추가
                TableNumDAO tableNumDAO = TableNumDAO.builder()
                        .boothId(boothId)
                        .customTableNum(tableNumDTO.getCustomTableNum())
                        .isDeleted(false)
                        .build();
                saveTableNumDAOBean.exec(tableNumDAO);

                tableNumDAO.setOrderUrl("https://festino.dev-tino.com/order/" + boothId + "/" + tableNumDAO.getTableNumIndex());
                saveTableNumDAOBean.exec(tableNumDAO);
            } else {
                // 수정
                TableNumDAO tableNumDAO = existingTableNumDAOMap.get(tableNumDTO.getTableNumIndex());
                if (tableNumDAO != null && !tableNumDAO.getCustomTableNum().equals(tableNumDTO.getCustomTableNum())) {
                    tableNumDAO.setCustomTableNum(tableNumDTO.getCustomTableNum());
                    saveTableNumDAOBean.exec(tableNumDAO);
                }
            }
        }

        return boothId;
    }
}
