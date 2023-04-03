public class Main{
  public static void main(String[] args){
    Divida divida = new Divida(1000);
    System.out.println("Valor da divida: " + divida.getvalor());

    Juros dividaJuros = new Juros(divida,10);
    System.out.println("Divida com juros de 10%: " + dividaJuros.getvalor());

    JurosComDesconto dividaJurosDesconto = new JurosComDesconto(dividaJuros,3);
    System.out.println("Divida Com juros de 10% + 3% de desconto: " + dividaJurosDesconto.getvalor());

    JurosComDescontoTaxa dividaJurosDescontoTaxa = new JurosComDescontoTaxa(dividaJurosDesconto, 18);
    System.out.println("Divida Com juros de 10% + 3% de desconto + 18% de taxa: " + dividaJurosDescontoTaxa.getvalor());

  }
}
