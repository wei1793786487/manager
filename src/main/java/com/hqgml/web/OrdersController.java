package com.hqgml.web;

import com.github.pagehelper.PageInfo;
import com.hqgml.domian.Orders;
import com.hqgml.service.OrdersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @data 11/15/2019 4:12 PM
 **/
@SuppressWarnings("all")
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersServices os;

    @RequestMapping("/finndAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", defaultValue = "1") Integer page, @RequestParam(name = "size", defaultValue = "5") Integer size) throws Exception {
        ModelAndView md = new ModelAndView();
        List<Orders> allOrders = os.findAllOrders(page, size);
        //pageinfo其实就是一个分页bean
        PageInfo pageInfo = new PageInfo(allOrders);
        md.addObject("pageinfo", pageInfo);
        md.setViewName("orders-pages-list");
        return md;
    }

     @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(value = "id") String ordersid) {
        ModelAndView md = new ModelAndView();
        Orders od = os.findOrderByid(ordersid);
        md.addObject("orders",od);
        md.setViewName("orders-show");
        return md;
    }

}
