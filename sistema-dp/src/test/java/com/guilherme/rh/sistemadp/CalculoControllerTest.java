package com.guilherme.rh.sistemadp;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CalculoControllerTest {

    private final CalculoController controller = new CalculoController();

    @Test
    void calculaRescisaoComAvisoIndenizadoEMultaQuandoDemissaoSemJustaCausa() {
        CalculoController.DadosFuncionario dados = dados(2400.0, 6, "Sem Justa Causa", "Indenizado");

        Map<String, Object> resultado = controller.calcularRescisao(dados);

        assertEquals(1200.0, resultado.get("decimoTerceiro"));
        assertEquals(1200.0, resultado.get("ferias"));
        assertEquals(400.0, resultado.get("tercoFerias"));
        assertEquals(2400.0, resultado.get("avisoPrevio"));
        assertEquals(1152.0, resultado.get("saldoFgts"));
        assertEquals(460.8, resultado.get("multaFgts"));
        assertEquals(108.0, resultado.get("descontoInss"));
        assertEquals(5092.0, resultado.get("totalRescisao"));
    }

    @Test
    void naoConcedeAvisoNemMultaQuandoDemissaoPorJustaCausa() {
        CalculoController.DadosFuncionario dados = dados(1800.0, 3, "Justa Causa", "Indenizado");

        Map<String, Object> resultado = controller.calcularRescisao(dados);

        assertEquals(450.0, resultado.get("decimoTerceiro"));
        assertEquals(450.0, resultado.get("ferias"));
        assertEquals(150.0, resultado.get("tercoFerias"));
        assertEquals(0.0, resultado.get("avisoPrevio"));
        assertEquals(432.0, resultado.get("saldoFgts"));
        assertEquals(0.0, resultado.get("multaFgts"));
        assertEquals(40.5, resultado.get("descontoInss"));
        assertEquals(1009.5, resultado.get("totalRescisao"));
    }

    @Test
    void naoConcedeAvisoQuandoAvisoNaoEIndenizado() {
        CalculoController.DadosFuncionario dados = dados(3000.0, 12, "Sem Justa Causa", "Trabalhado");

        Map<String, Object> resultado = controller.calcularRescisao(dados);

        assertEquals(3000.0, resultado.get("decimoTerceiro"));
        assertEquals(3000.0, resultado.get("ferias"));
        assertEquals(1000.0, resultado.get("tercoFerias"));
        assertEquals(0.0, resultado.get("avisoPrevio"));
        assertEquals(2880.0, resultado.get("saldoFgts"));
        assertEquals(1152.0, resultado.get("multaFgts"));
        assertEquals(270.0, resultado.get("descontoInss"));
        assertEquals(6730.0, resultado.get("totalRescisao"));
    }

    private CalculoController.DadosFuncionario dados(
            double salarioBase, int mesesTrabalhados, String tipoDemissao, String avisoPrevio) {
        CalculoController.DadosFuncionario dados = new CalculoController.DadosFuncionario();
        dados.salarioBase = salarioBase;
        dados.mesesTrabalhados = mesesTrabalhados;
        dados.tipoDemissao = tipoDemissao;
        dados.avisoPrevio = avisoPrevio;
        return dados;
    }
}