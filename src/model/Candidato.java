package model;

public class Candidato {

   private final String inscricao;
   private int posicao;

   public Candidato(final String inscricao) {
      this.inscricao = inscricao;
   }
   
   public String getInscricao(){
	   return inscricao;
   }

   public int getPosicao() {
      return this.posicao;
   }
   
   public void setPosicao(int posicao){
	   this.posicao = posicao;
   }
}
