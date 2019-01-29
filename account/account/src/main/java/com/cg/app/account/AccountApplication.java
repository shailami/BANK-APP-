package com.cg.app.account;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.cg.app.account.pojo.CurrentAccount;
import com.cg.app.account.pojo.SavingsAccount;
import com.cg.app.account.service.AccountService;

@SpringBootApplication
@EnableEurekaClient
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadInitialData(AccountService service) {
		return (args)->{
		service.addNew(new SavingsAccount(111,"shailaja",100000.0,true));
		service.addNew(new SavingsAccount(112,"deepika",100000.0,true));
		service.addNew(new SavingsAccount(113,"ankita",100000.0,true));
		service.addNew(new CurrentAccount(114, "tushar", 100000.0, 1000.0));
		service.addNew(new CurrentAccount(115, "UNNATI",100000.0, 500.0));
	};
	}

}

