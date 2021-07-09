public class JurosComDesconto extends DividaDecorator{
  public JurosComDesconto(DividaAbstrata dividaaserdecorada, float parametro){
    super(dividaaserdecorada,parametro);
  }

  public float getvalor(){
    return divida.getvalor() - (divida.getvalor() * parametro / 100 );
  }
}
