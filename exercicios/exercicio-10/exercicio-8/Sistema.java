public class Sistema{
  public void enviadadospessoafisica(String s){
    if(s.contains("789")){
        System.out.println("Os dados foram roubados");
    }else{
        System.out.println("Dados enviado sem problema");
    }
  }

  public void enviadadospessoajuridica(String s){
    if(s.contains("789")){
        System.out.println("Os dados foram roubados");
    }else{
        System.out.println("Dados enviado sem problema");
    }
  }
}
