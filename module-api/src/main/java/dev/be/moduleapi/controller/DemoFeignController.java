package dev.be.moduleapi.controller;

import dev.be.moduleapi.service.DemoFeignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoFeignController {

    private final DemoFeignService demoFeignService;


    //해당 컨트롤러로 요청을 보낸다.
    @GetMapping("/get")
    public String getController(){
        return demoFeignService.get();
    }

}
