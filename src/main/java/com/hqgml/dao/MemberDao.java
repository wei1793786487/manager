package com.hqgml.dao;

import com.hqgml.domian.Member;
import com.hqgml.domian.Orders;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {

    @Select("select * from member where id = #{memberid}")
    public Member findById(String memberid);
}
