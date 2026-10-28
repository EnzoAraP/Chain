package org.example.chainofresponsability;

public class TipoDocumentoBoleto implements TipoDocumento {
    private static final TipoDocumentoBoleto instancia = new TipoDocumentoBoleto();

    private TipoDocumentoBoleto() {
    }

    public static TipoDocumentoBoleto getTipoDocumentoBoleto() {
        return instancia;
    }
}
