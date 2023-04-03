public class MeusVetoresInterseccao implements MeusVetoresFunction{
  protected int[] vetinterseccao;
  protected int tamanho = 0;
  protected int[] vet1;
  protected int[] vet2;

  public int[] ExecutaFuncoes(MeusVetores mv){
    this.vet1 = new int[mv.getvet1().length];
    this.vet1 = mv.getvet1();
    this.vet2 = new int[mv.getvet2().length];
    this.vet2 = mv.getvet2();

    for(int i = 0; i < mv.getvet1().length; i++){
      for(int j = 0; j < mv.getvet2().length; j++){
        if(this.vet1[i] == this.vet2[j]){
          tamanho++;
        }
      }
    }
    vetinterseccao = new int[tamanho];

    int k = 0;
    for(int i = 0; i < mv.getvet1().length; i++){
      for(int j = 0; j < mv.getvet2().length; j++){
        if(this.vet1[i] == this.vet2[j]){
          vetinterseccao[k] = this.vet1[i];
          k++;
        }
      }
    }

    return this.vetinterseccao;
  }
}
