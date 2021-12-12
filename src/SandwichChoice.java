
import java.util.Map;
import java.util.HashMap;
import java.io.FileInputStream;
import java.util.Scanner;
/* this is the class responsible for the user interface. In here the system presents the user with options
 * of either breads, toppings or fillings and it receives their response. After all data is collected it
 * formulates a receipt of all the ingredients the user has chosen and their cost both individually and 
 * collectively, then it also print the total cost after tax
 */
public class SandwichChoice{

    private static Scanner s;

	public static void main(String[] args) throws Throwable{

    	SandwichCatalog pc = new SandwichCatalog();

        s = new Scanner( System.in );
//asks the user to choose one of the breads in the list and then stores its values
        System.out.println( "Please choose a bread:" );
        for( SandwichBread bread: pc.getBreads().values() ){
            System.out.println( bread.getName() );
        }

        SandwichBread chosenBread = pc.getBreads().get( s.next() );
        System.out.println( "You choose:" + chosenBread.getName() );

        Sandwich sandwich = new Sandwich( chosenBread );
//asks the user to choose a topping from the list and then it stores its values
        System.out.println( "Please choose a topping, or type STOP to finish:" );

        for( SandwichTopping p: pc.getToppings().values() ){
            System.out.println( p.getName() );
        }
//this is a loop so that the system keeps on taking in toppings until the user has given the command "STOP"
        boolean keeprunning = true;
        while( keeprunning ){
            String next = s.next();
            if( next.equals( "STOP" ) ){
            	keeprunning = false;
                continue;
            }
            SandwichTopping topping = pc.getToppings().get( next );
            sandwich.addTopping( topping );
            System.out.println( "You choose:" + topping.getName() );
        }
//asks the user to choose a filling from the list and then it stores its values
        System.out.println( "Please choose a filling, or type STOP to finish:" );

        for( SandwichFilling f: pc.getFillings().values() ){
            System.out.println( f.getName() );
        }
//again another loop so that the system keeps taking in fillings until it is given the command "STOP"        	
        boolean keeprunning1 = true;
        while( keeprunning1 ){
            String next = s.next();
            if( next.equals( "STOP" ) ){
            	keeprunning1 = false;
                continue;
            }
            SandwichFilling filling = pc.getFillings().get( next );
            sandwich.addFilling( filling );
            System.out.println( "You choose:" + filling.getName() );
        }
/* now this is the part where the receipt is created, where everything is formulated into
 a nicely put together format by calling the SandwichReport class on object sandwich  */
       
        new SandwichReport();
		SandwichReport.report( sandwich );
    }
}