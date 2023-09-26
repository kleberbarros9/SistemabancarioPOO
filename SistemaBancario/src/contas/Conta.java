package contas;

import java.util.ArrayList;

public class Conta {
    private String nome;
    private String tipoConta;
    private String idConta;
    private double saldo;
    
    public Conta() {
        this.nome = null;
        this.tipoConta = null;
        this.idConta = "abc";
        this.saldo = 0.0;
    }

    public Conta(String nome, String tipoConta, String idConta, double saldo) {
        this.nome = nome;
        this.tipoConta = tipoConta;
        this.idConta = idConta;
        this.saldo = saldo;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getIdConta() {
		return idConta;
	}

	public void setIdConta(String idConta) {
		this.idConta = idConta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public void sacarValor(double valor) {
		// TODO Auto-generated method stub

	}


	public void depositarValor(double valor) {
		// TODO Auto-generated method stub

	}
    
}