package contas;

public class ContaPessoaFisica extends Conta{
	
	public ContaPessoaFisica() {
		// TODO Auto-generated constructor stub
	}

	public ContaPessoaFisica(String nome, String tipoConta, String idConta, double saldo) {
		super(nome, tipoConta, idConta, saldo);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void sacarValor(double valor) {
		// TODO Auto-generated method stub
		double valorAtual = super.getSaldo();
		super.setSaldo((valorAtual - valor) * 0.9875f);
	}

	@Override
	public void depositarValor(double valor) {
		// TODO Auto-generated method stub
		double valorAtual = super.getSaldo();
		super.setSaldo(valorAtual + valor);
	}
	

}