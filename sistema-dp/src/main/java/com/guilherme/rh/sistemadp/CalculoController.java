package com.guilherme.rh.sistemadp;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dp")
@CrossOrigin(origins = "*")
public class CalculoController {

    public static class DadosFuncionario {
        public double salarioBase;
        public int mesesTrabalhados;
        public String tipoDemissao;
        public String avisoPrevio;
    }

    @PostMapping("/calcular")
    public Map<String, Object> calcularRescisao(@RequestBody DadosFuncionario dados) {

        // 1. CÁLCULO BASE DE PROVENTOS
        double decimoTerceiro = (dados.salarioBase / 12) * dados.mesesTrabalhados;
        double feriasProporcionais = (dados.salarioBase / 12) * dados.mesesTrabalhados;
        double tercoFerias = feriasProporcionais / 3.0;

        // 2. REGRAS DE AVISO PRÉVIO
        double valorAvisoPrevio = 0.0;
        // Se a empresa demitiu e mandou indenizar, ela paga +1 salário base
        if ("Sem Justa Causa".equals(dados.tipoDemissao) && "Indenizado".equals(dados.avisoPrevio)) {
            valorAvisoPrevio = dados.salarioBase;
        }

        // 3. REGRAS DE FGTS E MULTA
        double saldoFgts = (dados.salarioBase * 0.08) * dados.mesesTrabalhados;
        double multaFgts = 0.0;
        // Só tem multa de 40% se a empresa demitiu sem justa causa
        if ("Sem Justa Causa".equals(dados.tipoDemissao)) {
            multaFgts = saldoFgts * 0.40;
        }

        // 4. DESCONTOS (Simulação de INSS sobre 13º e Aviso)
        double descontoInss = (decimoTerceiro) * 0.09;

        // 5. FECHAMENTO DO TOTAL LÍQUIDO A RECEBER (Não inclui FGTS, pois o saque é na Caixa)
        double proventos = decimoTerceiro + feriasProporcionais + tercoFerias + valorAvisoPrevio;
        double totalLiquido = proventos - descontoInss;

        Map<String, Object> resultado = new HashMap<>();
        resultado.put("decimoTerceiro", decimoTerceiro);
        resultado.put("ferias", feriasProporcionais);
        resultado.put("tercoFerias", tercoFerias);
        resultado.put("avisoPrevio", valorAvisoPrevio);
        resultado.put("saldoFgts", saldoFgts);
        resultado.put("multaFgts", multaFgts);
        resultado.put("descontoInss", descontoInss);
        resultado.put("totalRescisao", totalLiquido);

        return resultado;
    }
}