
public class SandwichFilling extends Ingredient {

	public SandwichFilling(String name, double cost, boolean vegetarian, boolean spicy, boolean nutFree){
        super(name,cost,vegetarian, spicy, nutFree);
    }
	 
	public String toString(){
	        return String.format( "SandwichFilling[%s]",getName() );
}
}