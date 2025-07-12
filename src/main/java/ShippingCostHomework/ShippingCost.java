package ShippingCostHomework;

public class ShippingCost {

    public double Price (String dim,int dist, String frag, int ratio) {
        int minDeliveryPrice = 400;
        double deliveryPrice = 0;
        if (dist > 30 && frag.equals("Y")) {
            throw new IllegalArgumentException("Нельзя везти хрупкий груз дальше 30 км");
        } else deliveryPrice = (new DimensionsCost().DimensionsCost(dim) +
                new DeliveryDistanceCost().DeliveryDistanceCost(dist) +
                new FragilityCost().Fragility(frag) +
                minDeliveryPrice) *
                new WorkloadRatio().Workload(ratio);
        return deliveryPrice;
    }
}
