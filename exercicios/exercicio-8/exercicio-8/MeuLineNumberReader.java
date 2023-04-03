import java.io.FileInputStream;
import java.util.Scanner;

public class MeuLineNumberReader
{
    protected FileInputStream fStream;
    protected Scanner fileScanner;
    public void closeScanner()
    {
        this.fileScanner.close();
    }
    public void readLine()
    {
        try
        {
            for(int i = 1; fileScanner.hasNextLine(); i++) {
                LineDecorator linhaComNumero = new LineDecorator(fileScanner.nextLine(), i);
                System.out.println(linhaComNumero.getDecoratedLine());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    MeuLineNumberReader(String nomeArquivo)
    {
        try
        {
            this.fStream = new FileInputStream(nomeArquivo);
            this.fileScanner = new Scanner(fStream);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
