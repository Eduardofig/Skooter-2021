import java.util.Iterator;

public class MeusVetores{
  private int[] vet1;
  private int[] vet2;

  public MeusVetores(int[] vet1, int[] vet2){
    this.vet1 = vet1.clone();
    this.vet2 = vet2.clone();
  }


  public void imprimevetor(){
    int i;

    System.out.println("Vetor 1");
    for(i = 0; i < this.vet1.length; i++){
      System.out.println(this.vet1[i]);
    }
    System.out.println("\nVetor2");
    for(i = 0; i < this.vet2.length; i++){
      System.out.println(this.vet2[i]);
    }
  }

  //getter
  public int[] getvet1(){
    return this.vet1;
  }

  public int[] getvet2(){
    return this.vet2;
  }

  public int[] MeusVetoresNovaFuncao(MeusVetoresFunction mvfun){
    return mvfun.ExecutaFuncoes(this);
  }
}
