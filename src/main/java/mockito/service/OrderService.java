package mockito.service;

import mockito.ProductNotFoundException;
import mockito.model.Delivery;
import mockito.model.Order;
import mockito.model.Warehouse;
import mockito.repository.OrderRepository;
import mockito.repository.ProductRepository;

public class OrderService {

    private CustomerService customerService;
    private WarehouseService warehouseService;
    private OrderRepository orderRepository;
    private ProductRepository productRepository;

    public OrderService(CustomerService customerService, WarehouseService warehouseService, OrderRepository orderRepository, ProductRepository productRepository) {
        this.customerService = customerService;
        this.warehouseService = warehouseService;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order create(String customerName) {
        return orderRepository.create(customerService.getOrCreate(customerName));
    }

    public Order addProduct(Order order, String productName, int count, boolean fastestDelivery) throws ProductNotFoundException {

        Warehouse wh;
        if (fastestDelivery) {
            wh = warehouseService.findClosestWarehouse(productName, count);
        } else {
            wh = warehouseService.findWarehouse(productName, count);
        }

        if (wh == null) {
            throw new ProductNotFoundException(productName);
        }


        Delivery delivery = new Delivery(
                productRepository.getByName(productName),
                wh,
                warehouseService.getStock(wh, productName).getPrice(),
                count);
        return orderRepository.addDelivery(order.getId(), delivery);
    }
}
