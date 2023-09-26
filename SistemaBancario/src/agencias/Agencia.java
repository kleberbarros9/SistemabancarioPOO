package agencias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import contas.Conta;

public class Agencia {
    private String nome;
    private String codigo;
    private double capital;
    private int sizeOfAgencia;
    private List<Conta> contas;

    public Agencia(String nome, String codigo, double capital) {
        this.nome = nome;
        this.codigo = codigo;
        this.capital = capital;
        this.sizeOfAgencia = 0;
        this.contas = new ArrayList<>();
    }

    // Getters for Agencia attributes
    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getCapital() {
        return capital;
    }

    public int getSizeOfAgencia() {
        return sizeOfAgencia;
    }

    public List<Conta> getContas() {
        return contas;
    }

    // Method to add a Conta to the Agencia
    public void addConta(Conta conta) {
        contas.add(conta);
        sizeOfAgencia++;
    }

    // Method to remove a Conta from the Agencia by idConta
    public void removeConta(String idConta) {
        contas.removeIf(conta -> conta.getIdConta().equals(idConta));
        sizeOfAgencia--;
    }
}