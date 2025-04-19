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
        JButton depositPoupancaButton = new JButton("Depositar na Poupança");
        JButton withdrawButton = new JButton("Sacar");
        JButton withdrawPoupancaButton = new JButton("Sacar da Conta Poupança");
        JButton rendimentoButton = new JButton("Calcular Rendimento");
        JButton TransferirCorrentePoupancaButton = new JButton("Transferência Corrente -> Poupança");
        JButton TransferirPoupancaCorrenteButton = new JButton("Transferência Poupança -> Corrente");

        //JTextField amountField = new JTextField(10);
        JTextField amountCorrenteField = new JTextField(10);
        JTextField amountPoupancaField = new JTextField(20);

        JLabel balanceLabelCorrente = new JLabel("Saldo Conta Corrente: " + contaCorrente.getSALDO() + "\n");
        JLabel balanceLabelPoupanca = new JLabel("Saldo Conta Poupança: " + contaPoupanca.getSALDO() + "\n");

        // Ação para depósito na conta corrente
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                double amount = Double.parseDouble(amountCorrenteField.getText());

                //double amount = Double.parseDouble(amountCorrenteField.getText());
                contaCorrente.DEPOSITAR(amount);
                balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSALDO());
            }
        });

        // Ação para saque na conta corrente
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    double amount = Double.parseDouble(amountCorrenteField.getText());
                    contaCorrente.SACAR(amount);
                    balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSALDO());

                  //  double amount = Double.parseDouble(amountCorrenteField.getText());
                  //  contaCorrente.SACAR(amount);
                  //  balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSALDO());
                } catch (SaldoInsuficienteException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                }
            }
        });

        // Ação para depósito na conta poupanca
        depositPoupancaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountPoupancaField.getText());
                contaPoupanca.DEPOSITAR(amount);
                balanceLabelPoupanca.setText("Saldo Conta Poupança: " + contaPoupanca.getSALDO());
            }
        });

        // Ação para saque na conta poupanca
        withdrawPoupancaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountPoupancaField.getText());
                    contaPoupanca.SACAR(amount);
                    balanceLabelPoupanca.setText("Saldo Conta Poupança: " + contaPoupanca.getSALDO());
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
                    contaPoupanca.TRANSFERIR(contaCorrente, amount);
                    balanceLabelPoupanca.setText("Saldo Conta Poupança: " + contaPoupanca.getSALDO());
                    balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSALDO());
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
                    contaCorrente.TRANSFERIR(contaPoupanca, amount);
                    balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSALDO());
                    balanceLabelPoupanca.setText("Saldo Conta Poupança: " + contaPoupanca.getSALDO());
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
        frame.add(new JLabel("Valor Conta Corrente:"));
        frame.add(amountCorrenteField);
        frame.add(depositButton);
        frame.add(withdrawButton);
        frame.add(TransferirCorrentePoupancaButton);
        frame.add(balanceLabelCorrente);

        frame.add(new JLabel("Valor Conta Poupança: "));
        frame.add(amountPoupancaField);
        frame.add(depositPoupancaButton);
        frame.add(withdrawPoupancaButton);
        frame.add(TransferirPoupancaCorrenteButton);
        frame.add(rendimentoButton);
        frame.add(balanceLabelPoupanca);

        frame.setVisible(true);
    }
}
