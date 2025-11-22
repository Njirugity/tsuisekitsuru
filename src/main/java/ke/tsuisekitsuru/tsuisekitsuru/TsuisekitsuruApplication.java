package ke.tsuisekitsuru.tsuisekitsuru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TsuisekitsuruApplication {

	public static void main(String[] args) {
		SpringApplication.run(TsuisekitsuruApplication.class, args);
	}

}
