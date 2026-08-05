package com.guilherme.rh.sistemadp;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dp")
@CrossOrigin(origins = "*")
public class CalculoController {

    @GetMapping("/status")
    public String statusServidor() {
        return "{\"mensagem\": \"Servidor Java rodando e pronto para receber cálculos!\"}";
    }

    public static class DadosFuncionario {
        public double salarioBase;
        public int mesesTrabalhados;
    }

    @PostMapping("/calcular")
    public Map<String, Object> calcularRescisao(@RequestBody DadosFuncionario dados) {

        double decimoTerceiro = (dados.salarioBase / 12) * dados.mesesTrabalhados;
        double feriasProporcionais = (dados.salarioBase / 12) * dados.mesesTrabalhados;
        double tercoFerias = feriasProporcionais / 3.0;

        double total = decimoTerceiro + feriasProporcionais + tercoFerias;

        // O Map do Java é convertido automaticamente para JSON pelo Spring Boot
        Map<String, Object> resultado = new HashMap<>();
        resultado.put("decimoTerceiro", decimoTerceiro);
        resultado.put("ferias", feriasProporcionais);
        resultado.put("tercoFerias", tercoFerias);
        resultado.put("totalRescisao", total);

        System.out.println("Cálculo realizado com sucesso para o salário de R$ " + dados.salarioBase);

        return resultado;
    }
}