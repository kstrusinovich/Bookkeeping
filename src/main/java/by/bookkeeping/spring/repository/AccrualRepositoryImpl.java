package by.bookkeeping.spring.repository;

import by.bookkeeping.spring.model.Accrual;
import by.bookkeeping.spring.model.Family;
import by.bookkeeping.spring.model.SumAccrual;
import by.bookkeeping.spring.repository.mapping.AccMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

public class AccrualRepositoryImpl implements AccrualRepository{

    private final JdbcTemplate jdbcTemplate;

    public AccrualRepositoryImpl(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public List<Accrual> findAll() {
        return jdbcTemplate.query("select * from accrual", new BeanPropertyRowMapper<>(Accrual.class));
    }

    @Override
    public List<Family> findAllFamily() {
        return jdbcTemplate.query("select * from family", new BeanPropertyRowMapper<>(Family.class));
    }

    @Override
    public List<SumAccrual> findExpensis() {
        return jdbcTemplate.query("select fam.fio, sum(acc.summ) as summ\n" +
                "\tfrom accrual acc\n" +
                "    left join family fam on fam.id = id_family\n" +
                "    where acc.id_accr_clause = 2\n" +
                "    group by fam.fio", new AccMapper());
    }

    @Override
    public List<SumAccrual> findIncome() {
        return jdbcTemplate.query("select fam.fio, sum(acc.summ) as summ\n" +
                "\tfrom accrual acc\n" +
                "    left join family fam on fam.id = id_family\n" +
                "    where acc.id_accr_clause = 1\n" +
                "    group by fam.fio", new AccMapper());
    }

    @Override
    public List<SumAccrual> findIncomeAndExpByPerson(int id) {
        return jdbcTemplate.query("select fam.fio, acc.summ\n" +
                "\tfrom accrual acc\n" +
                "    left join family fam on fam.id = id_family\n" +
                "    where fam.id = ?", new Object[]{id}, new AccMapper());
    }

    @Override
    public List<SumAccrual> findIncomeOrExpByPerson(int id, int person) {
        return jdbcTemplate.query("select fam.fio, sum(acc.summ) as summ\n" +
                "\tfrom accrual acc\n" +
                "    left join family fam on fam.id = id_family\n" +
                "    where fam.id = ? \n" +
                "    and acc.id_accr_clause = ?", new Object[]{id,person}, new AccMapper());
    }

    @Override
    public void add(String fio, String family_member, int age) {
        jdbcTemplate.update("insert into family (fio, family_member, age)" +
                "values (?,?,?)", fio, family_member, age);
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("delete from family where id = ?", id);
    }


}
