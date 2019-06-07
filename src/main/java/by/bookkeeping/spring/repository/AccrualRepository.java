package by.bookkeeping.spring.repository;

import by.bookkeeping.spring.model.Accrual;
import by.bookkeeping.spring.model.Family;
import by.bookkeeping.spring.model.SumAccrual;

import java.util.Date;
import java.util.List;

public interface AccrualRepository {

    List<Accrual> findAll();

    List<Family> findAllFamily();

    List<SumAccrual> findExpensis();

    List<SumAccrual> findIncome();

    List<SumAccrual> findIncomeAndExpByPerson(int id);

    List<SumAccrual> findIncomeOrExpByPerson(int id, int person);

    void add(String fio, String family_member, int age);

    void delete(int id);

}
