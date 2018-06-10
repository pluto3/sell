package com.pluto.sell.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * @author wangkai
 * @date 2017/11/21 18:49
 */
@Data
public class ResultVO<T> {
    /**
     * 错误码.
     */
    private Integer code;
    /**
     * 提示信息.
     */
    private String msg;
    /**
     * 返回的具体内容.
     */
    private T data;
}
