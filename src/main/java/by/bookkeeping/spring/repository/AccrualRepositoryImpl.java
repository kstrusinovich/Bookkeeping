package by.bookkeeping.spring.repository;

import by.bookkeeping.spring.model.Accrual;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class AccrualRepositoryImpl implements AccrualRepository{

    private final JdbcTemplate jdbcTemplate;

    public AccrualRepositoryImpl(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public List<Accrual> findAll() {
        return null;
    }
}
