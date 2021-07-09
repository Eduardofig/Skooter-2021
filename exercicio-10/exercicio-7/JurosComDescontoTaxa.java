public class JurosComDescontoTaxa extends DividaDecorator{
  public JurosComDescontoTaxa(DividaAbstrata dividaaserdecorada, float parametro){
    super(dividaaserdecorada,parametro);
  }

  public float getvalor(){
    return divida.getvalor() + (divida.getvalor() * parametro / 100 );
  }
}
