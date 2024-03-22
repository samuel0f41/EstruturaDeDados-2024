package br.ufpb.samuel;
import java.util.List;
public interface SistemaQuiz {
    void cadastraPergunta (Pergunta p);
    Pergunta sorteiaPergunta();
    List<Pergunta> todasAsPerguntas();


}
