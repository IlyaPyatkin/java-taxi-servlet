package services.impl;

import model.dao.impl.OrderDAO;
import model.dao.interfaces.IOrderDAO;
import model.pojo.Order;
import services.interfaces.IOrderService;

import java.util.List;

public class OrderService implements IOrderService {
    private static IOrderDAO orderDAO = new OrderDAO();

    @Override
    public List<Order> getOrders(String username) {
        return orderDAO.getOrders(username);
    }

    @Override
    public boolean create(String username, String origin, String destination) {
        return orderDAO.create(username, new Order(origin, destination));
    }
}