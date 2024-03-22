package br.ufpb.samuel;
import java.util.List;
import java.util.LinkedList;
public class SistemaQuizSamuel implements SistemaQuiz{
    private List<Pergunta> perguntas;

    public SistemaQuizSamuel(){
        this.perguntas = new LinkedList<>();
    }
    public SistemaQuizSamuel(List<Pergunta> perguntas){
        this.perguntas = perguntas;
    }
    public void cadastraPergunta(Pergunta p) {
        this.perguntas.add(p);
    }
    public Pergunta sorteiaPergunta() {
        if(this.perguntas.size()==0 ){
            return null;
        }else{
            //TODO: melhorar usando random
            return this.perguntas.get(0);

        }

    }

    public List<Pergunta> todasAsPerguntas(){
        return this.perguntas;
    }
}
