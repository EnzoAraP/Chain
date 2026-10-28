package org.example.chainofresponsability;

import java.util.ArrayList;
import java.util.List;

public abstract class Funcionario {
    protected final List<TipoDocumento> listaDocumentos = new ArrayList<>();
    private Funcionario funcionarioSuperior;

    public Funcionario getFuncionarioSuperior() {
        return funcionarioSuperior;
    }

    public void setFuncionarioSuperior(Funcionario funcionarioSuperior) {
        this.funcionarioSuperior = funcionarioSuperior;
    }

    public abstract String getDescricaoCargo();

    public String assinarDocumento(Documento documento) {
        if (listaDocumentos.contains(documento.getTipoDocumento())) {
            return getDescricaoCargo();
        }
        if (funcionarioSuperior != null) {
            return funcionarioSuperior.assinarDocumento(documento);
        }
        return "Sem assinatura";
    }
}
