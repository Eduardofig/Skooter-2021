public abstract class SistemaDecorator extends Sistema{
  Sistema sistemadecorado;

  protected SistemaDecorator(Sistema sistemaaserdecorado){
    sistemadecorado = sistemaaserdecorado;
  }
}
