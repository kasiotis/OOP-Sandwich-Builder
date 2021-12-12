import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
/*this class is basically responsible for the lists of toppings, fillings, breads and their facets values an cost
also this is where i have created the pre-made sandwiches that are used in the Menu class to offer easy choices */

public class SandwichCatalog{
// maps for toppings, fillings and breads, these maps are used in order to create keys for the facets of each ingredient type
    private Map<String,SandwichTopping> toppings;
    private Map<String, SandwichFilling> fillings;
    private Map<String,SandwichBread> bread;
    private Map<String,Sandwich> called;

    public Map<String,SandwichTopping> getToppings(){
        if( toppings == null ){
        	
            /* list of multiple toppings for the customers to choose from,
        	each has a price and three boolean values for their facets */
            List<SandwichTopping> toppingsList = new ArrayList<SandwichTopping>();
            toppingsList.add( new SandwichTopping( "pickles",    0.6, true, false, true ));
            toppingsList.add( new SandwichTopping( "mozzarella", 0.6, true, false, true ));
            toppingsList.add( new SandwichTopping( "sweetcorn",     0.5, true, false, true ));
            toppingsList.add( new SandwichTopping( "onion",     0.6, true, true, true ));
            toppingsList.add( new SandwichTopping( "pepperoni",    0.8, false, true, true ));
            toppingsList.add( new SandwichTopping( "lettuce",  0.3, true, false, true ));
            toppingsList.add( new SandwichTopping( "chilli",      0.4, true, true, true ));
            toppingsList.add( new SandwichTopping( "bacon",      0.9, false, false, true ));
            toppingsList.add( new SandwichTopping( "ham",        0.8, false, false, true ));
            toppingsList.add( new SandwichTopping( "turkey",      1.1, false, false, true));
            toppingsList.add( new SandwichTopping( "tomato",      0.4, true, false, true));
            toppingsList.add( new SandwichTopping( "mayonaise",      0.2, false, false, true));
            toppingsList.add( new SandwichTopping( "BBQ",      0.3, true, false, false));
            toppings = nameToObjectMap( toppingsList );
        }
        return toppings;
    }
    public Map<String, SandwichFilling> getFillings(){
        if( fillings == null ){
        	
        	/* here is a list of multiple fillings for the customer to choose from,
        	each has a price and three boolean values for their facets */
            List<SandwichFilling> fillingList = new ArrayList<SandwichFilling>();
            fillingList.add( new SandwichFilling( "steak", 3.2, false , false, true ) );
            fillingList.add( new SandwichFilling( "chicken", 2.3, false, false, true ) );
            fillingList.add( new SandwichFilling( "meatballs", 3.0, false, false, true ) );
            fillingList.add( new SandwichFilling( "tuna", 2.6, true, false, true ) );
            fillings = nameToObjectMap( fillingList );
        }
        return fillings;
    }
    
    public Map<String,SandwichBread> getBreads(){
        if( bread == null ){
        	
        	/* here is a list of multiple fillings for the customer to choose from,
        	 *  each has a price and three boolean values for their facets*/
            List<SandwichBread> breadList = new ArrayList<SandwichBread>();
            breadList.add( new SandwichBread( "italian", 2.7, true, false, true ) );
            breadList.add( new SandwichBread( "wholemeal", 2.7, true, false, true ) );
            breadList.add( new SandwichBread( "rye", 2.9, true, false, true ) );
            breadList.add( new SandwichBread( "mountain_white", 2.9, true, false, true ) );
            bread = nameToObjectMap( breadList );
        }
        return bread;
    }

    public Map<String,Sandwich> getCalledSandwich(){
       if( called == null ){
            Map<String,SandwichBread> brd = getBreads();
            Map<String,SandwichTopping> ts = getToppings();
            Map<String,SandwichFilling> fs = getFillings();
            List<Sandwich> sandwichList = new ArrayList<Sandwich>();
            
            /*Here is where i created and put together the pre-made sandwiches that are being used in the menu class.
             * Each of the is a different combination of ingredients and non-modifiable  */
            
            sandwichList.add
    			(new Sandwich ( "fish_meat", brd.get("rye"), new SandwichTopping[]{ ts.get("onion"), ts.get("mozzarella"), ts.get("sweetcorn"), ts.get("lettuce") }, new SandwichFilling[]{fs.get("tuna")} ));
            
            sandwichList.add
        		(new Sandwich ( "el_marinara", brd.get("italian"), new SandwichTopping[]{ ts.get("tomato"), ts.get("mozzarella"), ts.get("pepperoni"), ts.get("lettuce") }, new SandwichFilling[]{fs.get("chicken")} ));
            
            sandwichList.add
            	(new Sandwich ( "italiano", brd.get("italian"), new SandwichTopping[]{ ts.get("tomato"), ts.get("mozzarella") }, new SandwichFilling[]{fs.get("steak")} ));
            
            sandwichList.add
                (new Sandwich ( "chicken_and_bacon", brd.get("wholemeal"), new SandwichTopping[]{ ts.get("bacon"), ts.get("mozzarella"), ts.get("sweetcorn")}, new SandwichFilling[]{fs.get("chicken")}  ));
           
            sandwichList.add
            	(new Sandwich ( "spicy_meatball", brd.get("italian"), new SandwichTopping[]{ ts.get("chilli"), ts.get("sweetcorn"), ts.get("mozzarella"), ts.get("onion") }, new SandwichFilling[]{fs.get("meatballs")} ));
            
            called = nameToObjectMap( sandwichList );
        }
        return called;
    }

    
    private static <P extends Priceable> Map<String, P>
                              nameToObjectMap(List<P> list) {
        Map<String, P> map = new HashMap<String, P>();
        for(P p : list) {
            map.put(p.getName(), p);
        }
        return Collections.unmodifiableMap(map);
    }

    public static void main(String[] args){
    	
    	SandwichCatalog p = new SandwichCatalog();

        System.out.println( p.getToppings() );
        System.out.println( p.getBreads() );
    }
}