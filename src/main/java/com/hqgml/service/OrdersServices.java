package com.hqgml.service;

import com.hqgml.domian.Orders;

import java.util.List;

/**
 * @data 11/15/2019 4:12 PM
 **/
public interface OrdersServices {

    public List<Orders>  findAllOrders(int pagenum,int size) throws Exception;

    Orders findOrderByid(String ordersid);
}
