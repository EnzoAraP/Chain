package org.example.chainofresponsability;

public class Veterinario extends Funcionario {
    public Veterinario(Funcionario superior) {
        listaDocumentos.add(TipoDocumentoVacinacao.getTipoDocumentoVacinacao());
        setFuncionarioSuperior(superior);
    }

    @Override
    public String getDescricaoCargo() {
        return "Veterinario";
    }
}
