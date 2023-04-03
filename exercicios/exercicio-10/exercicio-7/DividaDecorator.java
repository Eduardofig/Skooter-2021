public abstract class DividaDecorator extends DividaAbstrata{
  DividaAbstrata divida;
  protected float parametro;

  protected DividaDecorator(DividaAbstrata dividaEnt, float parametro){
    divida = dividaEnt;
    this.parametro = parametro;
  }
}
