
public class Ingredient extends Food {

	private double cost;
	boolean vegetarian;
	boolean spicy;
	boolean nutFree;

	//assigning values to these variables
	public Ingredient(String name, double cost, boolean vegetarian, boolean spicy, boolean nutFree) {
		super(name);
		this.spicy = spicy;
		this.vegetarian = vegetarian;
		this.nutFree = nutFree;
		this.cost = cost;
	}

	// returns the variables
	public double getCost() {
		return cost;
	}

	public boolean vegetarian() {
		return vegetarian;
	}

	public boolean spicy() {
		return spicy;
	}

	public boolean nutFree() {
		return nutFree;
	}
}
