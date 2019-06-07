package by.bookkeeping.spring.repository;

import by.bookkeeping.spring.model.Accrual;

import java.util.List;

public interface AccrualRepository {

    List<Accrual> findAll();

}
