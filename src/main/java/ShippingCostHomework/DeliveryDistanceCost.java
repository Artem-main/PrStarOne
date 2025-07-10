package ShippingCostHomework;

public class DeliveryDistanceCost {
    public int DeliveryDistanceCost (int dist) {
        int distPrice = 0;
        if (dist >= 30) {
            distPrice += 300;
        }else if (dist < 30 && dist > 10) {
            distPrice += 200;
        }else if (dist <= 10 && dist > 2) {
            distPrice += 100;
        }else {
            distPrice += 50;
        }
        return distPrice;
    }
}
