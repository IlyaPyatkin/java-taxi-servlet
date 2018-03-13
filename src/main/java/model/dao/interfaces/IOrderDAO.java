package model.dao.interfaces;

import model.pojo.Order;

import java.util.List;

public interface IOrderDAO extends DAO<Order, Long> {
    List<Order> getOrders(String username);

    boolean create(String username, Order order);
}
