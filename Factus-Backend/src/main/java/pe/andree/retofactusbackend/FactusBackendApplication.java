package pe.andree.retofactusbackend;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FactusBackendApplication {

    public static void main(String[] args) {

        SpringApplication.run(FactusBackendApplication.class, args);
    }

}
