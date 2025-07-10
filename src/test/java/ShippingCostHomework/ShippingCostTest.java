package ShippingCostHomework;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest(name = "{index} - расстояние доставки {0} км")
    @ValueSource(ints = { 30, 35 })
    void price(int distance) {
        assertEquals(1680,
                new ShippingCost().Price("Y", distance,"Y",3),
                "Ожидалась стоимость 1680");
    }
}