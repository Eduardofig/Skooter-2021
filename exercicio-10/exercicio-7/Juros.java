public class Juros extends DividaDecorator{
  public Juros(DividaAbstrata dividaaserdecorada, float parametro){
    super(dividaaserdecorada,parametro);
  }

  public float getvalor(){
    return divida.getvalor() + (divida.getvalor() * (parametro / 100));
  }
}
