public class JurosComDescontoTaxa extends DividaDecorator{
  public JurosComDescontoTaxa(DividaAbstrata dividaASerDecorada, float parametro){
    super(dividaASerDecorada,parametro);
  }

  public float getvalor(){
    return divida.getvalor() + (divida.getvalor() * parametro / 100 );
  }
}
