package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.DTO.TableNumDTO;
import com.DevTino.festino_admin.order.domain.TableNumDAO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class CheckFieldMatchingTableNumBean {

    public TableNumDAO exec(List<TableNumDAO> tableNumDAOList, TableNumDTO tableNumDTO){
        for (TableNumDAO tableNumDAO : tableNumDAOList) {
            if (Objects.equals(tableNumDAO.getTableNumIndex(), tableNumDTO.getTableNumIndex()) &&
                    Objects.equals(tableNumDAO.getCustomTableNum(), tableNumDTO.getCustomTableNum())) {
                return tableNumDAO;
            }
        }
        return null;
    }
}
