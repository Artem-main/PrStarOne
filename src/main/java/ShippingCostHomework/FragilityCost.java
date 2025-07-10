package ShippingCostHomework;

public class FragilityCost {
    public int Fragility (String fragility) {
        int fragilityCost;
        switch (fragility) {
            case "Y" -> fragilityCost = 300;
            case "N" -> fragilityCost = 0;
            default -> throw new IllegalStateException("Unexpected value: " + fragility);
        }
        return fragilityCost;
    }
}
