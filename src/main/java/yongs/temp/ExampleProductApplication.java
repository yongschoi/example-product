package yongs.temp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ExampleProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleProductApplication.class, args);
	}
	@GetMapping("/")
    public String home() throws Exception {
        return "Hello, example-product";
    }
}
