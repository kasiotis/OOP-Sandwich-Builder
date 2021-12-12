public interface Priceable{

    public static final double VAT_RATE = 0.2;

    public default double getFullCost(){
        return getCost() + getVat();
    }

    public default double getVat(){
        return getCost() * VAT_RATE;
    }
    public double getCost();

    public String getName();
}