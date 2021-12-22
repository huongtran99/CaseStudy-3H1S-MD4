package com.codegym.casestudy3h1s.service.orderdetail;

import com.codegym.casestudy3h1s.model.OrderDetail;
import com.codegym.casestudy3h1s.service.IGeneralService;

public interface IOrderDetailService extends IGeneralService<OrderDetail> {
    Iterable<OrderDetail> findAllByUserId(Long id);

    void removeAll(Iterable<OrderDetail> orderDetails);
}
