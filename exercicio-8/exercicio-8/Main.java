import java.util.Scanner;

public class Main 
{
    public static void main(String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Insira o nome do arquivo: ");
        String nomeArquivo = inputScanner.nextLine();
        MeuLineNumberReader reader = new MeuLineNumberReader(nomeArquivo);
        reader.readLine();
        reader.closeScanner();
        inputScanner.close();
    }
}
