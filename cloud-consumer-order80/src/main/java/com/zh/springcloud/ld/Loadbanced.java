package com.zh.springcloud.ld;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface Loadbanced {

    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
