public class Juros extends DividaDecorator{
  public Juros(DividaAbstrata dividaASerDecorada, float parametro){
    super(dividaASerDecorada,parametro);
  }

  public float getvalor(){
    return divida.getvalor() + (divida.getvalor() * (parametro / 100));
  }
}
