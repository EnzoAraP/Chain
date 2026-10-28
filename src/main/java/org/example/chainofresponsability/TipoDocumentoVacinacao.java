package org.example.chainofresponsability;

public class TipoDocumentoVacinacao implements TipoDocumento {
    private static final TipoDocumentoVacinacao instancia = new TipoDocumentoVacinacao();

    private TipoDocumentoVacinacao() {
    }

    public static TipoDocumentoVacinacao getTipoDocumentoVacinacao() {
        return instancia;
    }
}
