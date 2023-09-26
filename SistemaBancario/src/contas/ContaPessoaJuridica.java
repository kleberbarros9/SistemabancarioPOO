package contas;

public class ContaPessoaJuridica extends Conta{
	
	public ContaPessoaJuridica() {
		// TODO Auto-generated constructor stub
	}

	public ContaPessoaJuridica(String nome, String tipoConta, String idConta, double saldo) {
		super(nome, tipoConta, idConta, saldo);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void sacarValor(double valor) {
		// TODO Auto-generated method stub
		double valorAtual = super.getSaldo();
		super.setSaldo(valorAtual - valor);
	}

	@Override
	public void depositarValor(double valor) {
		// TODO Auto-generated method stub
		double valorAtual = super.getSaldo();
		super.setSaldo((valorAtual + valor) * 1.015f);
	}

}
