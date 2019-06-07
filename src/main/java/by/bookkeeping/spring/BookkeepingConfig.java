package by.bookkeeping.spring;

import by.bookkeeping.spring.repository.AccrualRepository;
import by.bookkeeping.spring.repository.AccrualRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:SQL/database.properties")
public class BookkeepingConfig {

    @Autowired
    Environment environment;

    @Bean
    AccrualRepository accrualRepository(){
        return new AccrualRepositoryImpl(dataSource());
    }


    @Bean
    DataSource dataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName(environment.getProperty("driver"));
        source.setUrl(environment.getProperty("url"));
        source.setUsername(environment.getProperty("dbuser"));
        source.setPassword(environment.getProperty("dbpassword"));
        return source;
    }
}
