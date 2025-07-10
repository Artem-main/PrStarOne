package ShippingCostHomework;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShippingCostTest {

    @Test
    void dimensionsCost() {
        assertEquals(200, new DimensionsCost().DimensionsCost("Y"),
                "Для 'Y' ожидалась стоимость 200");
    }

    @Test
    void deliveryDistanceCost() {
        assertEquals(300, new DeliveryDistanceCost().DeliveryDistanceCost(31),
                "Для '31' ожидалась стоимость 300");
    }

    @Test
    void fragility() {
        assertEquals(300, new FragilityCost().Fragility("Y"),
                "Для 'Y' ожидалась стоимость 300");
    }

    @Test
    void workload() {
        assertEquals(1.4, new WorkloadRatio().Workload(3),
                "Для '3' ожидался коэфф. 1.4");
    }

    @Test
    void price() {
        assertEquals(1680,
                new ShippingCost().Price("Y", 30,"Y",3),
                "Ожидалась стоимость 1680");
    }
}