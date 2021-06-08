import java.io.File;

class Pair implements Comparable 
{
    public long tamanho;
    public File arquivo;

    public Pair(File file)
    {
        arquivo = file;
        tamanho = file.length();
    }

    public int compareTo(Object o) 
    {
        long tamanho_o = ((Pair)o).tamanho;
        return tamanho < tamanho_o ? -1 : tamanho == tamanho_o ? 0 : 1;
    }
};

