public class SandwichtBuild{

    public static void main (String [] args){
//creating a sandwich with italian bread
    	
    	Sandwich p = new Sandwich( new SandwichBread( "italian", 1.3, true, false, true) );
//adding toppings to it
    	
        p.addTopping( new SandwichTopping("ham", 0.5, false, false, true) );
        p.addTopping( new SandwichTopping("feta", 0.8, true, false, true) );
        p.addTopping( new SandwichTopping("chilli", 0.4, true, true, true) );
        p.addTopping( new SandwichTopping("mayonaise", 0.5, false, false, true) );
//printing it out in form of a report 
        
        SandwichReport.report( p );
    }
}