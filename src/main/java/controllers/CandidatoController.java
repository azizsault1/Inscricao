package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Candidato;
import servicos.CandidatoServico;

@RestController("/candidato")
public class CandidatoController {

   private final CandidatoServico servico;

   @Autowired
   public CandidatoController(final CandidatoServico servico) {
      this.servico = servico;
   }

   @GetMapping
   public String helloGradle(@RequestParam(required = true, name = "inscricao") final String inscricao) {
      final Candidato candidato = this.servico.registrarCandidato(inscricao);
      return Integer.toString(candidato.getPosicao());
   }
}
