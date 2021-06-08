import java.io.File;
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
        String ordem, nomeArquivo;

        try
        {      
            //Abre o Diretorio
            diretorioAlvo = new File(this.getDiretorio());
            //Cria o Array de arquivos contidos no diretorio e os faz o filtro
            //para manter somente os que possuem a extensao .mpe
            arquivos = Arrays.stream(diretorioAlvo.listFiles()).filter(arquivo -> arquivo.getName().endsWith(".mp3")).toArray(File[]::new);
            Pair[] Pares = new Pair[arquivos.length];
            for (int i = 0; i < arquivos.length; i++) Pares[i] = new Pair(arquivos[i]);

            Arrays.sort(Pares);

            //Faz um array com os apenas os arquivos ordenados do array de pares
            for (int i = 0; i < arquivos.length; i++) {
                //Rename dos arquivos
                nomeArquivo = Pares[i].arquivo.getName().replace("-", "");
                for (int j = 0; j < 10; j++) nomeArquivo = nomeArquivo.replace(String.valueOf(j), "");
                ordem = String.valueOf(i + 1);
                //Criacao do contador de 4 algarismos
                if(i < 999) ordem = '0' + ordem; if(i < 99) ordem = '0' + ordem; if(i < 9) ordem = '0' + ordem;
                nomeArquivo = this.getDiretorio() + ordem + nomeArquivo + '3';
                Pares[i].arquivo.renameTo(new File(nomeArquivo));
                arquivos[i] = new File(nomeArquivo);
                // Print dos arquivos ordenados com os seus respectivos tamanhos
                System.out.println(arquivos[i].getName() + " - " + arquivos[i].length());
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
        if(!diretorio.endsWith("/")) diretorio += '/';
        setDiretorio(diretorio);
    }
}
