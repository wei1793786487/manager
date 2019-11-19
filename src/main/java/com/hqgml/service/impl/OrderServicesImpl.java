package com.hqgml.service.impl;

import com.github.pagehelper.PageHelper;
import com.hqgml.dao.OrderDao;
import com.hqgml.domian.Orders;
import com.hqgml.service.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @data 11/15/2019 4:14 PM
 **/
@Service
@Transactional
public class OrderServicesImpl implements OrdersServices {
    @Autowired
    private OrderDao orderDao ;
    @Override
    public List<Orders> findAllOrders(int pagenum,int size) throws Exception {
        //必须写在调用分页代码的前面
        PageHelper.startPage(pagenum,size);
        return orderDao.findAllOrder();
    }

    @Override
    public Orders findOrderByid(String ordersid) {
        return orderDao.findOrdersById(ordersid);
    }
}
