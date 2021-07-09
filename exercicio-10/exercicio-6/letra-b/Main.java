public class Main{
  public static void main(String[] args){
    int[] vet1 = new int[10];
    int[] vet2 = new int[10];
    int[] vetuniao;
    int[] vetinterseccao;
    int[] vetdiferenca;
    int tamanho;
    int i;

    for(i = 0; i < 10; i++){
      vet1[i] = i;
      vet2[i] = (i * 2) + 1;
    }

    MeusVetores mv = new MeusVetores(vet1, vet2);
    MeusVetoresFunctionFactory factory = new MeusVetoresFunctionFactory();

    //União dos dois vetores
    System.out.println("Uniao entre dois vetores");
    vetuniao = mv.MeusVetoresNovaFuncao(factory.fabricarFuncao("uniao"));

    for(i = 0; i < vetuniao.length; i++){
      System.out.println(vetuniao[i]);
    }
    System.out.println("\n");

    //Intersecção dos dois vetores
    System.out.println("Interseccao entre dois vetores");
    vetinterseccao = mv.MeusVetoresNovaFuncao(factory.fabricarFuncao("interseccao"));

    for(i = 0; i < vetinterseccao.length; i++){
      System.out.println(vetinterseccao[i]);
    }
    System.out.println("\n");

    //Diferença dos dois vetores sendo vet2 - vet1
    System.out.println("Diferenca entre dois vetores");
    vetdiferenca = mv.MeusVetoresNovaFuncao(factory.fabricarFuncao("diferenca"));

    for(i = 0; i < vetdiferenca.length; i++){
      System.out.println(vetdiferenca[i]);
    }
  }
}
