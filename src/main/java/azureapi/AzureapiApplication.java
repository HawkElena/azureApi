package azureapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) // para que se incluya la seguridad.

public class AzureapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureapiApplication.class, args);
		System.out.println("algo debe de mostrar");
	}

}
