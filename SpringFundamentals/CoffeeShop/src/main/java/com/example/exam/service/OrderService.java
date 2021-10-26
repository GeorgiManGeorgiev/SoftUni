package com.example.exam.service;


import com.example.exam.model.service.OrderServiceModel;
import com.example.exam.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrdersOrderedByPriceDesc();

    void readyOrder(Long id);
}
