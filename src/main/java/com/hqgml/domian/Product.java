package com.hqgml.domian;

import com.hqgml.utils.DateUtlis;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @data 11/14/2019 7:10 PM
 **/
@Data
public class Product {
    private String id; // 主键
    private String productNum; // 编号 唯一
    private String productName; // 名称
    private String cityName; // 出发城市
    private Date departureTime; // 出发时间
    private String departureTimeStr;
    private double productPrice; // 产品价格
    private String productDesc; // 产品描述
    private Integer productStatus; // 状态 0 关闭 1 开启
    private String productStatusStr;

    public String getDepartureTimeStr() {
        if (departureTimeStr==null){
             departureTimeStr=DateUtlis.dateToString(departureTime,"yyyy-MM-dd HH:mm");
        }
        return departureTimeStr;
    }

    public String getProductStatusStr() {
      if (productStatusStr==null){
          if (productStatus==0){
              productStatusStr="关闭";
          } else if (productStatus==1){
              productStatusStr="开启";
          }
      }
        return productStatusStr;
    }


}
