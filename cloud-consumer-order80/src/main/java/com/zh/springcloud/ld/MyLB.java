package com.zh.springcloud.ld;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * <p>
 * Description: 手写轮询负载均衡
 * </p>
 *
 * @author ZH
 * @version v1.0.0
 * @since 2020-07-09 14:09:26
 * @see com.zh.springcloud.ld
 *
 */
@Component
public class MyLB implements Loadbanced {

    private AtomicInteger atomicInteger = new AtomicInteger(0);



    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >= 2147483637 ? 0 :current +1;
        }while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("第几次访问：，次数next："+next);
        return next;
    }


    //获取每次访问需要的索引
    private final int getNext(int modulo){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = (current + 1) % modulo;
            System.out.println("访问次数next:"+next);
        } while(!this.atomicInteger.compareAndSet(current, next));

        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

         //int index = getAndIncrement() % serviceInstances.size();
         int index = getNext(serviceInstances.size());
         return serviceInstances.get(index);
    }
}
