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
        frame.setSize(500, 300);
        frame.setLayout(new FlowLayout());

        // Componentes da interface gráfica
        JButton depositButton = new JButton("Depositar");
        JButton withdrawButton = new JButton("Sacar");
        JButton rendimentoButton = new JButton("Calcular Rendimento");

        JTextField amountField = new JTextField(10);
        JLabel balanceLabelCorrente = new JLabel("Saldo Conta Corrente: " + contaCorrente.getSaldo());
        JLabel balanceLabelPoupanca = new JLabel("Saldo Conta Poupança: " + contaPoupanca.getSaldo());

        // Ação para depósito na conta corrente
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                contaCorrente.depositar(amount);
                balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSaldo());
            }
        });

        // Ação para saque na conta corrente
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    contaCorrente.sacar(amount);
                    balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSaldo());
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
        frame.add(new JLabel("Valor:"));
        frame.add(amountField);
        frame.add(depositButton);
        frame.add(withdrawButton);
        frame.add(rendimentoButton);
        frame.add(balanceLabelCorrente);
        frame.add(balanceLabelPoupanca);

        frame.setVisible(true);
    }
}
