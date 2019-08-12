package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import validators.PreValidator;

public class Janela extends JFrame {
   private static final long serialVersionUID = 1L;
   private static final int ALTURA_TELA = 250;
   private static final int LARGURA_TELA = 300;
   private static final int ALTURA_COMPONENTES_PADRAO = 20;
   private static final int LARGURA_COMPONENTE_PADRAO = 200;
   private static final int LINHA = 15;
   private static final int Y_INICIAL = 20;
   private static final int MARGIN = (LARGURA_TELA / 2) - (LARGURA_COMPONENTE_PADRAO / 2);
   private final PreValidator preValidator;

   public Janela() {
      this.preValidator = new PreValidator();
      this.addComponents();
      this.configureWindow();
   }

   private void configureWindow() {
      this.setVisible(Boolean.TRUE);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setTitle("Cadastro de usuário");
      this.setSize(LARGURA_TELA, ALTURA_TELA);
      this.setResizable(Boolean.FALSE);
      this.setLocationRelativeTo(null);
   }

   private int calculaProximoY(final int yAtual) {
      return yAtual + ALTURA_COMPONENTES_PADRAO + LINHA;
   }

   private int calculaMargin(final int larguraComponente) {
      return (LARGURA_TELA / 2) - (larguraComponente / 2);
   }

   private void addComponents() {
      this.setLayout(null);
      final Container contentPane = this.getContentPane();

      final JLabel inscLabel = new JLabel("Número de inscrição:");
      inscLabel.setBounds(MARGIN, Y_INICIAL, LARGURA_COMPONENTE_PADRAO, ALTURA_COMPONENTES_PADRAO);
      this.getContentPane().add(inscLabel);

      final JTextField inscricao = new JTextField();
      int proximoY = this.calculaProximoY(Y_INICIAL);
      inscricao.setBounds(MARGIN, proximoY, LARGURA_COMPONENTE_PADRAO, ALTURA_COMPONENTES_PADRAO);
      inscricao.addKeyListener(new KeyAdapter() {
         @Override
         public void keyTyped(final KeyEvent e) {
            Janela.this.preValidator.validateKeyEvent(e, inscricao.getText());
         }
      });
      contentPane.add(inscricao);

      final JButton calcular = new JButton("OK");
      proximoY = this.calculaProximoY(proximoY);
      final int LARGURA_OK = 100;
      calcular.setBounds(this.calculaMargin(LARGURA_OK), proximoY, LARGURA_OK, ALTURA_COMPONENTES_PADRAO);
      calcular.addActionListener(e -> {
         System.out.println("Calculando..." + inscricao.getText());
      });
      contentPane.add(calcular);

      final JLabel error = new JLabel("");
      proximoY = this.calculaProximoY(proximoY);
      error.setBounds(MARGIN, proximoY, LARGURA_COMPONENTE_PADRAO, ALTURA_COMPONENTES_PADRAO);
      error.setBorder(BorderFactory.createLineBorder(Color.BLUE));
      contentPane.add(error);

      final JLabel resultado = new JLabel("O resultado é: ");
      proximoY = this.calculaProximoY(proximoY);
      resultado.setBounds(MARGIN, proximoY, LARGURA_COMPONENTE_PADRAO, ALTURA_COMPONENTES_PADRAO);
      resultado.setBorder(BorderFactory.createLineBorder(Color.BLUE));
      contentPane.add(resultado);

      this.setContentPane(contentPane);
   }

   public static void main(final String[] args) {
      final Janela j = new Janela();
   }

}
