import java.util.ListIterator;
import java.util.NoSuchElementException;
public class Deque<Item> implements Iterable<Item> {

    private int n; //Contador de elementos
    private No Sentinela; //Nó artificial para marcar inicio e fim

    public Deque(){
        n = 0;
        Sentinela = new No();
        Sentinela.prox = Sentinela;
        Sentinela.ant = Sentinela;
    }

    private class No {//Classe Nó
        private Item dado;
        private No prox;

        private No ant;
    }
    public void push_front(Item item){
        //criar novo no e armazenar dados
        No tmp = new No();
        tmp.dado = item;

        //definir anterior e proximo do novo no
        tmp.ant = Sentinela;
        tmp.prox = Sentinela.prox;
        ++n;
    }
    public void push_back(Item item){
        //criar novo no e armazenar dados
        No tmp = new No();
        tmp.prox = Sentinela;

        //ajustar a sentinela e o anterior
        Sentinela.ant = tmp;
        tmp.ant.prox = tmp;
        n++;
    }
    public Item pop_front(){
        No tmp = Sentinela.prox;
        Item meuDado = tmp.dado;
    }
}
