package com.hqgml.dao;

import com.hqgml.domian.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TraverllerDao {
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
