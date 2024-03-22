package br.ufpb.samuel;

public abstract class Pergunta {
    private String enuciado;
    private String respostaCorreta;


    public abstract boolean estaCorretaResposta(String resposta);

    public Pergunta (String enuciado, String respostaCorreta){
        this.enuciado = enuciado;
        this.respostaCorreta = respostaCorreta;
    }
    public Pergunta (){
        this("","");
    }


    public String getEnuciado() {
        return enuciado;
    }

    public void setEnuciado(String enuciado) {
        this.enuciado = enuciado;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }


}
