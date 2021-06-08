import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String diretorio = sc.nextLine();
        OrdenadorArquivos or = new OrdenadorArquivos(diretorio);
        or.OrdenarArquivos();
    }
}
