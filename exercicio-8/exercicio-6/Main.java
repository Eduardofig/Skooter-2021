import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Path path = Paths.get("test.txt");
            Charset charset = StandardCharsets.UTF_8;
            String content = new String(Files.readAllBytes(path), charset);
            content = content.replaceAll("muito", "pouco");
            Files.write(path, content.getBytes(charset));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
