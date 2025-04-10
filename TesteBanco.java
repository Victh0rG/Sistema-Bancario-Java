import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TesteBanco {
    public static void main(String[] args) throws SaldoInsuficienteException {
        // Criação de uma conta corrente e uma conta poupança
        ImageIcon logo = new ImageIcon(".//res//salary.png");
        ContaCorrente contaCorrente = new ContaCorrente("12345", 1000, 500);
        ContaPoupanca contaPoupanca = new ContaPoupanca("54321", 2000, 0.05);

        // Configuração da janela principal
        JFrame frame = new JFrame("Sistema Bancário");
        frame.setIconImage(logo.getImage());
        frame.setTitle("Sistema Bancário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(710, 300);
        frame.setLayout(new FlowLayout());

        // Componentes da interface gráfica

        // Componentes Corrente
        JButton TransferirPoupancaCorrenteButton = new JButton("Transferir");
        JButton depositCorrenteButton = new JButton("Depositar");
        JButton withdrawCorrenteButton = new JButton("Sacar");

        //Componentes Poupanca
        JButton TransferirCorrentePoupancaButton = new JButton("Transferir");

        JButton depositPoupancaButton = new JButton("Depositar");
        JButton withdrawPoupancaButton = new JButton("Sacar");
        JButton rendimentoButton = new JButton("Calcular Rendimento");

        JTextField amountCorrenteField = new JTextField(10);
        JTextField amountPoupancaField = new JTextField(10);
        JLabel balanceLabelCorrente = new JLabel("Saldo Conta Corrente: " + contaCorrente.getSaldo());
        JLabel balanceLabelPoupanca = new JLabel("Saldo Conta Poupança: " + contaPoupanca.getSaldo());

        // Ação para depósito na conta corrente
        depositCorrenteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountCorrenteField.getText());
                contaCorrente.depositar(amount);
                balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSaldo());
            }
        });

        // Ação para saque na conta corrente
        withdrawCorrenteButton.addActionListener(new ActionListener() {
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

        // Ação para transferir Corrente para Conta (pendente)
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

        // Adiciona componentes ao frame
        frame.add(new JLabel("Valor Corrente:"));
        frame.add(amountCorrenteField);
        frame.add(depositCorrenteButton);
        frame.add(withdrawCorrenteButton);
        frame.add(TransferirCorrentePoupancaButton);
        frame.add(balanceLabelCorrente);

        frame.add(new JLabel("Valor Poupança:"));
        frame.add(amountPoupancaField);
        frame.add(depositPoupancaButton);
        frame.add(withdrawPoupancaButton);
        frame.add(TransferirPoupancaCorrenteButton);
        frame.add(balanceLabelPoupanca);

        frame.add(rendimentoButton);

        frame.setVisible(true);
    }
}
