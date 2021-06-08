import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class OrdenadorArquivos
{
    protected String diretorio;

    public void setDiretorio(String diretorio)
    {
        this.diretorio = diretorio;
    }

    public String getDiretorio()
    {
        return this.diretorio;
    }

    public void OrdenarArquivos() 
    {
        File diretorioAlvo = null;
        File[] arquivos;

        final ArrayList<String> al= new ArrayList<String>();

        try
        {      
            // create new file object
            diretorioAlvo = new File(this.getDiretorio());
            // array of files and directory
            arquivos = diretorioAlvo.listFiles();
            ArrayList<File> listaDeArquivosOrdenados = new ArrayList<File>();
            Pair[] Pares = new Pair[arquivos.length];
            for (int i = 0; i < arquivos.length; i++) Pares[i] = new Pair(arquivos[i]);

            Arrays.sort(Pares);

            // Take the sorted pairs and extract only the file part, discarding the timestamp.
            for (int i = 0; i < arquivos.length; i++) arquivos[i] = Pares[i].arquivo;

            for(File file: arquivos) {
                // prints filename and directory name
                System.out.println(file.getName()+" - " +file.length() );
                al.add(file.getName());
            }
            //for()
        }
        catch(Exception e)
        {
            // if any error occurs
            e.printStackTrace();
        }
    }
    OrdenadorArquivos(String diretorio) 
    {
        setDiretorio(diretorio);
    }
}
