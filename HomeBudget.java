import java.util.*;
import static javafx.application.Platform.exit;
import java.io.*;

public class HomeBudget {
    class NotCorrectException extends Exception{
public NotCorrectException(){
System.out.println("Enter correct option");
Details();
}
}


    void Details(){
        System.out.println("--------Menu---------");
        System.out.println("1.Enter Expences");
        System.out.println("2.Enter Incomesource/PreviousSaving");
        System.out.println("3.Display Budget");
        System.out.println("4.Exit");
        System.out.println("Choose the option: ");
        Scanner sc=new Scanner(System.in);
        int option;
        option=sc.nextInt();
        
        switch(option){
        case 1:
             System.out.println("Enter Expences");
             storeDetails();
             break;
        case 2:
             System.out.println("Enter Incomesource/PreviousSaving");
             updateDetail();
             break;
        case 3:
              System.out.println("Display Budget");
              displayDetails();
              break;
        case 4:
              System.out.println("Exit");
              exit();
              break;
        default:
            try {
                throw new NotCorrectException();
            } catch (Exception e) {
            }
     }
    }
    
    public static void main(String[] args) {
        HomeBudget obj=new HomeBudget();
        obj.Details();
    }

      int NumberExpence,Amount,totalamount=0,NumberSource,Income=0;
      String ExpenceName,SourceName;
    public void storeDetails() {
                
                Scanner sc=new Scanner(System.in);
                NumberExpence=sc.nextInt();
                for(int i=0;i<NumberExpence;i++){
                    System.out.println("Enter the object Name: ");
                 ExpenceName=sc.nextLine();
                 sc.nextLine();
                 Amount=sc.nextInt();
                 totalamount+=Amount;
                             
                }
                
        try {
            FileWriter  myWriter = new FileWriter("F:\\PROGRAMMING\\JAVA\\Java_Practice\\sa.txt");
                        myWriter.write("Expences"+"\n"+ totalamount +"\n");
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                      } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                      }
                Details();
    }

    public void updateDetail() {

                Scanner s=new Scanner(System.in);
                NumberSource=s.nextInt();
                    System.out.println("1.Income");
                    System.out.println("2.Previous Saving");
                    
                    int a;
                    a=s.nextInt();
                     switch(a){
                    case 1:
                       for(int i=0;i<NumberSource;i++){
                    SourceName=s.nextLine();
                    s.nextLine();
                    Amount=s.nextInt();
                    Income+=Amount;
                    }
                        try {
                         

                        FileWriter myWriter = new FileWriter("F:\\PROGRAMMING\\JAVA\\Java_Practice\\sa.txt",true);
                        myWriter.write("Income"+"\n"+Income);
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                      } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                      }
                     break;
                       
                       
                case 2:
                    int previousaving;
                    previousaving=s.nextInt();
                    Income+=previousaving;
                    try{
                    FileWriter myWriter = new FileWriter("F:\\PROGRAMMING\\JAVA\\Java_Practice\\sa.txt",true);
                        myWriter.write("\n"+"Income"+"\n"+Income);
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                      } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                      }
                    break;
                
             default:
                     updateDetail();
                     break;
    }
                     Details();
    }

    

    public void displayDetails() {
          try {
      File myObj = new File("F:\\PROGRAMMING\\JAVA\\Java_Practice\\sa.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        System.out.println(data);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
          int Remaning = Income-totalamount;
          if(Remaning<0){
          System.out.println("You are under budget");
          }
          else{
              try{
                    FileWriter myWriter = new FileWriter("F:\\PROGRAMMING\\JAVA\\Java_Practice\\sa.txt",true);
                        myWriter.write("\n"+"Remaining"+"\n"+Remaning);
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                      } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                      }
          System.out.println("Remaining Amount: "+Remaning);
          }
          Details();
    }
    
}
