package dev.be.moduleapi.controller;

import dev.be.moduleapi.feign.common.dto.BaseResponseInfo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/target-server")
public class TargetController {
    //4. 해당 컨트롤러에서 요청을 처리한다.
    @GetMapping("/get")
    public BaseResponseInfo demoGet(@RequestHeader("CustomHeaderName")String header,
                                    @RequestParam("name") String name,
                                    @RequestParam("age") Long age){

        return BaseResponseInfo.builder()
                .header(header)
                .name(name)
                .age(age)
                .build();

    }
}
