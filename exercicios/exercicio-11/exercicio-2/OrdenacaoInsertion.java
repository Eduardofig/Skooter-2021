public class OrdenacaoInsertion <TIPO extends Comparable> {
    public void sort(TIPO[] array){
        int i, j;
        for(j=1; j<array.length; j++){
            TIPO temp = array[j];
            i = j - 1;
            while(i > -1 && (array[i].compareTo(temp) > 0)){
               array[i+1] = array[i];
               i--;
            }
            array[i + 1] = temp;
        }
    }
}
