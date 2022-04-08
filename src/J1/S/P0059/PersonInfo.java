
package J1.S.P0059;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.*;

public class PersonInfo {
    static ArrayList<Info>i= new ArrayList<Info>();
    static Scanner sc = new Scanner(System.in);
    static String dup;
    public static void getPerson(){
        if(i.isEmpty())
            System.out.println("The list is empty!");
        else{
            Collections.sort(i, new Comparator<Info>() {
           
            public int compare(Info s1, Info s2) {
                return s1.getSalary() > s2.getSalary() ? 1 : -1;
            }
         });
           System.out.printf("%10s%10s%10s\n","Name","Address","Salary");
            for(Info Person : i)
                System.out.printf("%10s%10s%10.1f\n",Person.getName(),Person.getAddress(),Person.getSalary());
            System.out.println("Min:"+i.get(0).getName());
            System.out.println("Max:"+i.get(i.size()-1).getName());
        }
    }
    static boolean NotDup(String data){
        String[] duplicate=dup.split(" ");
        dup += data+" ";
        for(int i=0;i<duplicate.length;i++){
            if(duplicate[i].matches(data))
                return false;
        }
        return true;
    }
    public static boolean Continue(String msg){
        String a; boolean con;
        while(true){
            System.out.println(msg);
            a= sc.nextLine();
            if(a.equalsIgnoreCase("Y")){
                con=true;
                break;
            }
            if(a.equalsIgnoreCase("N")){
                con=false;
                break;
            }    
            else{
                System.out.println("Error!");                      
            }
        }
    return con;    
    }
    static String open(String msg){
        String data = "";
        while(data.isEmpty()){
            System.out.println(msg);
            data=sc.nextLine().trim();
        }
        return data;    
    }

    public static void readFromFile(String filename, double min) throws FileNotFoundException{
        double salary;
        File file= new File(filename);
        if(file.exists()){
            Scanner f = new Scanner(file);
            while (f.hasNextLine()) {
                String data = f.nextLine();
                String[] arr=data.split("[;]");
                if(arr.length>=3)
                    salary=Double.parseDouble(arr[2]);
                else
                    salary = 0;
                if(salary>=min)
                    i.add(new Info(arr[0], arr[1], salary)); 
            }
            f.close();
        }
        else
            throw new FileNotFoundException();
    }
  
    
    public static void copyWordOneTimes(File source, String destination) throws Exception{           
            FileWriter p =new FileWriter(destination, true);
            Scanner c = new Scanner(source);
            while(c.hasNext()){
                String data=c.next();
                if(NotDup(data))
                    p.write(data+" ");
             }
            c.close();
            p.close();

    }
     public static void main(String[] args) {
        System.out.println("==============File processing==============");
        System.out.println("1.Find person info");
        System.out.println("2.Copy text to file"); 
        System.out.println("3.Exit");
        String choice = "";
        while(choice!="3"){
            choice=open("Enter choice");
            switch(choice){
                case "1":
                    Scanner d = new Scanner(System.in);
                    System.out.println("Enter Money:");
                    double min;
                    while(true){ 
                        
                        try{
                           min =d.nextDouble();
                            if(min<0)
                                throw new Exception();
                            break;
                        }
                        catch(Exception e){
                            System.out.println("Invalid money, pls reenter");
                            d.next();
                        }
                    }
                
                while(true){
                    try {
                        readFromFile(open("Enter File:"),min);
                        break;
                    }
                    catch (FileNotFoundException ex) {
                        System.out.println("Cant find file");
                    }
                }          
                    getPerson();
                    
                    break;
                case "2":
                    dup="";
                        File source=new File(open("Enter source file:"));
                        String destination;
                        if(!source.exists()){
                            System.out.println("Cant find file");
                            break;
                        }    
                        else{
                            destination= open("Enter new File:");
                            File des= new File(destination);
                            if(des.exists()){
                                System.out.println("File already exist!");
                                break;
                            }
                            
                        }
                try {
                    copyWordOneTimes(source, destination);
                } catch (Exception ex) {
                    System.out.println("Cant copy or create file");
                }
                    break;
                case "3":
                    break;
                default:
                    System.out.println("Invalid choice"); 
            }
        }
     }        
        
}