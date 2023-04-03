public class Main{
  public static void main(String[] args){
    //Sem proxy
    System.out.println("Sem o uso de proxy:");
    Sistema sistema = new Sistema();
    sistema.enviadadospessoafisica("123456789");
    sistema.enviadadospessoajuridica("123456789");

    //Com proxy
    System.out.println("\nCom o uso de proxy:");
    ProxySistema proxysistema = new ProxySistema();
    proxysistema.enviadadospessoafisica("123456789");
    proxysistema.enviadadospessoajuridica("123456789");


    //Decorator
    System.out.println("\nCom decorador:");
    FilteredSistema sistemacomfiltro = new FilteredSistema(sistema);
    sistemacomfiltro.enviadadospessoafisica("123456789");
    sistemacomfiltro.enviadadospessoajuridica("123456789");
  }
}
