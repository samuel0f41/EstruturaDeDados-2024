import java.util.ListIterator; //PART HAYRON DequeSearch-1
import java.util.NoSuchElementException;
public class DequeSearch<Key, Value> {
    private int n; //Contador de elementos
    private No Sentinela; //Nó artificial para marcar início e fim

    public DequeSearch() {
        n = 0;
        Sentinela = new No();
        Sentinela.prox = Sentinela;
        Sentinela.ant = Sentinela;
    }

    private class No {//Classe Nó
        private Item dado;
        private Key chave;
        private No prox;
        private No ant;
    }

    public void push_front(Key key, Item item) {
        //criar novo no e armazenar dados
        No tmp = new No();
        tmp.dado = item;
        tmp.chave = key;

        //definir anterior e proximo do novo no
        tmp.ant = Sentinela;
        tmp.prox = Sentinela.prox;

        //ajustar a sentinela e o seguinte
        Sentinela.prox = tmp;
        tmp.prox.ant = tmp;
        ++n;
    }

    public void push_back(Key key, Item item){
        //criar novo no e armazenar dados
        No tmp = new No();
        tmp.dado = item;
        tmp.chave = key;

        //definir anterior e proximo do novo no
        tmp.ant = Sentinela.ant;
        tmp.prox = Sentinela;

        //ajustar a sentinela e o anterior
        Sentinela.ant = tmp;
        tmp.ant.prox = tmp;
        n++;
    }

    public boolean contains (Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        //tradução google: argumento para contains() é nulo
        return get(key) != null;
    }

    public Item get (Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        //tradução google: argumento para get() é nulo
        for (No x = Sentinela.prox; x != Sentinela; x = x.prox){
            if (key.equals(x.chave)){
                return x.dado;  //PARTE HAYRON DequeSeach-2
            }
        }
        return null;
    }

    public void delete (Key key){
        if (key == null) throw new IllegalArgumentException("argumente to delete() is null");
        //tradução google: argumento para delete() é nulo
    }

    private void remove(No tmp){
        tmp.ant.prox = tmp.prox;
        //Atualizar o no proximo para apontar para o anterior do que sera removido
        tmp.prox.ant = tmp.ant;
        --n;
    }

    private void delete(No x, Key key){
        if (x == Sentinela) return;
        if (key.equals(x.chave)){
            remove(x);
            return;
        }
        delete(x.prox, key);
    }

    public void put(Key key, Item val){
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        // tradução google: o primeiro argumento para put() é nulo
        if (val == null){
            delete(key);
            return;
        }
        for (No x = Sentinela.prox; x != Sentinela; x = x.prox){
            if (key.equals(x.chave)){
                x.dado = val;
                return;
            }
        }
        push_front(key, val);
    }

    public Item pop_front(){
        No tmp = Sentinela.prox;
        Item meuDado = tmp.dado;
        //atualizar o nó anterior para apontar para o próximo do que sera removido
        tmp.ant.prox = tmp.prox;
        //Atualizar o nó proximo para apontar para o anterior do que sera removido
        tmp.prox.ant = tmp.ant;
        --n;
        return meuDado;
    }

    public Item pop_back (){
        No tmp = Sentinela.ant;
        Item meuDado = tmp.dado;
        //Atualizar o nó anterior para apontar para o proximo do que sera removido
        tmp.ant.prox = tmp.prox;
        //Atualizar o nó proximo para apontar para o anterior do sera removido
        tmp.prox.ant = tmp.ant;
        --n;
        return meuDado;
    }
    //Tu começa daqui de baixo Wendel
    public No first(){

    }
}