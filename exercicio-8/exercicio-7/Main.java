import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        System.out.print("Insira o nome do diretorio: ");
        Scanner scanner = new Scanner(System.in);
        String diretorio = scanner.nextLine();
        OrdenadorArquivos ordenador = new OrdenadorArquivos(diretorio);
        ordenador.ordenarArquivos();
        scanner.close();
    }
}
