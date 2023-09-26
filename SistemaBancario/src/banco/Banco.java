package banco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import agencias.Agencia;
import contas.Conta;



public class Banco {
    private double capital;
    private List<Agencia> agencias;

    public Banco() {
        this.capital = 0.0;
        this.agencias = new ArrayList<>();
    }

    public Banco(double capital, List<Agencia> agencias) {
        this.capital = capital;
        this.agencias = agencias;
    }

    // Method to add an Agencia to the Banco
    public void addAgencia(Agencia agencia) {
        agencias.add(agencia);
    }

    // Method to remove an Agencia from the Banco by codigo
    public void removeAgencia(String codigo) {
        agencias.removeIf(agencia -> agencia.getCodigo().equals(codigo));
    }

    // Method to retrieve a specific Agencia inside the Banco by codigo
    public Agencia getAgenciaByCodigo(String codigo) {
        for (Agencia agencia : agencias) {
            if (agencia.getCodigo().equals(codigo)) {
                return agencia;
            }
        }
        return null; // Agencia not found
    }

    // Method to retrieve a particular Conta inside an Agencia by idConta
    public Conta getContaByIdConta(Agencia agencia, String idConta) {
        for (Conta conta : agencia.getContas()) {
            if (conta.getIdConta().equals(idConta)) {
                return conta;
            }
        }
        return null; // Conta not found
    }
    
    
    public String getContaByIdContaString(Agencia agencia, String idConta) {
        for (Conta conta : agencia.getContas()) {
            if (conta.getIdConta().equals(idConta)) {
                return conta.getIdConta();
            }
        }
        return null; // Conta not found
    }
    
    public Agencia getAgenciaByIndex(int index) {
        if (index >= 0 && index < agencias.size()) {
            return agencias.get(index);
        }
        return null;
    }
}
