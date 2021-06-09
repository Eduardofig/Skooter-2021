import java.io.FileInputStream;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Insira o nome do arquivo: ");
        String nomeArquivo = inputScanner.nextLine();
        int i = 1;
        try
        {
            FileInputStream streamArquivo = new FileInputStream(nomeArquivo);
            Scanner fileScanner = new Scanner(streamArquivo);
            while(fileScanner.hasNextLine()) System.out.println(String.valueOf(i++) + ':' + fileScanner.nextLine());
            inputScanner.close();
            fileScanner.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
