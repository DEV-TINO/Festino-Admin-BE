package com.DevTino.festino_admin.order.bean.small;

import com.DevTino.festino_admin.order.domain.TableNumDAO;
import com.DevTino.festino_admin.order.repository.jpa.TableNumRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaveTableNumDAOBean {

    TableNumRepositoryJPA tableNumRepositoryJPA;

    @Autowired
    public SaveTableNumDAOBean(TableNumRepositoryJPA tableNumRepositoryJPA) {
        this.tableNumRepositoryJPA = tableNumRepositoryJPA;
    }

    public TableNumDAO exec(TableNumDAO tableNumDAO) {
        return tableNumRepositoryJPA.save(tableNumDAO);
    }

    public void exec(List<TableNumDAO> tableNumDAOList) {
        tableNumRepositoryJPA.saveAll(tableNumDAOList);
    }
}
