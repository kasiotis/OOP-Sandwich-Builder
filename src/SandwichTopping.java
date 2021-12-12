
public class SandwichTopping extends Ingredient{

    public SandwichTopping( String name, double cost, boolean vegetarian, boolean spicy, boolean nutFree ){
        super(name, cost, vegetarian, spicy, nutFree);
    }

    public String toString(){
        return String.format( "SandwichTopping[%s]",getName() );
    }


	}
