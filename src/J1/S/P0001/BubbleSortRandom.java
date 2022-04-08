
package J1.S.P0001;
import java.util.*;

public class BubbleSortRandom {
    static Scanner sc= new Scanner(System.in);
    public static int inputSize(String mess){
        int n=0;
        do{
            try{
                System.out.println(mess);
                n=Integer.parseInt(sc.nextLine().trim()); 
            }
            catch(Exception e){
                System.out.println("Error!");  
            }
        }while(n<1);
        return n;
    }
    public static int[] randomArray(int n){
        
        int[] ranArray=new int[n];
        for(int i=0;i<n;i++){
            ranArray[i]= new Random().nextInt(ranArray.length);
        }
        return ranArray;
    }
    public static void bubbleSort(int[]a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }    
    }
    public static void main(String[] args) {
        int[]randomArray=randomArray(inputSize("Enter Size of Array(>0):"));
        System.out.print("Unsorted array: [");
        for (int i = 0; i < randomArray.length; i++) {
            System.out.print(randomArray[i] + " ");
        }
        System.out.print("]");
        System.out.println();
        bubbleSort(randomArray);
        System.out.print("Sorted array: [");
        for (int i = 0; i < randomArray.length; i++) {
            System.out.print(randomArray[i] + " ");
        }
        System.out.print("]");  
    }
}
