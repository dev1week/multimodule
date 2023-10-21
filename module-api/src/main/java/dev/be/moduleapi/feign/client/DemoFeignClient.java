package dev.be.moduleapi.feign.client;

import dev.be.moduleapi.feign.common.dto.BaseResponseInfo;
import dev.be.moduleapi.feign.config.DemoFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name="demo-client",
        url="${feign.url.prefix}",
        configuration= DemoFeignConfig.class

)
public interface DemoFeignClient {

    //3. prefix를 붙여서 요청을 다시 보낸다.
    @GetMapping("/get")
    ResponseEntity<BaseResponseInfo> callGet(@RequestHeader("CustomHeaderName") String customHeader,
                                             @RequestParam("name") String name,
                                            @RequestParam("age") Long age);

}
