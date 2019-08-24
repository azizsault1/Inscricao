package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Candidato;
import servicos.CandidatoServico;
import validadores.PreValidador;

public class Janela extends JFrame {
   private static final long serialVersionUID = 1L;
   private static final int ALTURA_TELA = 250;
   private static final int LARGURA_TELA = 300;
   private static final int ALTURA_COMPONENTES_PADRAO = 20;
   private static final int LARGURA_COMPONENTE_PADRAO = 200;
   private static final int LINHA = 15;
   private static final int Y_INICIAL = 20;
   private static final int MARGIN = (LARGURA_TELA / 2) - (LARGURA_COMPONENTE_PADRAO / 2);
   private static final String RESULTADO = "O Resultado eh: ";

   private final PreValidador preValidator;
   private final CandidatoServico service;
   private JLabel error;
   private JLabel resultado;

   public Janela() {
      this.preValidator = new PreValidador();
      this.service = new CandidatoServico();
      this.addComponents();
      this.configureWindow();
   }

   private void configureWindow() {
      this.setVisible(Boolean.TRUE);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setTitle("Cadastro de usuario");
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

      final JLabel inscLabel = new JLabel("Numero de inscricao:");
      inscLabel.setBounds(MARGIN, Y_INICIAL, LARGURA_COMPONENTE_PADRAO, ALTURA_COMPONENTES_PADRAO);
      this.getContentPane().add(inscLabel);

      final JTextField inscricao = new JTextField();
      int proximoY = this.calculaProximoY(Y_INICIAL);
      inscricao.setBounds(MARGIN, proximoY, LARGURA_COMPONENTE_PADRAO, ALTURA_COMPONENTES_PADRAO);
      inscricao.addKeyListener(new KeyAdapter() {
         @Override
         public void keyTyped(final KeyEvent e) {
            Janela.this.error.setText("");
            final String insc = inscricao.getText() + e.getKeyChar();
            final boolean isNotValid = !Janela.this.preValidator.isValid(insc);
            if (isNotValid) {
               Janela.this.error.setText(Janela.this.preValidator.getErros());
               e.consume();
            }
         }
      });
      contentPane.add(inscricao);

      final JButton calcular = new JButton("OK");
      proximoY = this.calculaProximoY(proximoY);
      final int LARGURA_OK = 100;
      calcular.setBounds(this.calculaMargin(LARGURA_OK), proximoY, LARGURA_OK, ALTURA_COMPONENTES_PADRAO);
      calcular.addActionListener(e -> {
         this.executaProcesso(inscricao.getText());
      });
      contentPane.add(calcular);

      this.error = new JLabel("");
      proximoY = this.calculaProximoY(proximoY);
      final int LARGURA_ERRO = 260;
      this.error.setForeground(Color.RED);
      this.error.setBounds(this.calculaMargin(LARGURA_ERRO), proximoY, LARGURA_ERRO, ALTURA_COMPONENTES_PADRAO);
      contentPane.add(this.error);

      this.resultado = new JLabel(RESULTADO);
      proximoY = this.calculaProximoY(proximoY);
      this.resultado.setBounds(MARGIN, proximoY, LARGURA_COMPONENTE_PADRAO, ALTURA_COMPONENTES_PADRAO);
      contentPane.add(this.resultado);

      this.setContentPane(contentPane);
   }

   private void executaProcesso(final String inscricao) {
      this.error.setText("");
      try {
         final Candidato candidato = this.service.registrarCandidato(new Candidato(inscricao));
         this.resultado.setText(RESULTADO + candidato.getPosicao());
      } catch (final Exception e) {
         this.error.setText(e.getMessage());
      }
   }

   public static void main(final String[] args) {
      new Janela();
   }
}