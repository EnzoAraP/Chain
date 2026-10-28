package org.example.chainofresponsability;

public class Tratador extends Funcionario {
    public Tratador(Funcionario superior) {
        listaDocumentos.add(TipoDocumentoOrdenha.getTipoDocumentoOrdenha());
        setFuncionarioSuperior(superior);
    }

    @Override
    public String getDescricaoCargo() {
        return "Tratador";
    }
}
