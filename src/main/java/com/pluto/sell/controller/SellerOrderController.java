package com.pluto.sell.controller;

import com.pluto.sell.dto.OrderDTO;
import com.pluto.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Create By wangkai
 * 2017/12/7 11:04
 */
@Controller
@RequestMapping("/seller/order")
public class SellerOrderController {
    @Autowired
    private OrderService orderService;
    /**
     * 订单列表
     * @param page 第几页，从第一页开始
     * @param size 一页多少条数据
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam (value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue = "10") Integer size,
                             Map<String,Object> map){
        PageRequest pageRequest = new PageRequest(page-1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);
        map.put("orderDTOPage",orderDTOPage);
        return new ModelAndView("order/list",map);
    }
}
