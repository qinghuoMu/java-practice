package cn.itcast.dao;

import cn.itcast.pojo.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    public Order queryOrderAndUserByOrderNum(String orderNum);

    public Order queryOrderAndUserAndOrderdetailByOrderNum(String orderNum);

    public Order queryOrderAndUserAndOrderdetailAndItemByOrderNum(String orderNum);

    /**
     * 测试延迟加载
     * @param number
     * @return
     */
    public Order queryOrderLazy(@Param("number")String number);

}
