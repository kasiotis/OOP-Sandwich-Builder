import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*This class holds the most crucial information about this project, it is responsible for 
 * receiving information about the ingredients and the bread and also responsible 
 for putting it together in a correct structure so that it can be called by other classes */

public class Sandwich extends Food{

    private List<SandwichTopping> toppings = new ArrayList<SandwichTopping>();
    private List<SandwichFilling> fillings = new ArrayList<SandwichFilling>();
    private SandwichBread bread;

    public Sandwich( SandwichBread bread ){
        this(null, bread);
    }

    public Sandwich( String name, SandwichBread bread){
        super(name);
        this.bread = bread;
    }

    public Sandwich( String name, SandwichBread bread, SandwichTopping[] topping, SandwichFilling[] filling){
        this( name, bread );
        toppings.addAll( Arrays.asList( topping ) );
        fillings.addAll( Arrays.asList( filling ) );
    }

    public void addTopping(SandwichTopping topping) {
        toppings.add(topping);
    }
	public void addFilling(SandwichFilling filling) {
		fillings.add(filling);
	}
    
    public List<SandwichTopping> getToppings(){
        return Collections.unmodifiableList( toppings );
    }
    public List<SandwichFilling> getFillings(){
        return Collections.unmodifiableList( fillings );
    }
    
    public SandwichBread getBread(){
        return bread;
    }
//here is where the cost of each ingredient is summed up (toppings, fillings, bread)
    public double getCost() {
        double cost = 0;
        for (SandwichTopping t : toppings) {
            cost += t.getCost();
        }
        for (SandwichFilling f : fillings){
        	cost += f.getCost();
        }
        return cost + bread.getCost();
    }
    
    //this is the check for each individual ingredient to see if it is vegetarian
    public boolean vegetarian(){
        for( SandwichTopping t: toppings){
            if( !t.vegetarian() ){
                return false;
            }
        }
        for( SandwichFilling f: fillings){
        	if( !f.vegetarian() ){
        		return false;
        	}
        }
    	return bread.vegetarian();
    }

  //this is the check for each individual ingredient to see if it is spicy
    public boolean spicy(){
        for( SandwichTopping t: toppings){
            if( !t.spicy() ){
                return false;
            }
        }
        for( SandwichFilling f: fillings){
        	if( !f.spicy() ){
        		return false;
        	}
        }
        return bread.spicy();        
    }
  //this is the check for each individual ingredient to see if it is nut free
    public boolean nutFree(){
        for( SandwichTopping t: toppings){
            if( !t.nutFree() ){
                return false;
            }
        }
        for( SandwichFilling f: fillings){
        	if( !f.nutFree() ){
        		return false;
        	}
        }
        return bread.nutFree();        
    }
}