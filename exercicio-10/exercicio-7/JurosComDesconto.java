public class JurosComDesconto extends DividaDecorator{
  public JurosComDesconto(DividaAbstrata dividaASerDecorada, float parametro){
    super(dividaASerDecorada,parametro);
  }

  public float getvalor(){
    return divida.getvalor() - (divida.getvalor() * parametro / 100 );
  }
}
