package com.lucasl.challenge.withdraw.config;

import com.lucasl.challenge.withdraw.service.OperationService;
import com.lucasl.challenge.withdraw.operations.CashWithDrawalOperation;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.lucasl.challenge.withdraw")
public class AppConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public OperationService operationService(){
        return new OperationService();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public CashWithDrawalOperation cashWithdrawalOperation(double value, int [] listNotes){
        return new CashWithDrawalOperation(value, listNotes);
    }
}
