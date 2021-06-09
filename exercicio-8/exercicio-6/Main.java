import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main
{
    public static void main(String[] args)
    {
        System.out.print("Insira o nome do arquivo: ");
        Scanner inputScanner = new Scanner(System.in);
        String nomeArquivo = inputScanner.nextLine();
        try
        {
            Path path = Paths.get(nomeArquivo);
            Charset charset = StandardCharsets.UTF_8;
            String content = new String(Files.readAllBytes(path), charset);
            content = content.replaceAll("muito", "pouco");
            Files.write(path, content.getBytes(charset));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        inputScanner.close();
    }
}
