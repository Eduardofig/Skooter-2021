import java.math.BigInteger;
import java.util.Random;

public class ClasseExemplo{
  public static void main(String args[]){
    Random r = new Random();
    RaizQuadrada rq = new RaizQuadrada();
    BigInteger i;
    BigInteger k;
    Double j;
    k = BigInteger.valueOf(5);
        for(i = BigInteger.valueOf(0);i.compareTo(new BigInteger("1000000000"))
            <=0;i=i.add(BigInteger.ONE))
        {
          j = r.nextDouble();
          System.out.println(rq.RaizQuadrada(j));
        }
  }
}
