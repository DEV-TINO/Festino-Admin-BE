package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.repository.TableNumRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteTableNumDAOBean {

    TableNumRepositoryJPA tableNumRepositoryJPA;

    @Autowired
    public DeleteTableNumDAOBean(TableNumRepositoryJPA tableNumRepositoryJPA) {
        this.tableNumRepositoryJPA = tableNumRepositoryJPA;
    }

    public void exec(UUID boothId) {
        tableNumRepositoryJPA.deleteAllByBoothId(boothId);
    }

}