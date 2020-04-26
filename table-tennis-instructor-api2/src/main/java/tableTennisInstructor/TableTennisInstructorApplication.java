package tableTennisInstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class TableTennisInstructorApplication {

	private static Logger log = LoggerFactory.getLogger(TableTennisInstructorApplication.class);

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TableTennisInstructorApplication.class, args);

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);

		StringBuilder sb = new StringBuilder("Application beans:\n");
		for (String beanName : beanNames) {
			sb.append(beanName + "\n");
		}
		log.info(sb.toString());
	}

}
