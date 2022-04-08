
package J1.S.P0057;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Management extends ArrayList<Collection>{
    static Scanner sc = new Scanner(System.in);
    static String User="[\\S]{5,}$", Pass="^(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    public Collection search(String username){
        for(int i =0; i<this.size(); i++){
            if(this.get(i).getUsername().equals(username)){
                return this.get(i);
            }    
        }
        return null;
    }
    
    public String input(String msg, String regex, String err){
        String data;
        do{
            System.out.println(msg);
            data = sc.nextLine().trim();
            if(data.matches(regex))
                break;
            System.out.println(err);
        }while(true);
        return data;
    }

    public void createAcc(){
        String u = input("Enter username:", User, "Username need at least 5 character and no space!");
        String p;
        if(search(u)==null){
            p = input("Enter password:", Pass, "Password need at least 8 character, no space and at least one special character!");
        }
        else{
            System.out.println("This user already exist!");
            return;
        }
        Collection c = new Collection(u, p);
        this.add(c);
    }
    
    public void login(){
        if(this.isEmpty())
            System.out.println("There is no account exist!");
        else{
            String u = input("Enter username:", User, "Username need at least 5 character and no space!");
            Collection c = search(u);
            if (c==null)
                System.out.println("This account doesn't exist!");
            else{
                int chance=3;
                while(chance!=0){
                    String p = input("Enter password:", Pass, "Password need at least 8 character, no space and at least one special character!");
                    if(p.matches(c.getPass())){
                        System.out.println("Login succesful!");
                        break;
                    }
                    else{
                        System.out.println("Wrong password");
                        chance--;
                    }
                }
            }
        }
    }
    public void readFromFile(String filename) throws FileNotFoundException{
        
        File list = new File(filename);
        if(list.exists()){
            Scanner f = new Scanner(list);
            while (f.hasNextLine()) {
                String data = f.nextLine();
                String[] arr=data.split("[|]");
                if(arr.length==2){
                    if(arr[0].matches(User)&&arr[1].matches(Pass))
                        this.add(new Collection(arr[0], arr[1]));
                }    
            }
            f.close();
        }
    }
     public void addToFile(String filename) throws IOException{
        if(this.isEmpty()){
            return;
        }
        new FileWriter(filename, false).close();
        FileWriter list =new FileWriter(filename, true);
            for(Collection c : this)
                list.write(c.getUsername()+"|"+c.getPass()+"\n");
            list.close();
       
    }
}     