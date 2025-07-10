package ShippingCostHomework;

public class ShippingCost {

    public double Price (String dim,int dist, String frag, int ratio) {
        int minDeliveryPrice = 400;
        double deliveryPrice;
        if (dist > 30 && frag.equals("Y")) {
            System.out.println("Максимальное расстояние для хрупкого груза " );
        }
        deliveryPrice = (new DimensionsCost().DimensionsCost(dim) +
                new DeliveryDistanceCost().DeliveryDistanceCost(dist) +
                new FragilityCost().Fragility(frag) +
                minDeliveryPrice) *
                new WorkloadRatio().Workload(ratio);
        return deliveryPrice;
    }
}
