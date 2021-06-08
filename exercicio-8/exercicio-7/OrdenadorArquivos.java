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
            // Abre o Diretorio
            diretorioAlvo = new File(this.getDiretorio());
            //Cria o Array de arquivos contidos no diretorio e os faz o filtro
            //para manter somente os que possuem a extensao .mpe
            arquivos = Arrays.stream(diretorioAlvo.listFiles()).filter(arquivo -> arquivo.getName().endsWith(".mp3")).toArray(File[]::new);
            ArrayList<File> listaDeArquivosOrdenados = new ArrayList<File>();
            Pair[] Pares = new Pair[arquivos.length];
            for (int i = 0; i < arquivos.length; i++) Pares[i] = new Pair(arquivos[i]);

            Arrays.sort(Pares);

            // Faz um array com os apenas os arquivos ordenados do array de pares
            for (int i = 0; i < arquivos.length; i++){
                arquivos[i] = Pares[i].arquivo;
                // Print dos arquivos ordenados com os seus respectivos tamanhos
                System.out.println(arquivos[i].getName() + " - " + arquivos[i].length());
                al.add(arquivos[i].getName());
            }
        }
        catch(Exception e)
        {
            // Catch para se ocorra alguma excessao
            e.printStackTrace();
        }
    }
    OrdenadorArquivos(String diretorio) 
    {
        setDiretorio(diretorio);
    }
}
