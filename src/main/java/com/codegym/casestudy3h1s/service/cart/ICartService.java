package com.codegym.casestudy3h1s.service.cart;

import com.codegym.casestudy3h1s.model.entity.Cart;
import com.codegym.casestudy3h1s.model.entity.user.User;
import com.codegym.casestudy3h1s.service.IGeneralService;

public interface ICartService extends IGeneralService<Cart> {
    Iterable<Cart> findAllByUser(User user);

}
