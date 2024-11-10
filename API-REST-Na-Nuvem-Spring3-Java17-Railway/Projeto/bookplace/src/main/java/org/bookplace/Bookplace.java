package org.bookplace;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class Bookplace implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Bookplace.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
        // Carrega o arquivo .env
        Dotenv dotenv = Dotenv.load();

        // Aqui você pode acessar as variáveis de ambiente
        String dbUrl = dotenv.get("PGHOST");
        String dbPassword = dotenv.get("PGPASSWORD");

        System.out.println("\n\n\nDB URL: " + dbUrl);
        System.out.println("\n\n\nDB Username: " + dbPassword);
        // A senha geralmente não se imprime por segurança
    }

}