package com.codegym.casestudy3h1s.service.order;

import com.codegym.casestudy3h1s.model.Orders;
import com.codegym.casestudy3h1s.repository.IOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrdersRepository ordersRepository;

    @Override
    public Iterable<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Page<Orders> findAll(Pageable pageable) {
        return ordersRepository.findAll(pageable);
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return ordersRepository.findById(id);
    }

    @Override
    public Orders save(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public void remove(Long id) {
        ordersRepository.deleteById(id);
    }

    @Override
    public void removeAll(Iterable<Orders> orders) {
        ordersRepository.deleteAll(orders);
    }

    @Override
    public Iterable<Orders> findAllByUserId(Long id) {
        return ordersRepository.findAllByUserId(id);
    }
}
