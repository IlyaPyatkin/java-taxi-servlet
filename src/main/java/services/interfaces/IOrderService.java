package services.interfaces;

import model.pojo.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getOrders(String username);

    boolean create(String username, String origin, String destination);
}
