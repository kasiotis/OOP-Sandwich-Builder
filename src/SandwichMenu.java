
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.io.FileInputStream;
/*this is the class that makes the choosing of a pre-made sandwich possible.
 * it lets the user decide between five pre-made sandwiches and then it
 * presents them with a receipt from the SandwichReport class  */

public class SandwichMenu{


    private Scanner s;

	public void run() throws Exception{
        Map<String,Sandwich> menu = new SandwichCatalog().getCalledSandwich();

        System.out.println( "Which Sandwich would you like?" );
//prints out the 5 sanwiches
        Set<String> sandwiches = menu.keySet();
        for( String sandwich: sandwiches ){
            System.out.println( sandwich );
        }
//takes in users answer
        s = new Scanner( System.in );
        String chosenString = s.next();
        Sandwich picked = menu.get( chosenString );
//creates report
        new SandwichReport();
		SandwichReport.report( picked );

   }

    public static void main(String[] args) throws Exception{
//runs the class, essentially printing the customers receipt
    	SandwichMenu m = new SandwichMenu();
        m.run();
    }
}