package kr.ac.kopo.ctc.spring.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
public class SpringBoard1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoard1Application.class, args);
	}

}
