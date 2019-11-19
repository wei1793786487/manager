package com.hqgml.domian;


import cn.hutool.core.date.DateUtil;
import com.hqgml.utils.DateUtlis;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
//订单
public class Orders {
    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;
    private int orderStatus;
    private String orderStatusStr;
    private int peopleCount;
    private Product product;
    private List<Traveller> travellers;
    private Member member;
    private Integer payType;
    private String payTypeStr;
    private String orderDesc;

    public String getOrderTimeStr() {
        if (orderTimeStr == null) {
            orderTimeStr = DateUtlis.dateToString(orderTime,"yyyy-MM-dd HH:mm");
        }
        return orderTimeStr;
    }

    public String getOrderStatusStr() {
//        0为未支付 1表示已经支付
        if (orderStatusStr==null){
            if (orderStatus==0){
                orderStatusStr="未支付";
            }else if (orderStatus==1){
                orderStatusStr="已支付";
            }
        }
        return orderStatusStr;
    }

    public String getPayTypeStr() {
        if (payTypeStr==null){
            //
            if (payType==0){
                payTypeStr="支付宝";
            }
            if (payType==1){
                payTypeStr="微信";
            }
            if (payType==2){
                payTypeStr="其他";
            }
        }
        return payTypeStr;
    }
}
