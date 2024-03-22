package br.ufpb.samuel;

import java.util.Arrays;
import java.util.Objects;

public class PerguntaME extends Pergunta{

    private String [] alternativas;

    public PerguntaME(String enuciado, String[] alternativas, String respostaCorreta) {
        super(enuciado, respostaCorreta);
        this.alternativas = alternativas;
    }

    public PerguntaME() {
        this("", new String [] {}, "");
    }

    @Override
    public boolean estaCorretaResposta(String resposta) {
        if(resposta.equals(super.getRespostaCorreta())){
            return true;
        }
        return false;
    }

    public String[] getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(String[] alternativas) {
        this.alternativas = alternativas;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PerguntaME that = (PerguntaME) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Objects.equals(super.getEnuciado(), that.getEnuciado())
                && Objects.equals(super.getRespostaCorreta(), that.getRespostaCorreta())
                &&Arrays.equals(alternativas, that.alternativas);
    }

    @Override
    public int hashCode() {
        return super.getEnuciado().hashCode() + super.getRespostaCorreta().hashCode()+Arrays.hashCode(alternativas);
    }

    @Override
    public String toString() {
        return "PerguntaME{" +
                "alternativas=" + Arrays.toString(alternativas) +
                '}';
    }
}
