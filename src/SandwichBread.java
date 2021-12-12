public class SandwichBread extends Ingredient{

    public SandwichBread( String name, double cost, boolean vegetarian, boolean spicy, boolean nutFree ){
        super(name, cost, vegetarian, spicy, nutFree);
    }

    public String toString(){
        return
            String.format( "SandwichBread[%s]", getName() );
    }


	}
