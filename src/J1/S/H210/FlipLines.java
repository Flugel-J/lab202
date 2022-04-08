
package J1.S.H210;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 


public class FlipLines {
    static void print(String s){
        String[] flip = s.split("/n");
        for(int i=0; i<flip.length; i+=2){
            if(i!=flip.length-1)
                System.out.println(flip[i+1]);
                
            System.out.println(flip[i]);
        }
    }
    public static void main(String[] args) {
        String data = "";
        try {
            File myFile = new File("FlipLines.txt");
            if(myFile.exists()){
                Scanner Flip = new Scanner(myFile);
                while (Flip.hasNextLine()) {
                    data += Flip.nextLine().trim()+"/n";
                }
                Flip.close();
                print(data);
            }
            else
                throw new FileNotFoundException();
        }
        catch (FileNotFoundException e ) {
            System.out.println("Cant find file");
        }
    }    
}
