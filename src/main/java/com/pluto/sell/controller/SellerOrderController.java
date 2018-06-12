package com.pluto.sell.controller;

import com.pluto.sell.dto.OrderDTO;
import com.pluto.sell.enums.ResultEnum;
import com.pluto.sell.exception.SellException;
import com.pluto.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
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
 * @author wangkai
 * @date 2017/12/7 11:04
 */
@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 订单列表
     *
     * @param page 第几页，从第一页开始
     * @param size 一页多少条数据
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "5") Integer size,
                             Map<String, Object> map) {
        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);
        map.put("currentPage", page);
        map.put("orderDTOPage", orderDTOPage);
        map.put("size", size);
        return new ModelAndView("order/list", map);
    }

    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    @GetMapping("/cancel")
    public ModelAndView cancel(String orderId, Map<String, Object> map) {
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        } catch (SellException e) {
            e.printStackTrace();
            log.error("【卖家端取消订单】发生异常");
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMsg());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success");
    }

    /**
     * 订单详情
     * @param orderId
     * @param map
     * @return
     */
    @GetMapping(value = "/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId, Map<String, Object> map){
        OrderDTO orderDTO;
        try {
            orderDTO = orderService.findOne(orderId);
        } catch (Exception e) {
            log.error("【卖家端查询订单详情】发生异常{}",e);
            map.put("msg",e.getMessage());
            map.put("url","sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("orderDTO",orderDTO);
        return new ModelAndView("order/detail",map);
    }

    /**
     * 完结订单
     *
     * @param orderId
     * @return
     */
    @GetMapping("/finish")
    public ModelAndView finish(String orderId, Map<String, Object> map) {
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        } catch (SellException e) {
            e.printStackTrace();
            log.error("【卖家端完结订单】发生异常");
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMsg());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success");
    }
}
