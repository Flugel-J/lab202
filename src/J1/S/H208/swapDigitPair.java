package J1.S.H208;
import java.util.Scanner;
public class swapDigitPair {
    public static Scanner sc = new Scanner(System.in);
    public static int InputPInt(String msg){
        int n=0;
        while(n<1){
            System.out.println(msg);
            try{
                n=Integer.parseInt(sc.nextLine());
            }
            catch(Exception e){
                System.out.println("Error!");
            }
        }
        return n;
    }
    
    public static int SwapPair(int n){
        int result = 0;
        int pos=1;
        while(n!=0){
            int n1=n%10;
            n/=10;
            if(n==0){
                result+=n1*pos;
                break;
            }
            else{
                result+= (n%10)*pos +n1*pos*10;
                n/=10;
            }
            pos*=100;
        }
        return result;
    }    
   //31248
    public static void main(String[] args) {
    
        System.out.println(SwapPair(InputPInt("Enter positive integer:")));
   
     
    }
}