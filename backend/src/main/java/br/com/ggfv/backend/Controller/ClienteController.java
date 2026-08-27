package br.com.ggfv.backend.controller;

import br.com.ggfv.backend.entity.Cliente;
import br.com.ggfv.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {


        Optional<Cliente> clienteOpt = clienteRepository.findByCnpj(request.cnpj());

        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();

            if (cliente.getSenha().equals(request.senha())) {
                return ResponseEntity.ok("Acesso liberado! Bem-vindo, " + cliente.getNomeEmpresa());
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("CNPJ ou senha inválidos.");
    }

    public record LoginRequest(String cnpj, String senha) {}
}