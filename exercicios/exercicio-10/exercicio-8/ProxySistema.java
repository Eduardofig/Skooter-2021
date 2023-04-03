public class ProxySistema{
  Sistema sistema;
  ProxySistema(){
    sistema = new Sistema();
  }

  void enviadadospessoafisica(String s){
    if(s.contains("789")){
      System.out.println("ERRO: Tentativa de roubo de dados");
    }else{
      sistema.enviadadospessoafisica(s);
    }
  }

  void enviadadospessoajuridica(String s){
    if(s.contains("789")){
      System.out.println("ERRO: Tentativa de roubo de dados");
    }else{
      sistema.enviadadospessoajuridica(s);
    }
  }
}
