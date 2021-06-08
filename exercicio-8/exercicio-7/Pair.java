import java.io.File;

//Classe Pair que armazenara o arquivo com o seu respectivo tamanho para
//a ordenacao
class Pair implements Comparable<Object>
{
    public long tamanho;
    public File arquivo;

    public Pair(File file)
    {
        arquivo = file;
        tamanho = file.length();
    }
    @Override
    public int compareTo(Object o) 
    {
        long tamanho_o = ((Pair)o).tamanho;
        return tamanho < tamanho_o ? -1 : tamanho == tamanho_o ? 0 : 1;
    }
};

