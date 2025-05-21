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

@Component
public class SaveTableNumBean {

    GetTableNumDAOBean getTableNumDAOBean;
    DeleteTableNumDAOBean deleteTableNumDAOBean;
    SaveTableNumDAOBean saveTableNumDAOBean;
    CheckFieldMatchingTableNumBean checkFieldMatchingTableNumBean;

    @Autowired
    public SaveTableNumBean(GetTableNumDAOBean getTableNumDAOBean, DeleteTableNumDAOBean deleteTableNumDAOBean, SaveTableNumDAOBean saveTableNumDAOBean, CheckFieldMatchingTableNumBean checkFieldMatchingTableNumBean) {
        this.getTableNumDAOBean = getTableNumDAOBean;
        this.deleteTableNumDAOBean = deleteTableNumDAOBean;
        this.saveTableNumDAOBean = saveTableNumDAOBean;
        this.checkFieldMatchingTableNumBean = checkFieldMatchingTableNumBean;
    }



    public UUID exec(RequestTableNumSaveDTO requestTableNumSaveDTO) {

        UUID boothId = requestTableNumSaveDTO.getBoothId();

        Set<Integer> indexCheck = new HashSet<>();
        for (TableNumDTO dto : requestTableNumSaveDTO.getTableNumList()) {
            if (!indexCheck.add(dto.getTableNumIndex())) {
                throw new ServiceException(ExceptionEnum.DUPLICATE_TABLE_INDEX);
            }
        }

        // boothId, isDelete가 false인 테이블 번호 인덱스로 정렬해서 찾기
        List<TableNumDAO> tableNumDAOList = getTableNumDAOBean.exec(boothId);

        // 모든 테이블 isDelete를 true로 설정 후 저장
        for (TableNumDAO tableNumDAO : tableNumDAOList){
            tableNumDAO.setIsDeleted(true);
        }
        saveTableNumDAOBean.exec(tableNumDAOList);

        List<TableNumDTO> tableNumDTOList = requestTableNumSaveDTO.getTableNumList();

        List<TableNumDAO> newTableNumDAOList = new ArrayList<>();

//        // 전체 저장
//        for (TableNumDTO tableNumDTO : tableNumDTOList) {
//            TableNumDAO tableNumDAO = TableNumDAO.builder()
//                    .boothId(boothId)
//                    .tableNumIndex(tableNumDTO.getTableNumIndex())
//                    .customTableNum(tableNumDTO.getCustomTableNum())
//                    .orderUrl("https://festino.dev-tino.com/order/" + boothId + "/" + tableNumDTO.getTableNumIndex())
//                    .build();
//            newTableNumDAOList.add(tableNumDAO);
//        }

        // 전체 저장
        for (TableNumDTO tableNumDTO : tableNumDTOList){
            TableNumDAO matchedTableNumDAO = checkFieldMatchingTableNumBean.exec(tableNumDAOList, tableNumDTO);

            if (matchedTableNumDAO != null) {
                matchedTableNumDAO.setCustomTableNum(tableNumDTO.getCustomTableNum());
                matchedTableNumDAO.setOrderUrl("https://festino.dev-tino.com/order/" + boothId + "/" + tableNumDTO.getTableNumIndex());
                matchedTableNumDAO.setIsDeleted(false);
                newTableNumDAOList.add(matchedTableNumDAO);
            } else {
                TableNumDAO tableNumDAO = TableNumDAO.builder()
                        .boothId(boothId)
                        .tableNumIndex(tableNumDTO.getTableNumIndex())
                        .customTableNum(tableNumDTO.getCustomTableNum())
                        .orderUrl("https://festino.dev-tino.com/order/" + boothId + "/" + tableNumDTO.getTableNumIndex())
                        .isDeleted(false)
                        .build();
                newTableNumDAOList.add(tableNumDAO);
            }
        }

        saveTableNumDAOBean.exec(newTableNumDAOList);

        return boothId;
    }
}
