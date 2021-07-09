public class MeusVetoresUniao implements MeusVetoresFunction{
  protected int[] vetuniao;
  protected int tamanho;
  protected int[] vet1;
  protected int[] vet2;

  public int[] ExecutaFuncoes(MeusVetores mv){
    this.vet1 = new int[mv.getvet1().length];
    this.vet1 = mv.getvet1();
    this.vet2 = new int[mv.getvet2().length];
    this.vet2 = mv.getvet2();
    this.tamanho = mv.getvet1().length + mv.getvet2().length;

    //Calcula o tamanho necessário para o vetuniao
    for(int i = 0; i < mv.getvet1().length; i++){
      for(int j = 0; j < mv.getvet2().length; j++){
        if(this.vet1[i] == this.vet2[j]){
          this.tamanho--;
        }
      }
    }
    this.vetuniao = new int[tamanho];

    //copia o vetor 1 para dentro de vetuniao
    for(int i = 0; i < mv.getvet1().length; i++){
      this.vetuniao[i] = this.vet1[i];
    }

    //adiciona os elementos de vet2 que não existem no vet1
    int[] posicaovet2 = new int[tamanho - mv.getvet1().length];
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
        posicaovet2[m] = j;
        m++;
      }
    }


    m = 0;
    for(int i = mv.getvet1().length; i < tamanho; i++){
      this.vetuniao[i] = this.vet2[posicaovet2[m]];
      m++;
    }

    return this.vetuniao;
  }
}
