package com.pluto.sell.converter;

import com.pluto.sell.dataobject.OrderMaster;
import com.pluto.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Create By wangkai
 * 2017/11/28 21:30
 * @author wangkai
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList) {
//        List<OrderDTO> orderDTOList = new ArrayList<>();
//        for (OrderMaster orderMaster:orderMasterList) {
//            OrderDTO orderDTO = convert(orderMaster);
//            orderDTOList.add(orderDTO);
//        }
        return orderMasterList.stream().map(e ->
            convert(e)
        ).collect(Collectors.toList());
    }
}
