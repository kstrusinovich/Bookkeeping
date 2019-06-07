package by.bookkeeping.spring;

import by.bookkeeping.spring.model.Accrual;
import by.bookkeeping.spring.repository.AccrualRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BookkeepingConfig.class);
        AccrualRepository service = ctx.getBean(AccrualRepository.class);

        List<Accrual> all = service.findAll();
        for (Accrual accrual : all){
            System.out.println(accrual);
        }
    }

}
