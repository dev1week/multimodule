package dev.be.moduleapi.service;

import dev.be.moduleapi.feign.client.DemoFeignClient;
import dev.be.moduleapi.feign.common.dto.BaseResponseInfo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DemoFeignService {

    private final DemoFeignClient demoFeignClient;


    //2. feign client에 정의된 메서드를 호출한다.
    public String get(){
        ResponseEntity<BaseResponseInfo> response = demoFeignClient.callGet("header", "name", 1L);
        System.out.println(response.getBody());
        return "get";
    }

}
