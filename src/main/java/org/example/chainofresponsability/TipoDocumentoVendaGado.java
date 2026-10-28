package org.example.chainofresponsability;

public class TipoDocumentoVendaGado implements TipoDocumento {
    private static final TipoDocumentoVendaGado instancia = new TipoDocumentoVendaGado();

    private TipoDocumentoVendaGado() {
    }

    public static TipoDocumentoVendaGado getTipoDocumentoVendaGado() {
        return instancia;
    }
}
