package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.TableNumDAO;
import com.DevTino.festino_admin.order.repository.jpa.TableNumRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetTableNumDAOBean {

    TableNumRepositoryJPA tableNumRepositoryJPA;

    @Autowired
    public GetTableNumDAOBean(TableNumRepositoryJPA tableNumRepositoryJPA) {
        this.tableNumRepositoryJPA = tableNumRepositoryJPA;
    }

    /*public TableNumDAO exec(UUID boothId, Integer tableNumIndex) {
        TableNumDAO dao = tableNumRepositoryJPA.findByBoothIdAndTableNumIndex(boothId, tableNumIndex);
        if (dao == null) throw new ServiceException(ExceptionEnum.ENTITY_NOT_FOUND);

        return dao;
    }*/

    public List<TableNumDAO> exec(UUID boothId) {
        return tableNumRepositoryJPA.findAllByBoothIdOrderByTableNumIndexAsc(boothId);
    }
}
