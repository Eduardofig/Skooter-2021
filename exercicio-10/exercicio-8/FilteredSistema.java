public class FilteredSistema extends SistemaDecorator{
  public FilteredSistema(Sistema sistemaaserdecorado){
    super(sistemaaserdecorado);
  }

  public void enviadadospessoafisica(String s){
    if(s.contains("789")){
      s = s.replaceAll("789","987");
      System.out.println("Risco eliminado com sucesso");
    }
  }

  public void enviadadospessoajuridica(String s){
    if(s.contains("789")){
      s = s.replaceAll("789","987");
      System.out.println("Risco eliminado com sucesso");
    }
  }
}
