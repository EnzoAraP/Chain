package org.example.chainofresponsability;

public class Fazendeiro extends Funcionario {
    public Fazendeiro(Funcionario superior) {
        listaDocumentos.add(TipoDocumentoVendaGado.getTipoDocumentoVendaGado());
        setFuncionarioSuperior(superior);
    }

    @Override
    public String getDescricaoCargo() {
        return "Fazendeiro";
    }
}
