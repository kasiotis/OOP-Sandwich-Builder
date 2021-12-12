public class SandwichReport{
	/*here is where a report is created so that the receipt can be
	 *be printed is a nice fashion with every information well  
	 * presented for the user. this report shows the user every ingredient
	 * they have chosen and their respective prices, then it identifies whether 
	 * the ingredients the user has chosen have resulted in either a vegetarian, 
	 * a spicy, or nut free sandwich. Not only that but it also prints the total
	 * price of the sandwich including taxes and without
	 */
	
	
    public static void report( Sandwich sandwich ){
        System.out.printf( "Your Sandwich is:%s\n", sandwich.getName() );
        System.out.println( "Breakdown:" );
        for( SandwichTopping t: sandwich.getToppings() ){
            System.out.printf( "\t%s:%s\n", t.getName(), t.getCost() );
        }
        for( SandwichFilling f: sandwich.getFillings() ){
            System.out.printf( "\t%s:%s\n", f.getName(), f.getCost() );
        }
        
        SandwichBread b = sandwich.getBread();
        System.out.printf( "\tBread: %s %s\n", b.getName(), b.getCost() );

        System.out.printf( "\tSandwich %s Vegetarian\n",
                           (sandwich.vegetarian()) ? "is" : "is not" );
        
        System.out.printf( "\tSandwich %s Spicy\n",
                (sandwich.spicy()) ? "is not" : "is" );

        System.out.printf( "\tSandwich %s nutFree\n",
                (sandwich.nutFree()) ? "is" : "is not" );
        
        System.out.println( "Total Before VAT:  £ " + sandwich.getCost() );
        System.out.println( "Total after VAT:  £ " + sandwich.getFullCost() );
    }
}