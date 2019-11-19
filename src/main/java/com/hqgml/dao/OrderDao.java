package com.hqgml.dao;

import com.hqgml.domian.Member;
import com.hqgml.domian.Orders;
import com.hqgml.domian.Product;
import org.apache.ibatis.annotations.*;

import java.util.IdentityHashMap;
import java.util.List;

public interface OrderDao {
    //    查询所有的订单
    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productid", javaType = Product.class, one = @One(select = "com.hqgml.dao.IProductDao.findById"))

    })
    List<Orders> findAllOrder();

    /**
     * 根据id查询具体的产品
     * @param orderid
     * @return
     */
    @Select("select * from orders  where id = #{orderid}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product", column = "productid", javaType = Product.class, one = @One(select = "com.hqgml.dao.IProductDao.findById")),
            @Result(property = "member" ,column = "memberid" ,javaType = Member.class,one = @One(select = "com.hqgml.dao.MemberDao.findById")),
            @Result(property = "travellers",column = "id",javaType =java.util.List.class,many = @Many(select = "com.hqgml.dao.TraverllerDao.findByOrdersId"))
    })
    Orders findOrdersById(String orderid);
}
