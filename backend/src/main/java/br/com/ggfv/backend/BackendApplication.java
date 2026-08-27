package br.com.ggfv.backend;

import br.com.ggfv.backend.entity.Cliente;
import br.com.ggfv.backend.repository.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner popularBanco(ClienteRepository repository) {
		return args -> {
			if (repository.findByCnpj("00.000.000/0001-00").isEmpty()) {
				Cliente cliente = new Cliente();
				cliente.setCnpj("00.000.000/0001-00");
				cliente.setSenha("senha123");
				cliente.setNomeEmpresa("Jair Batista Construções");

				repository.save(cliente);
				System.out.println("✅ Cliente de teste inserido no banco com sucesso!");
			}
		};
	}
}