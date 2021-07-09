public class MeusVetoresDiferenca implements MeusVetoresFunction{
  protected int[] vetdiferenca;
  protected int tamanho;
  protected int[] vet1;
  protected int[] vet2;

  public int[] ExecutaFuncoes(MeusVetores mv){
    this.vet1 = new int[mv.getvet1().length];
    this.vet1 = mv.getvet1();
    this.vet2 = new int[mv.getvet2().length];
    this.vet2 = mv.getvet2();

    tamanho = mv.getvet2().length;

    for(int i = 0; i < mv.getvet1().length; i++){
      for(int j = 0; j < mv.getvet2().length; j++){
        if(this.vet2[i] == this.vet1[j]){
          tamanho--;
        }
      }
    }

    vetdiferenca = new int[tamanho];

    int[] posicaovet2 = new int[tamanho];
    boolean igual;
    int m = 0;
    for(int j = 0; j < mv.getvet2().length; j++){ //localiza as posições de vet2 que tem um elemento diferente
      igual = false;
      for(int k = 0; k < mv.getvet1().length; k++){
        if(this.vet2[j] == this.vet1[k]){
          igual = true;
          break;
        }
      }
      if(igual == false){
        vetdiferenca[m] = this.vet2[j];
        m++;
      }
    }

    return this.vetdiferenca;
  }
}
