package ShippingCostHomework;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class ShippingCostTest {

    @ParameterizedTest(name = "{index} - габариты груза {0}")
    @ValueSource (strings = {"Y", "N"})
    @Tag("unit")
    void dimensionsCost(String value) {
        assertEquals(200, new DimensionsCost().DimensionsCost(value),
                "Для " + value + " ожидалась стоимость " + new DimensionsCost().DimensionsCost(value));
    }

    @Test
    @Tag("unit")
    void deliveryDistanceCost() {
        assertEquals(300, new DeliveryDistanceCost().DeliveryDistanceCost(31),
                "Для '31' ожидалась стоимость 300");
    }

    @Test
    @Tag("unit")
    void fragility() {
        assertEquals(300, new FragilityCost().Fragility("Y"),
                "Для 'Y' ожидалась стоимость 300");
    }

    @Test
    @Tag("unit")
    void workload() {
        assertEquals(1.4, new WorkloadRatio().Workload(3),
                "Для '3' ожидался коэфф. 1.4");
    }

    @ParameterizedTest(name = "{index} - расстояние доставки {0} км")
    @Tag("development")
    @CsvSource({
            "Y, 30, Y, 3, 1680",
            "N, 10, N, 1, 400",
            "Y, 5, N, 2, 600"})
    void price(String dim,int dist, String frag, int ratio, int expected) {
        assertEquals(expected,
                new ShippingCost().Price(dim, dist, frag, ratio),
                "Неверная стоимость доставки");
    }

    @ParameterizedTest
    @CsvSource({
            "Y, 30, Y, 3, 1680, 200, 300, 1.4",
            "N, 10, N, 1, 600, 100, 0, 1.0"
    })
    void fullTest(String dim, int dist, String frag, int ratio, int total, int dimCost, int fragCost, double workload) {
        assertAll(
                () -> assertEquals(dimCost, new DimensionsCost().DimensionsCost(dim), "Неверная стоимость габаритов"),
                () -> assertEquals(fragCost, new FragilityCost().Fragility(frag), "Неверная стоимость хрупкости"),
                () -> assertEquals(total, new ShippingCost().Price(dim, dist, frag, ratio), "Неверная итоговая стоимость")
        );
    }
}