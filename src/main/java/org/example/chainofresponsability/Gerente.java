package org.example.chainofresponsability;

public class Gerente extends Funcionario {
    public Gerente(Funcionario superior) {
        listaDocumentos.add(TipoDocumentoCompraRacao.getTipoDocumentoCompraRacao());
        setFuncionarioSuperior(superior);
    }

    @Override
    public String getDescricaoCargo() {
        return "Gerente";
    }
}
