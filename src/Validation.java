
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Validation {
    
    public static Scanner sc = new Scanner(System.in);
    
    public static int getInt(String msg, int min, int max){
        System.out.print(msg);
        while(true){
            try {
                int n = Integer.parseInt(sc.nextLine().trim());
                if(n >= min && n <= max){
                    return n;
                } else{
                    System.out.print("Please input in range " + min + " to " + max + ": ");    
                }
            } catch (NumberFormatException e) {
                System.out.print("Number must be a number!! Enter again: ");
            }
        }
    }
    
        public static double getDouble(String msg, double min, double max){

            while(true){
                System.out.print(msg);
                try {
                    double n = Double.parseDouble(sc.nextLine().trim());
                    if(n >= min && n <= max && n % 0.5 == 0){
                        return n;
                    } else{
                        System.out.println("Please input in range " + min + " - " + max + ":");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("number must be a number!! please input again!");
                }
            }
        }
    
    public static String getString(String msg, String regex, String err){
        System.out.print(msg);
        
        while(true){
            String n = sc.nextLine().trim();
            
            if(!n.isEmpty() && n.matches(regex)){
                return n;
            }
            
            System.out.println(err);
        }
    }
    
    public static String getDate(String msg){
        System.out.print(msg);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        while(true){
            try {
                String n= sc.nextLine().trim();
                Date date = dateFormat.parse(n);
                if(n.equalsIgnoreCase(dateFormat.format(date))){
                    return n;
                } else{
                    System.out.print("Date not valid. please enter again: ");
                }
            } catch (ParseException e) {
                System.out.print("Please input follow format dd-MM-yyyy. Enter again: ");
            }
        }
    }
}
