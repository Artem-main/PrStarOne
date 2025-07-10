package ShippingCostHomework;

public class DimensionsCost {
    public int DimensionsCost (String dim) {
        int dimCost;
        switch (dim) {
            case "Y" -> dimCost = 200;
            case "N" -> dimCost = 100;
            default -> throw new IllegalStateException("Unexpected value: " + dim);
        }
        return dimCost;
    }
}
