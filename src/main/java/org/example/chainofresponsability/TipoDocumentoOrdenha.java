package org.example.chainofresponsability;

public class TipoDocumentoOrdenha implements TipoDocumento {
    private static final TipoDocumentoOrdenha instancia = new TipoDocumentoOrdenha();

    private TipoDocumentoOrdenha() {
    }

    public static TipoDocumentoOrdenha getTipoDocumentoOrdenha() {
        return instancia;
    }
}
