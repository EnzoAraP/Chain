package org.example.chainofresponsability;

public class TipoDocumentoCompraRacao implements TipoDocumento {
    private static final TipoDocumentoCompraRacao instancia = new TipoDocumentoCompraRacao();

    private TipoDocumentoCompraRacao() {
    }

    public static TipoDocumentoCompraRacao getTipoDocumentoCompraRacao() {
        return instancia;
    }
}
