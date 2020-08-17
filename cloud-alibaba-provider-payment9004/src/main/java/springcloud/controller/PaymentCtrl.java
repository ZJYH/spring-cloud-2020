package springcloud.controller;

import com.zh.springcloud.enetites.CommonResult;
import com.zh.springcloud.enetites.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Slf4j
public class PaymentCtrl {

    @Value("${server.port}")
    private String port;

    public static HashMap<Long, Payment> hashMap=new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"23eweuheuisadf33sad"));
        hashMap.put(2L,new Payment(2L,"ddew34e2udheui33sad"));
        hashMap.put(3L,new Payment(3L,"hs342wdaseuheui33sad"));

    }

    @GetMapping(value = "/payment/Sentinel/{id}")
    public CommonResult<Payment>  create(@PathVariable("id")Long id){
        Payment payment =hashMap.get(id);
        log.info("接收数据id为:"+id);
        CommonResult<Payment> result =new CommonResult<>(200,"got it，port:"+port,payment);
        return result;
    }
}
