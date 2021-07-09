public abstract class DividaDecorator extends DividaAbstrata{
  DividaAbstrata divida;
  protected float parametro;

  protected DividaDecorator(DividaAbstrata dividaent, float parametro){
    divida = dividaent;
    this.parametro = parametro;
  }
}
