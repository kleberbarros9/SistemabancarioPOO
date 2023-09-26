package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import agencias.Agencia;
import banco.Banco;
import contas.Conta;
import contas.ContaPessoaFisica;
import contas.ContaPessoaJuridica;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastro {

	private JFrame frame;
	private JTable table;
	private JTextField textFieldNome;
	private JTextField textFieldSaldo;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastro() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		ImageIcon imageMu = new ImageIcon("src/mu_icon2.png");

		// Create an Agencia and add it to the Banco
		Agencia agencia1 = new Agencia("Agencia A", "123-3", 100000.0);
		Agencia agencia2 = new Agencia("Agencia B", "221-4", 100000.0);
		Agencia agencia3 = new Agencia("Agencia C", "357-8", 100000.0);

		ArrayList<Agencia> agenciasList = new ArrayList<>();
		agenciasList.add(agencia1);
		agenciasList.add(agencia2);
		agenciasList.add(agencia3);

		// Create a Banco with the ArrayList of Agencias
		Banco banco = new Banco(500000, agenciasList);

		//Conta conta = new Conta();
		ContaPessoaFisica contapf = new ContaPessoaFisica();
		ContaPessoaJuridica contapj = new ContaPessoaJuridica();

		// Create a String array for the JComboBox
		String[] items = new String[3];

		for (int i = 0; i < agenciasList.size(); i++)
			items[i] = banco.getAgenciaByIndex(i).getCodigo();

		// Create a label to display the selected item
		JLabel label = new JLabel(items[0]);

		frame = new JFrame();
		frame.setBounds(100, 100, 697, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		JLabel lblMuBank = new JLabel("Mu BANK");
		springLayout.putConstraint(SpringLayout.NORTH, lblMuBank, 30, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblMuBank, 278, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblMuBank, 73, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblMuBank, -206, SpringLayout.EAST, frame.getContentPane());
		lblMuBank.setFont(new Font("Dialog", Font.BOLD, 30));
		lblMuBank.setForeground(Color.MAGENTA);
		frame.getContentPane().add(lblMuBank);

		JLabel lblSubTitulo = new JLabel("# O banco com taxas imbutidas");
		springLayout.putConstraint(SpringLayout.NORTH, lblSubTitulo, 6, SpringLayout.SOUTH, lblMuBank);
		springLayout.putConstraint(SpringLayout.EAST, lblSubTitulo, -165, SpringLayout.EAST, frame.getContentPane());
		lblSubTitulo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSubTitulo.setForeground(Color.MAGENTA);
		frame.getContentPane().add(lblSubTitulo);

		JLabel lblNome = new JLabel("NOME:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNome, 130, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNome, 38, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblNome);

		JLabel lblSaldoAtual = new JLabel("SALDO ATUAL");
		springLayout.putConstraint(SpringLayout.NORTH, lblSaldoAtual, 43, SpringLayout.SOUTH, lblNome);
		springLayout.putConstraint(SpringLayout.WEST, lblSaldoAtual, 0, SpringLayout.WEST, lblNome);
		frame.getContentPane().add(lblSaldoAtual);

		JLabel lblTipoConta = new JLabel("Tipo Conta");
		springLayout.putConstraint(SpringLayout.NORTH, lblTipoConta, 0, SpringLayout.NORTH, lblSaldoAtual);
		springLayout.putConstraint(SpringLayout.WEST, lblTipoConta, 232, SpringLayout.EAST, lblSaldoAtual);
		frame.getContentPane().add(lblTipoConta);

		JRadioButton rdbtnPf = new JRadioButton("PF");
		rdbtnPf.setSelected(true);
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnPf, 0, SpringLayout.NORTH, lblSaldoAtual);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnPf, 30, SpringLayout.EAST, lblTipoConta);
		frame.getContentPane().add(rdbtnPf);

		JRadioButton rdbtnPj = new JRadioButton("PJ");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnPj, 0, SpringLayout.NORTH, lblSaldoAtual);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnPj, 65, SpringLayout.EAST, rdbtnPf);
		frame.getContentPane().add(rdbtnPj);

		// Cria grupo de botoes
		ButtonGroup bg = new ButtonGroup();

		// Adiciona botoes ao grupo
		bg.add(rdbtnPf);
		bg.add(rdbtnPj);

		// Seta botao especial como selecionado
		rdbtnPf.setSelected(true);

		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 58, SpringLayout.SOUTH, rdbtnPf);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 38, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 177, SpringLayout.SOUTH, rdbtnPf);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 658, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Ag\u00EAncia", "Conta", "Tipo Conta", "Nome", "Saldo" }));
		scrollPane.setViewportView(table);

		JButton btnCriarConta = new JButton("Criar Conta");
		btnCriarConta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = textFieldNome.getText();
				String agenciaText = label.getText().toString();

				String contaNum = geradorIdConta();

				double saldo = Float.parseFloat(textFieldSaldo.getText());

				boolean pessoaFisica = rdbtnPf.isSelected();

				int indexAgencia = 0;

				if (pessoaFisica) {

					Conta conta = (ContaPessoaFisica) contapf;
					conta.setNome(nome);
					conta.setSaldo(saldo);
					conta.setIdConta(contaNum);
					conta.setTipoConta("Pessoa Física");

					for (int i = 0; i < agenciasList.size(); i++)
						if (banco.getAgenciaByIndex(i).getCodigo().equals(agenciaText)) {
							indexAgencia = i;
							banco.getAgenciaByIndex(i).addConta(conta);
							break;
						}

				} else {
					Conta conta = (ContaPessoaJuridica) contapj;
					conta.setNome(nome);
					conta.setSaldo(saldo);
					conta.setIdConta(contaNum);
					conta.setTipoConta("Pessoa Jurídica");

					for (int i = 0; i < agenciasList.size(); i++)
						if (banco.getAgenciaByIndex(i).getCodigo().equals(agenciaText)) {
							indexAgencia = i;
							banco.getAgenciaByIndex(i).addConta(conta);
							break;
						}

				}

				// Modelagem da tabela
				DefaultTableModel tabela = (DefaultTableModel) table.getModel();
				tabela.addRow(new String[] { banco.getAgenciaByIndex(indexAgencia).getCodigo(),
						String.valueOf(
								banco.getContaByIdConta(banco.getAgenciaByIndex(indexAgencia), contaNum).getIdConta()),
						String.valueOf(banco.getContaByIdConta(banco.getAgenciaByIndex(indexAgencia), contaNum)
								.getTipoConta()),
						String.valueOf(
								banco.getContaByIdConta(banco.getAgenciaByIndex(indexAgencia), contaNum).getNome()),
						String.valueOf(
								banco.getContaByIdConta(banco.getAgenciaByIndex(indexAgencia), contaNum).getSaldo())

				});

			}
		});
		springLayout.putConstraint(SpringLayout.WEST, btnCriarConta, 51, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnCriarConta, -42, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnCriarConta);

		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() != -1) {

					String codConta = table.getValueAt(table.getSelectedRow(), 1).toString();
					String codAgencia = table.getValueAt(table.getSelectedRow(), 0).toString();

					String valorDeposito = null;

					try {
						valorDeposito = JOptionPane.showInputDialog("Digite o valor para depósito: ");
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					Agencia agencialAtual = banco.getAgenciaByCodigo(codAgencia);

					banco.getContaByIdConta(agencialAtual, codConta).depositarValor(Float.parseFloat(valorDeposito));

					double saldoAtualDouble = banco.getContaByIdConta(agencialAtual, codConta).getSaldo();

					String saldoAtual = String.valueOf((double) Math.round(saldoAtualDouble * 100) / 100);

					table.setValueAt(saldoAtual, table.getSelectedRow(), 4);

				} else {
					try {
						JOptionPane.showMessageDialog(null, "Por favor selecione uma linha da tabela.");
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}

		});
		springLayout.putConstraint(SpringLayout.NORTH, btnDepositar, 0, SpringLayout.NORTH, btnCriarConta);
		springLayout.putConstraint(SpringLayout.WEST, btnDepositar, 66, SpringLayout.EAST, btnCriarConta);
		frame.getContentPane().add(btnDepositar);

		JButton btnSacar = new JButton("Sacar");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (table.getSelectedRow() != -1) {

					String codConta = table.getValueAt(table.getSelectedRow(), 1).toString();
					String codAgencia = table.getValueAt(table.getSelectedRow(), 0).toString();

					String valorSacado = null;

					try {
						valorSacado = JOptionPane.showInputDialog("Digite o valor para saque: ");
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					Agencia agencialAtual = banco.getAgenciaByCodigo(codAgencia);

					banco.getContaByIdConta(agencialAtual, codConta).sacarValor(Float.parseFloat(valorSacado));

					double saldoAtualDouble = banco.getContaByIdConta(agencialAtual, codConta).getSaldo();

					String saldoAtual = String.valueOf((double) Math.round(saldoAtualDouble * 100) / 100);

					table.setValueAt(saldoAtual, table.getSelectedRow(), 4);

				} else {
					try {
						JOptionPane.showMessageDialog(null, "Por favor selecione uma linha da tabela.");
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, btnSacar, 0, SpringLayout.SOUTH, btnCriarConta);
		springLayout.putConstraint(SpringLayout.EAST, btnSacar, 0, SpringLayout.EAST, lblMuBank);
		frame.getContentPane().add(btnSacar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tabela = (DefaultTableModel) table.getModel();
				deleteSelectedRow(tabela, table);

			}
		});
		springLayout.putConstraint(SpringLayout.NORTH, btnExcluir, 0, SpringLayout.NORTH, btnCriarConta);
		springLayout.putConstraint(SpringLayout.WEST, btnExcluir, 0, SpringLayout.WEST, rdbtnPj);
		frame.getContentPane().add(btnExcluir);

		textFieldNome = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textFieldNome, 27, SpringLayout.SOUTH, lblSubTitulo);
		springLayout.putConstraint(SpringLayout.WEST, textFieldNome, 6, SpringLayout.EAST, lblNome);
		springLayout.putConstraint(SpringLayout.EAST, textFieldNome, 0, SpringLayout.EAST, scrollPane);
		frame.getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldSaldo = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textFieldSaldo, 24, SpringLayout.EAST, lblSaldoAtual);
		springLayout.putConstraint(SpringLayout.SOUTH, textFieldSaldo, 0, SpringLayout.SOUTH, lblSaldoAtual);
		frame.getContentPane().add(textFieldSaldo);
		textFieldSaldo.setColumns(10);

		JLabel lblDate = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblDate, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblDate, -26, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(lblDate);

		JLabel lblAgencia = new JLabel("Agencia");
		springLayout.putConstraint(SpringLayout.NORTH, lblAgencia, 24, SpringLayout.SOUTH, lblSaldoAtual);
		springLayout.putConstraint(SpringLayout.EAST, lblAgencia, 0, SpringLayout.EAST, lblSaldoAtual);
		frame.getContentPane().add(lblAgencia);

		// Create a JComboBox and set the first item as selected
		JComboBox<String> comboBox = new JComboBox<>(items);
		comboBox.setSelectedIndex(0); // Set the first item as selected

		// Add an ActionListener to the JComboBox to update the label
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) comboBox.getSelectedItem();
				label.setText(selectedItem);
			}
		});

		comboBox.setForeground(new Color(200, 200, 200));
		springLayout.putConstraint(SpringLayout.NORTH, comboBox, 15, SpringLayout.SOUTH, textFieldSaldo);
		springLayout.putConstraint(SpringLayout.WEST, comboBox, 0, SpringLayout.WEST, textFieldSaldo);
		springLayout.putConstraint(SpringLayout.EAST, comboBox, 0, SpringLayout.EAST, textFieldSaldo);
		frame.getContentPane().add(comboBox);

		JLabel lblIcon = new JLabel("");
		springLayout.putConstraint(SpringLayout.NORTH, lblIcon, 27, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblIcon, 88, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblIcon, 87, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblIcon, -18, SpringLayout.WEST, lblSubTitulo);

		lblIcon.setIcon(imageMu);
		frame.getContentPane().add(lblIcon);

		// comboBox.setSelectedIndex(0); // Set the first item as selected

	}

	// Deleta uma linhas da tabela
	public static void deleteSelectedRow(DefaultTableModel model, JTable table) {
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) { // Ensure a row is selected.
			model.removeRow(selectedRow);
		} else {
			try {
				JOptionPane.showMessageDialog(null, "Por favor selecione uma linha da tabela.");
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static String geradorIdConta() {
		Random num = new Random();
		Random numf = new Random();
		int randomNumber = num.nextInt(99999) + 1;
		Integer verifier = numf.nextInt(10);

		// Format the number to always have 5 digits with leading zeros
		String formattedNumber = String.format("%05d", randomNumber);
		String completedNumber = formattedNumber.toString() + "-" + verifier.toString();

		return completedNumber;
	}
}