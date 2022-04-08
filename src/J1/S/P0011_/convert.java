
package J1.S.P0011_;

import java.util.Scanner;
public class convert {
    static Scanner sc = new Scanner(System.in);
    static String regex[] = {"[1-4]","[0-1]+","[0-7]+","[0-9]+","[0-9a-fA-f]+"};
    static String getIO(String msg, String regex, String err){
        String data ="";    
    while(!data.matches(regex)){
        System.out.println(msg);
        data = sc.nextLine();
        if(!data.matches(regex)){
            System.out.println("Wrong input!");
            System.out.println(err);
	}
    }
        return data; 
}
    static int getBase(int b){
        switch(b){
            case 1:
                return 2;
            case 2:
                return 8;
            case 3:
                return 10;
            default:
                return 16;
        }
    }
    static int convertDec(int inputBase, String input){
        if(inputBase==10)
            return Integer.parseInt(input);
        int output = 0, index = 0;
        int value = 0;
        input = input.toUpperCase();
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (c >= '0' && c <= '9')
                value = Integer.parseInt(String.valueOf(c));
            else 
                value = 10+(c - 'A');
            output += value * Math.pow(inputBase, index);
        //1101
            index++;
        }
        return output;
    }
    static String convertAny(int outputBase, int output){
        if(outputBase==10)
            return Integer.toString(outputBase);
        String result="";
        while(output!=0){
            int value= output%outputBase;
            output/=outputBase;
            if(value<=9)
                result= Integer.toString(value)+result;
            else
                result= Character.toString((char)(value+55))+result;
        }
        return result;
    }
    public static void main(String[] args) {
        int a= Integer.parseInt(getIO("Input base(1 is binary, 2 is octal, 3 is decimal, 4 is hexadecimal):", regex[0],"Input from 1 to 4"));
        int b = Integer.parseInt(getIO("Output base(1 is binary, 2 is octal, 3 is decimal, 4 is hexadecimal):", regex[0],"input from 1 to 4"));
        int inputBase = getBase(a);
        String err="Input not in base "+getBase(a);
        String input = getIO("Enter input:",regex[a], err);
        int outputBase =getBase(b);
        if(inputBase==outputBase)
            System.out.println(input);
        else{
            int output=convertDec(inputBase, input);
               System.out.println(convertAny(outputBase,output));
           
            /*int output= Integer.parseInt(input, inputBase);
            System.out.println(Integer.toString(output, outputBase));*/
            
       }
    }
}
