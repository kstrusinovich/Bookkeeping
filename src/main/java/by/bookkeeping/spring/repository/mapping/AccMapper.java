package by.bookkeeping.spring.repository.mapping;

import by.bookkeeping.spring.model.SumAccrual;
import org.springframework.jdbc.core.RowMapper;


import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccMapper implements RowMapper<SumAccrual> {

    public SumAccrual mapRow(ResultSet resultSet, int i) throws SQLException {

        SumAccrual person = new SumAccrual();
        //person.setId(resultSet.getLong("id"));
        person.setFio(resultSet.getString("fio"));
        person.setSumm(resultSet.getDouble("summ"));
        return person;
    }

}
