public class Main{
  public static void main(String[] args){
    Divida divida = new Divida(1000);
    System.out.println("Valor da divida: " + divida.getvalor());

    Juros dividajuros = new Juros(divida,10);
    System.out.println("Divida com juros de 10%: " + dividajuros.getvalor());

    JurosComDesconto dividajurosdesconto = new JurosComDesconto(dividajuros,3);
    System.out.println("Divida Com juros de 10% + 3% de desconto: " + dividajurosdesconto.getvalor());

    JurosComDescontoTaxa dividajurosdescontotaxa = new JurosComDescontoTaxa(dividajurosdesconto, 18);
    System.out.println("Divida Com juros de 10% + 3% de desconto + 18% de taxa: " + dividajurosdescontotaxa.getvalor());

  }
}
