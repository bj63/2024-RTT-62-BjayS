package com.pupz.pupz.controller;
import com.pupz.pupz.database.dao.DogDAO;
import com.pupz.pupz.database.dao.OrderDAO;
import com.pupz.pupz.database.dao.OrderDetailsDAO;
import com.pupz.pupz.database.entity.Dog;
import com.pupz.pupz.database.entity.Order;
import com.pupz.pupz.database.entity.OrderDetail;
import com.pupz.pupz.database.entity.User;
import com.pupz.pupz.security.AuthenticatedUserUtilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderDetailsDAO orderDetailsDao;

    @Autowired
    private DogDAO dogDAO;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;

    @GetMapping("/order/detail")
    public ModelAndView orderDetail() {
        ModelAndView response = new ModelAndView("order/detail");

        // get the logged in user
        User user = authenticatedUserUtilities.getCurrentUser();

        // now we need to get the order from the database where the status is 'CART'
        Order order = orderDAO.findOrderInCartStatus(user.getId());

        if (order != null) {
            // get the order details for the order
            List<Map<String, Object>> orderDetails = orderDAO.getOrderDetails(order.getId());
            response.addObject("orderDetails", orderDetails);

            // lets get the total order amount
            Double orderTotal = orderDAO.getOrderTotal(order.getId());
            response.addObject("orderTotal", orderTotal);
        }

        return response;
    }

    @GetMapping("/order/addToCart")
    public ModelAndView addToCart(@RequestParam Integer dogId) {
        ModelAndView response = new ModelAndView();

        // first we can look up the dog in the database given the incoming dogId
        Dog dog = dogDAO.findById(dogId);

        // get the logged in user
        User user = authenticatedUserUtilities.getCurrentUser();

        // now we need to get the order from the database where the status is 'CART' and the user is the logged in user
        Order order = orderDAO.findOrderInCartStatus(user.getId());
        if (order == null) {
            // the user does not have an order in cart status so we need to create one
            order = new Order();
            order.setUser(user);
            order.setOrderDate(new Date());
            order.setStatus("CART");

            // don't need this in your case study
            order.setOwnerId(103);
            order.setRequiredDate(new Date());

            orderDAO.save(order);
        }

        // now we have to look to see if the dog is already in the order details table
        OrderDetail orderDetail = orderDetailsDao.isDogInCart(order.getId(), dogId);
        if (orderDetail == null) {
            // this dog is not part of this order so we can create a new order detail
            orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setDog(dog);
            orderDetail.setQuantityOrdered(1);

            orderDetailsDao.save(orderDetail);
        } else {
            // the dog is already in the cart so we need to increment the quantity
            orderDetail.setQuantityOrdered(orderDetail.getQuantityOrdered() + 1);
            orderDetailsDao.save(orderDetail);
        }

        response.setViewName("redirect:/order/detail");
        return response;
    }


    @GetMapping("/order/checkout")
    public ModelAndView checkout() {
        ModelAndView response = new ModelAndView();

        // get the logged in user
        User user = authenticatedUserUtilities.getCurrentUser();

        // now we need to get the order from the database where the status is 'CART'
        Order order = orderDAO.findOrderInCartStatus(user.getId());
        if (order == null) {
            log.error("There is no order with items in the cart to checkout");
        } else {
            // there was an order with items in the cart so we change the status to COMPLETE
            order.setStatus("COMPLETE");
            orderDAO.save(order);
        }

        response.setViewName("redirect:/order/detail");
        return response;
    }

}
