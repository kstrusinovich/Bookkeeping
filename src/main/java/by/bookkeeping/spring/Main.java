package by.bookkeeping.spring;

import by.bookkeeping.spring.model.Accrual;
import by.bookkeeping.spring.model.Family;
import by.bookkeeping.spring.model.SumAccrual;
import by.bookkeeping.spring.repository.AccrualRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(BookkeepingConfig.class);
//        AccrualRepository service = ctx.getBean(AccrualRepository.class);

        ApplicationContext context = new AnnotationConfigApplicationContext(BookkeepingConfig.class);
        AccrualRepository service = context.getBean(AccrualRepository.class);

        Scanner scanner = new Scanner(System.in);

        int ch = 1;

        while(true){

            System.out.println("********************МЕНЮ*****************");
            System.out.println("1. Вывести таблицу выставлений");
            System.out.println("2. Вывести таблицу семья");
            System.out.println("3. Вывести всех членов семьи у которых есть заработок");
            System.out.println("4. Вывести всех членов семьи у которых есть затраты");
            System.out.println("5. Вывести определенного члена сеьи и все его заработки и затраты");
            System.out.println("6. Вывести определенного члена семьи и его сумму (заработоки/затраты)");
            System.out.println("7. Добавить нового члена семьи");
            System.out.println("8. Удалить члена семьи по ID");
            System.out.println("0. EXIT");
            System.out.println("В работе реализованы не все методы, для работы с данной БД.");
            System.out.println("Реализованные методы служат для проверки работоспособнасти ПО");
            System.out.println("Спасибо что выбрали нас :) Недеюсь на хорошую оцену, за старания");
            System.out.println("*****************************************");

            List<Accrual> all;
            List<SumAccrual> all1;
            List<Family> all2;
            switch (scanner.nextInt()){
                case 1:
                    all = service.findAll();
                    System.out.println("Таблица выставления!");
                    System.out.println("___________________________________________________");
                    for (Accrual accrual : all){
                        System.out.println(accrual);
                    }
                    System.out.println("___________________________________________________");
                    System.out.println("");
                    break;
                case 2:
                    all2 = service.findAllFamily();
                    System.out.println("Таблица семья!");
                    System.out.println("___________________________________________________");
                    for (Family family : all2){
                        System.out.println(family);
                    }
                    System.out.println("___________________________________________________");
                    break;
                case 3:
                    all1 = service.findIncome();
                    System.out.println("Заработок!");
                    System.out.println("___________________________________________________");
                    for (SumAccrual sumAccrual : all1){
                        System.out.println(sumAccrual);
                    }
                    System.out.println("___________________________________________________");
                    break;
                case 4:
                    all1 = service.findExpensis();
                    System.out.println("Затраты!");
                    System.out.println("___________________________________________________");
                    for (SumAccrual sumAccrual : all1){
                        System.out.println(sumAccrual);
                    }
                    System.out.println("___________________________________________________");
                    break;
                case 5:
                    int id2;
                    System.out.println("Введите ID члена семьи");
                    id2 = scanner.nextInt();
                    all1 = service.findIncomeAndExpByPerson(id2);
                    System.out.println("Заработок и затраты определенного члена семьи!");
                    System.out.println("___________________________________________________");
                    for (SumAccrual sumAccrual : all1){
                        System.out.println(sumAccrual);
                    }
                    System.out.println("___________________________________________________");
                    break;
                case 6:
                    int id, person;
                    System.out.println("Введите ID члена семьи");
                    id = scanner.nextInt();
                    System.out.println("Введите 1 или 2 (1 - заработок/2-затраты)");
                    person = scanner.nextInt();
                    System.out.println("СУММА заработок/затраты оопределенного члена семьи!");
                    System.out.println("___________________________________________________");
                    all1 = service.findIncomeOrExpByPerson(id, person);
                    for (SumAccrual sumAccrual : all1){
                        System.out.println(sumAccrual);
                    }
                    System.out.println("___________________________________________________");
                    break;
                case 7:
                    String member;
                    String name, lastName, otch, fio;
                    int age;
                    System.out.println("Введите Фамилию");
                    lastName = scanner.next();
                    System.out.println("Введите Имя");
                    name = scanner.next();
                    System.out.println("Введите Отчество");
                    otch = scanner.next();
                    fio ="" + lastName + " " + name + " " + otch;
                    System.out.println("Введите кем является новый член семьи");
                    member = scanner.next();
                    System.out.println("Введите возраст нового члена семьи");
                    age = scanner.nextInt();
                    service.add(fio, member, age);
                    System.out.println("Новый член семьи успешно добавлен.");
                    System.out.println("Для проверки выберете пункт меню 2");
                    System.out.println("___________________________________________________");
                    break;
                case 8:
                    int id1;
                    System.out.println("Введите ID члена семьи, которого хотите удалить");
                    id1 = scanner.nextInt();
                    service.delete(id1);
                    System.out.println("Выбранный вами член семьи, удален.");
                    System.out.println("Для проверки выберете пункт меню 2");
                    System.out.println("___________________________________________________");
                    break;
                case 0:
                    ch = 0;
                    break;
            }

            if(ch == 0) break;
        }
//        List<Accrual> all = service.findAll();
//        for (Accrual accrual : all){
//            System.out.println(accrual);
//        }
//        System.out.println("*******************************************");
//        List<SumAccrual> all1 = service.findExpensis();
//        for (SumAccrual sumAccrual : all1){
//            System.out.println(sumAccrual);
//        }
//        System.out.println("*******************************************");
//        List<SumAccrual> all2 = service.findIncome();
//        for (SumAccrual sumAccrual : all2){
//            System.out.println(sumAccrual);
//        }
//        System.out.println("*******************************************");
//        List<SumAccrual> all3 = service.findIncomeAndExpByPerson(1);
//        for (SumAccrual sumAccrual : all3){
//            System.out.println(sumAccrual);
//        }
//
//        System.out.println("*********************************************");
//        List<SumAccrual> all4 = service.findIncomeOrExpByPerson(1, 1);
//        for (SumAccrual sumAccrual : all4){
//            System.out.println(sumAccrual);
//        }
//
//        service.add("herabora her Invanovich", "HALOP", 12);

        //service.delete(9);
    }



}
