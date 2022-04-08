package J1.S.H203_;

import java.util.Scanner;
public class Reverse {
    public static String checkEmp(String mess){
        String str;
        Scanner sc = new Scanner(System.in);
	do
	{
	   System.out.print(mess);
	   str = sc.nextLine().trim();
	} while(str.isEmpty());
	return str;
    }
    public static String printReverse(String s) {
       String reverse = "";
       String normal[]= s.split("\\s+");
       
       for(int i=normal.length-1;i>=0;i--){
           reverse += normal[i]+" ";
       }
       reverse=reverse.substring(0,1).toUpperCase()+reverse.substring(1);
       return reverse.trim();
    }
    
    public static void main(String[] args) {
        System.out.println(printReverse(checkEmp("Enter non blank string:")));
    }
}//hello there
//There hello
