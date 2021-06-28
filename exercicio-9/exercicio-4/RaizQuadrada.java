public class RaizQuadrada{
  public static double RaizQuadrada(double number) {
    double temp;

    double sr = number / 2;

    do {
      temp = sr;
      sr = (temp + (number / temp)) / 2;
    }while((temp - sr) != 0);
    return sr;
  }
}
