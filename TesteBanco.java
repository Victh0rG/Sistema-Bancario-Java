import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TesteBanco {
    public static void main(String[] args) throws SaldoInsuficienteException {

        // Criação de uma conta corrente e uma conta poupança
        ContaCorrente contaCorrente = new ContaCorrente("12345", 1000, 500);
        ContaPoupanca contaPoupanca = new ContaPoupanca("54321", 2000, 0.05);

        // Configuração da janela principal
        JFrame frame = new JFrame("Sistema Bancário");
        frame.setTitle("Sistema Bancário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 400);
        frame.setLayout(new GridLayout(6, 1, 1, 1)); // 6 linhas, 1 colunas, com espaçamento minimo

        // Componentes da interface gráfica
        JButton depositButton = new JButton("Depositar");
        JButton depositPoupancaButton = new JButton("Depositar na Poupança");
        JButton withdrawButton = new JButton("Sacar");
        JButton withdrawPoupancaButton = new JButton("Sacar da Conta Poupança");
        JButton rendimentoButton = new JButton("Calcular Rendimento");
        JButton TransferirCorrentePoupancaButton = new JButton("Transferência para Poupança");
        JButton TransferirPoupancaCorrenteButton = new JButton("Transferência para Corrente");

        //JTextField amountField = new JTextField(10);
        JTextField amountCorrenteField = new JTextField(10);
        JTextField amountPoupancaField = new JTextField(10);
        JLabel balanceLabelCorrente = new JLabel("Saldo Conta Corrente: " + contaCorrente.getSaldo());
        JLabel balanceLabelPoupanca = new JLabel("Saldo Conta Poupança: " + contaPoupanca.getSaldo());

        // Ação para depósito na conta corrente
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double amount = Double.parseDouble(amountCorrenteField.getText());
                contaCorrente.depositar(amount);
                balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSaldo());
            }
        });

        // Ação para saque na conta corrente
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    double amount = Double.parseDouble(amountCorrenteField.getText());
                    contaCorrente.sacar(amount);
                    balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSaldo());
                } catch (SaldoInsuficienteException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                }
            }
        });

        // Ação para depósito na conta poupanca
        depositPoupancaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountPoupancaField.getText());
                contaPoupanca.depositar(amount);
                balanceLabelPoupanca.setText("Saldo Conta Poupança: " + contaPoupanca.getSaldo());
            }
        });

        // Ação para saque na conta poupanca
        withdrawPoupancaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountPoupancaField.getText());
                    contaPoupanca.sacar(amount);
                    balanceLabelPoupanca.setText("Saldo Conta Poupança: " + contaPoupanca.getSaldo());
                } catch (SaldoInsuficienteException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                }
            }
        });

        // Ação para transferir Poupanca Para Corrente (pendente)
        TransferirPoupancaCorrenteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountPoupancaField.getText());
                    contaPoupanca.transferir(contaCorrente, amount);
                    balanceLabelPoupanca.setText("Saldo Conta Poupança: " + contaPoupanca.getSaldo());
                    balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSaldo());
                } catch (SaldoInsuficienteException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                }
            }
        });

        // Ação para transferir Corrente para Poupança (pendente)
        TransferirCorrentePoupancaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountCorrenteField.getText());
                    contaCorrente.transferir(contaPoupanca, amount);
                    balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSaldo());
                    balanceLabelPoupanca.setText("Saldo Conta Poupança: " + contaPoupanca.getSaldo());
                } catch (SaldoInsuficienteException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                }
            }
        });

        // Ação para calcular o rendimento da conta poupança
        rendimentoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double rendimento = contaPoupanca.calcularRendimento();
                JOptionPane.showMessageDialog(frame, "Rendimento da Conta Poupança: " + rendimento);
            }
        });

        // Configurar labels e inputs
        Dimension fieldSize = new Dimension(300, 20);

        amountCorrenteField.setPreferredSize(fieldSize);
        amountPoupancaField.setPreferredSize(fieldSize);


        depositPoupancaButton.setPreferredSize(new Dimension(200, 25));
        withdrawPoupancaButton.setPreferredSize(new Dimension(200, 25));
        rendimentoButton.setPreferredSize(new Dimension(200, 25));
        TransferirCorrentePoupancaButton.setPreferredSize(new Dimension(200, 25));
        TransferirPoupancaCorrenteButton.setPreferredSize(new Dimension(200, 25));


        // Adiciona componentes ao frame
        JPanel row0 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        row1.add(new JLabel("Valor Conta Corrente:"));
        row1.add(amountCorrenteField);
        row1.add(balanceLabelCorrente);

        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        row2.add(depositButton);
        row2.add(withdrawButton);
        row2.add(TransferirCorrentePoupancaButton);

        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel row4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        row4.add(new JLabel("Valor Conta Poupança: "));
        row4.add(amountPoupancaField);
        row4.add(balanceLabelPoupanca);

        JPanel row5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        row5.add(depositPoupancaButton);
        row5.add(withdrawPoupancaButton);


        JPanel row6 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        row6.add(TransferirPoupancaCorrenteButton);
        row6.add(rendimentoButton);


        frame.add(row1);
        frame.add(row2);
        frame.add(row4);
        frame.add(row5);
        frame.add(row6);

        frame.setVisible(true);
    }
}
