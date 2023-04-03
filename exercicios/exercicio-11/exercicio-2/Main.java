import java.util.Random;

public class Main{
  public static void main(String[] args){
    Random r = new Random();
    Integer[] arrayDeInt = new Integer[10];
    Float[] arrayDeFloat = new Float[10];

    //Construção e ordenação de um array de inteiros
    System.out.println("-------------------------------------");
    System.out.println("Array de inteiros antes da ordenacao");
    System.out.println("-------------------------------------");
    for(int i = 0; i < arrayDeInt.length; i++){
      arrayDeInt[i] = new Integer(r.nextInt(10000));
      System.out.println("\t" + arrayDeInt[i].toString());
    }
    (new OrdenacaoInsertion()).<Integer>sort(arrayDeInt);
    System.out.println("-------------------------------------");
    System.out.println("Array de inteiros depois da ordenacao");
    System.out.println("-------------------------------------");
    for(int i = 0; i < arrayDeInt.length; i++){
      System.out.println("\t" + arrayDeInt[i].toString());
    }
    System.out.println("-------------------------------------\n\n");
    //Fim da construção e ordenação de um array de inteiros

    //Construção e ordenação de um array de float
    System.out.println("-------------------------------------");
    System.out.println("Array de floats antes da ordenacao");
    System.out.println("-------------------------------------");
    for(int i = 0; i < arrayDeFloat.length; i++){
      arrayDeFloat[i] = new Float(r.nextFloat());
      System.out.println("\t" + arrayDeFloat[i].toString());
    }
    (new OrdenacaoInsertion()).<Float>sort(arrayDeFloat);
    System.out.println("-------------------------------------");
    System.out.println("Array de floats depois da ordenacao");
    System.out.println("-------------------------------------");
    for(int i = 0; i < arrayDeFloat.length; i++){
      System.out.println("\t" + arrayDeFloat[i].toString());
    }
    System.out.println("-------------------------------------");
    //Fim da construção e ordenação de um array de float
  }
}
