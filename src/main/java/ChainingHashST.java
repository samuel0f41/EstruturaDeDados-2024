import java.util.Deque;

import static java.nio.file.Files.delete;
import static javax.swing.UIManager.get;

public class ChainingHashST <Key, Value> {
    private static final int INIT_CAPACITY = 4; //PARTE LETICIA ChainingHashST-1
    private int n;
    private int m;
    private DequeSearch<Key, Value>[] st;

    /*Inicializa uma tabela de símbolos vazias
     */

    public ChainingHashST() {
        this(INIT_CAPACITY);
    }

    /*inicializa uma tabela de símbolos vazia com cadeias {@code m}.
@param m as cadeias numéricas iniciais
     */
    public ChainingHashST(int m) {
        this.m = m;
        st = (DequeSearch<Key, Value>[]) new DequeSearch[m];
        for (int i = 0; i < m; i++)
            st[i] = new DequeSearch<Key, Value>();
    }

    /*redimensionar a tabela hash para ter o número determinado de cadeias,
     refazendo todas as chaves
     */
    private void resize(int chains) {
        ChainingHashST<Key, Value> temp = new ChainingHashST<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m = temp.m;
        this.n = temp.n;
        this.st = temp.st;
    }

    /*função hash para chaves - retorna valor entre 0 e m-1
     */
    private int hashTextbook(Key key) {
        return (Math.abs(key.hashCode())) % m;
    }

    /*função hash para chaves - retorna valor entre 0 e m-1 (assume que m é uma potência de 2)
    da implementação de java, protege contra implementações de hashCode() de baixa qualidade
     */
    private int hash(Key key) {
        int h = Math.abs(key.hashCode());
        double ftmp = ((Math.sqrt(5) - 1) / 2) * h;
        int itmp = (int) ftmp;
        ftmp = ftmp - itmp;
        itmp = (int) (ftmp * m);
        return itmp;
    /*/* int h = (Math.abs(ket.hashCode()));
    h ^= (h >>> 20) ^ (h >>>> 12) ^ (h >>>>7) ^ (h >>> 4);
    return h & (m-1);
     */
    }

    /*retorna o número de pares de valores-chave nesta
    tabela de símbolos.
     */
    public int size() {
        return n;
    }

    /*retorna verdadeiro se esta tabela de símbolos estiver vazia.
retorne falso caso contrário
     */
    public boolean isEmpty() { //PARTE LETICIA ChainingHashST-2
        return size() == 0;
    }

    /*retorna verdadeiro se esta tabela contém a chave especificada.
chave param a chave
código de retorno verdadeiro se esta tabela de símbolos contém chave de código;
código falso caso contrário
lança IllegalArgumentException se o código-chave for nulo
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /*retorna o valor associado à chave especificada nesta tabela de símbolos.
    chave param a chave
    retornar o valor associado à chave do código na tabela de símbolos;
    código nulo se não houver tal valor.
    lança IllegalArgumentException se a chave do código for nula
     */
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    }

    /*insere o par de valores-chave especificado na tabela de símbolos,
    substituindo o valor antigo pelo novo valor se a tabela de símbolos já contiver a chave especificada.
    Exclui a chave especificada e seu valor associado desta tabela de símbolos se o valor especificado for o código nulo
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException
                ("first argument to put()" +
                        "is null");
        if (val == null) {
            delete(key);
            return;
        }
        /*tamanho duplo da tabela se o comprimento médio da lista> = 10
         */
        if (n >= 10 * m) resize(2 * m);
        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    }

    /*remove a chave especificada e seu valor associado desta tabela de símbolos
    (se a chave estiver nesta tabela de símbolos)
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);

        /*
reduzir pela metade o tamanho da tabela se o comprimento médio da lista <=2
         */
        if (m > INIT_CAPACITY && n <= 2 * m) resize(m / 2);
    }

    /*retornar chaves na tabela de símbolos como um Iterable
     */
    public Iterable<Key> keys() {
        Deque<Key> queue = new Deque<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys())
                queue.push_back(key);
        }
        return queue; //PART IRAN ChainingHashST-3
    }//*/

    /**
     * Unit tests the {@code SeparateChainingHashST} data type.
     * A unidade testa o tipo de dados {@code SeparateChainingHashST}
     *
     * @param args the command-line arguments
     */

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("\n\nUso: java ChainingHashST arquivo1 arquivo2\n\n");
            System.exit(0);
        }
        int n;
        String tmp;
        StringTokenizer st;//== .equals
        ChainingHashST<String, Cidade> tabelahash = new ChainingHashST<String, Cidade>(16);
        Cidade city;

        try {
            FileReader in1 = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(in1);
            n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                tmp = br.readLine();
                st = new StringTokenizer(tmp);

                city = new Cidade(st.nextToken(), Integer.parseInt(st.nextToken()));
                tabelahash.put(city.get_nome(), city);
            }
            br.close();
            in1.close();

            in1 = new FileReader(args[1]);
            br = new BufferReader(in1);

            n = Integer.parseInt(br.readLine);

            for (int j = 0; j < n; j++) {
                tmp = br.readLine();

                city = tabelahash.get(tmp);
                if (city == null) System.out.print("\n[failed] " + tmp" não foi encontrada.");
                else {
                    System.out.print("\n{[ok]\t " + city.get_nome() + " foi encontrada. Temperatura lá é " + city.get_tem() + "F");
                }
            }
            br.close();
            in1.close();

            System.out.println("\n");


        } catch (IOException e) {

        }
        //*/
    }
}

