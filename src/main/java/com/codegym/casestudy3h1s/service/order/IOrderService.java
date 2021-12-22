package com.codegym.casestudy3h1s.service.order;

import com.codegym.casestudy3h1s.model.Orders;
import com.codegym.casestudy3h1s.service.IGeneralService;

public interface IOrderService extends IGeneralService<Orders> {
    void removeAll(Iterable<Orders> orders);

    Iterable<Orders> findAllByUserId(Long id);
}
