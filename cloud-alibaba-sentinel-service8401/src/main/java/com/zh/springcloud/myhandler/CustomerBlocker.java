package com.zh.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zh.springcloud.enetites.CommonResult;

/**
 *
 * <p>
 * Description:
 * </p>
 *
 * @author ZH
 * @version v1.0.0
 * @since 2020-07-20 10:59:56
 * @see com.zh.springcloud.myhandler
 *
 */
public class CustomerBlocker {
    public static CommonResult<String> handlerException(String s,BlockException b) {

        return new CommonResult<String>(444, "客户自定义1号-------"+s );
    }

    public static CommonResult<String> handlerException2(String s,BlockException b) {

        return new CommonResult<String>(444, "客户自定义2号----"+s );
    }
}
