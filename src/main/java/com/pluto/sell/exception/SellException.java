package com.pluto.sell.exception;

import com.pluto.sell.enums.ResultEnum;

/**
 * @author wangkai
 * @date 2017/11/26 21:05
 */
public class SellException extends RuntimeException {
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code=resultEnum.getCode();
    }

    public SellException(Integer code,String messgae) {
        super(messgae);
        this.code = code;
    }
}
