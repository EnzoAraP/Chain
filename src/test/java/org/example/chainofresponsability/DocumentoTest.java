package org.example.chainofresponsability;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DocumentoTest {
    private Fazendeiro fazendeiro;
    private Gerente gerente;
    private Veterinario veterinario;
    private Tratador tratador;

    @BeforeEach
    void setUp() {
        fazendeiro = new Fazendeiro(null);
        gerente = new Gerente(fazendeiro);
        veterinario = new Veterinario(gerente);
        tratador = new Tratador(veterinario);
    }

    @Test
    void deveRetornarTratadorParaAssinaturaOrdenha() {
        Documento documento = new Documento(TipoDocumentoOrdenha.getTipoDocumentoOrdenha());

        assertEquals("Tratador", tratador.assinarDocumento(documento));
    }

    @Test
    void deveRetornarVeterinarioParaAssinaturaVacinacao() {
        Documento documento = new Documento(TipoDocumentoVacinacao.getTipoDocumentoVacinacao());

        assertEquals("Veterinario", tratador.assinarDocumento(documento));
    }

    @Test
    void deveRetornarGerenteParaAssinaturaCompraRacao() {
        Documento documento = new Documento(TipoDocumentoCompraRacao.getTipoDocumentoCompraRacao());

        assertEquals("Gerente", tratador.assinarDocumento(documento));
    }

    @Test
    void deveRetornarFazendeiroParaAssinaturaVendaGado() {
        Documento documento = new Documento(TipoDocumentoVendaGado.getTipoDocumentoVendaGado());

        assertEquals("Fazendeiro", tratador.assinarDocumento(documento));
    }

    @Test
    void deveRetornarSemAssinaturaParaBoleto() {
        Documento documento = new Documento(TipoDocumentoBoleto.getTipoDocumentoBoleto());

        assertEquals("Sem assinatura", tratador.assinarDocumento(documento));
    }

    @Test
    void deveRetornarSemAssinaturaQuandoCadeiaNaoAlcancaResponsavel() {
        Documento documento = new Documento(TipoDocumentoVendaGado.getTipoDocumentoVendaGado());
        gerente.setFuncionarioSuperior(null);

        assertEquals("Sem assinatura", tratador.assinarDocumento(documento));
    }

    @Test
    void deveEncaminharDocumentoDepoisDeConectarSuperior() {
        Documento documento = new Documento(TipoDocumentoVendaGado.getTipoDocumentoVendaGado());
        Tratador tratadorSemSuperior = new Tratador(null);

        assertEquals("Sem assinatura", tratadorSemSuperior.assinarDocumento(documento));

        tratadorSemSuperior.setFuncionarioSuperior(fazendeiro);

        assertEquals("Fazendeiro", tratadorSemSuperior.assinarDocumento(documento));
    }

    @Test
    void deveAssinarDocumentoPermitidoMesmoSemSuperior() {
        Tratador tratadorSemSuperior = new Tratador(null);
        Documento documento = new Documento(TipoDocumentoOrdenha.getTipoDocumentoOrdenha());

        assertEquals("Tratador", tratadorSemSuperior.assinarDocumento(documento));
    }

    @Test
    void deveEncerrarNoPrimeiroFuncionarioQuePodeAssinar() {
        Tratador outroTratador = new Tratador(null) {
            @Override
            public String getDescricaoCargo() {
                return "Tratador superior";
            }
        };
        tratador.setFuncionarioSuperior(outroTratador);
        Documento documento = new Documento(TipoDocumentoOrdenha.getTipoDocumentoOrdenha());

        assertEquals("Tratador", tratador.assinarDocumento(documento));
    }
}
