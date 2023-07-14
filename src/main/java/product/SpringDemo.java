package product;

import product.exсeption.PingwitNotFoundExсeption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(PingwitNotFoundExсeption.class);
    public static void main(String[] args) {
        LOGGER.info("Start the application");
        SpringApplication.run(SpringDemo.class, args);
        LOGGER.trace("loading....");
        LOGGER.info("Application run");
    }
}
