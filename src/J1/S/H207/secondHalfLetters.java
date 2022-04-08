
package J1.S.H207;
import java.util.*;

public class secondHalfLetters {
    static Scanner sc = new Scanner(System.in);
    public static String inputPattern(String msg, String pattern){
        String data;
        do{
            System.out.println(msg);
            data = sc.nextLine();
        } while(!data.matches(pattern));
        return data;       
    }
    public static int countSecondHalf(String letter){
       
        int count=0;
        for(int i=0;i<letter.length();i++){
            if((letter.charAt(i)>='n'&&letter.charAt(i)<='z')||(letter.charAt(i)>='N'&&letter.charAt(i)<='Z')){
                count++;
            }   
        }
        return count;
    }
    public static void main(String[] args) {
           
            System.out.println(countSecondHalf(inputPattern("Enter all letter string:", "[a-zA-z ]+")));
    }
}
