 return queue;
}//*/

/**
 * Unit tests the {@code SeparateChainingHashST} data type.
 * A unidade testa o tipo de dados {@code SeparateChainingHashST}
 *
 * @param args the command-line arguments
 */

public static void main(String[] args){
    if(args.length < 2){
        System.out.println("\n\nUso: java ChainingHashST arquivo1 arquivo2\n\n");
        System.exit(0);
    }
    int n;
    String tmp;
    StringTokenizer st;//== .equals
    ChainingHashST<String,Cidade> tabelahash = new ChainingHashST<String, Cidade>(16);
    Cidade city;

    try{
        FileReader in1 = new FileReader (args[0]);
        BufferedReader br = new BufferedReader(in1);
        n = Integer.parseInt(br.readLine());

        for(int j=0; j < n; j++){
            tmp = br.readLine();
            st = new StringTokenizer(tmp);

            city = new Cidade(st.nextToken(),Integer.parseInt(st.nextToken()));
            tabelahash.put(city.get_nome(),city);
        }
        br.close();
        in1.close();

        in1 = new FileReader (args[1]);
        br = new BufferReader(in1);

        n = Integer.parseInt(br.readLine);

        for(int j=0; j < n; j++){
            tmp = br.readLine();

            city = tabelahash.get(tmp);
            if(city == null) System.out.print("\n[failed] "+tmp" não foi encontrada.");
            else{
                System.out.print("\n{[ok]\t "+city.get_nome()+ " foi encontrada. Temperatura lá é "+city.get_tem()+"F");
            }
        }
        br.close();
        in1.close();

        System.out.println("\n");



    }catch (IOException e){

    }
    //*/
}


