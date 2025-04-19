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
<<<<<<< HEAD

        // Componentes Corrente
        JButton TransferirPoupancaCorrenteButton = new JButton("Transferir");
        JButton depositCorrenteButton = new JButton("Depositar");
        JButton withdrawCorrenteButton = new JButton("Sacar");

        //Componentes Poupanca
        JButton TransferirCorrentePoupancaButton = new JButton("Transferir");

        JButton depositPoupancaButton = new JButton("Depositar");
        JButton withdrawPoupancaButton = new JButton("Sacar");
=======
        JButton depositButton = new JButton("Depositar");
        JButton depositPoupancaButton = new JButton("Depositar na Poupança");
        JButton withdrawButton = new JButton("Sacar");
        JButton withdrawPoupancaButton = new JButton("Sacar da Conta Poupança");
>>>>>>> 53c6ece (Mexi em algumas coisas aqui.)
        JButton rendimentoButton = new JButton("Calcular Rendimento");
        JButton TransferirCorrentePoupancaButton = new JButton("Transferência Corrente -> Poupança");
        JButton TransferirPoupancaCorrenteButton = new JButton("Transferência Poupança -> Corrente");

<<<<<<< HEAD
        JTextField amountCorrenteField = new JTextField(10);
        JTextField amountPoupancaField = new JTextField(10);
        JLabel balanceLabelCorrente = new JLabel("Saldo Conta Corrente: " + contaCorrente.getSaldo());
        JLabel balanceLabelPoupanca = new JLabel("Saldo Conta Poupança: " + contaPoupanca.getSaldo());
=======
        //JTextField amountField = new JTextField(10);
        JTextField amountCorrenteField = new JTextField(10);
        JTextField amountPoupancaField = new JTextField(20);

        JLabel balanceLabelCorrente = new JLabel("Saldo Conta Corrente: " + contaCorrente.getSALDO() + "\n");
        JLabel balanceLabelPoupanca = new JLabel("Saldo Conta Poupança: " + contaPoupanca.getSALDO() + "\n");
>>>>>>> 53c6ece (Mexi em algumas coisas aqui.)

        // Ação para depósito na conta corrente
        depositCorrenteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
                double amount = Double.parseDouble(amountCorrenteField.getText());
                contaCorrente.depositar(amount);
                balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSaldo());
=======

                double amount = Double.parseDouble(amountCorrenteField.getText());

                //double amount = Double.parseDouble(amountCorrenteField.getText());
                contaCorrente.DEPOSITAR(amount);
                balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSALDO());
>>>>>>> 53c6ece (Mexi em algumas coisas aqui.)
            }
        });

        // Ação para saque na conta corrente
        withdrawCorrenteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
<<<<<<< HEAD
                    double amount = Double.parseDouble(amountCorrenteField.getText());
                    contaCorrente.sacar(amount);
                    balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSaldo());
=======

                    double amount = Double.parseDouble(amountCorrenteField.getText());
                    contaCorrente.SACAR(amount);
                    balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSALDO());

                  //  double amount = Double.parseDouble(amountCorrenteField.getText());
                  //  contaCorrente.SACAR(amount);
                  //  balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSALDO());
>>>>>>> 53c6ece (Mexi em algumas coisas aqui.)
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
<<<<<<< HEAD

        // Ação para transferir Corrente para Conta (pendente)
=======
        // Ação para transferir Corrente para Poupança (pendente)
>>>>>>> 53c6ece (Mexi em algumas coisas aqui.)
        TransferirCorrentePoupancaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountCorrenteField.getText());
<<<<<<< HEAD
                    contaCorrente.transferir(contaPoupanca, amount);
                    balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSaldo());
                    balanceLabelPoupanca.setText("Saldo Conta Poupança: " + contaPoupanca.getSaldo());
=======
                    contaCorrente.TRANSFERIR(contaPoupanca, amount);
                    balanceLabelCorrente.setText("Saldo Conta Corrente: " + contaCorrente.getSALDO());
                    balanceLabelPoupanca.setText("Saldo Conta Poupança: " + contaPoupanca.getSALDO());
>>>>>>> 53c6ece (Mexi em algumas coisas aqui.)
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
<<<<<<< HEAD
        frame.add(new JLabel("Valor Corrente:"));
        frame.add(amountCorrenteField);
        frame.add(depositCorrenteButton);
        frame.add(withdrawCorrenteButton);
        frame.add(TransferirCorrentePoupancaButton);
        frame.add(balanceLabelCorrente);

        frame.add(new JLabel("Valor Poupança:"));
=======
        frame.add(new JLabel("Valor Conta Corrente:"));
        frame.add(amountCorrenteField);
        frame.add(depositButton);
        frame.add(withdrawButton);
        frame.add(TransferirCorrentePoupancaButton);
        frame.add(balanceLabelCorrente);

        frame.add(new JLabel("Valor Conta Poupança: "));
>>>>>>> 53c6ece (Mexi em algumas coisas aqui.)
        frame.add(amountPoupancaField);
        frame.add(depositPoupancaButton);
        frame.add(withdrawPoupancaButton);
        frame.add(TransferirPoupancaCorrenteButton);
<<<<<<< HEAD
=======
        frame.add(rendimentoButton);
>>>>>>> 53c6ece (Mexi em algumas coisas aqui.)
        frame.add(balanceLabelPoupanca);

        frame.add(rendimentoButton);

        frame.setVisible(true);
    }
}
