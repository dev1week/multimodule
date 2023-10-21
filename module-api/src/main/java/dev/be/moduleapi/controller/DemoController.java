package dev.be.moduleapi.controller;



import dev.be.moduleapi.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DemoController {


    @GetMapping("/log")
    public String log(){
      log.trace("trace");
      log.debug("debug");
      log.info("info");
      log.warn("warn");
      log.error("error");
      return "demo";
    }

    @Value("${profile-name}")
    private String name;

    private final DemoService demoService;

    @GetMapping("/save")
    public String save(){
        //프로필 옵션에 따른 분기처리 예제 
        if("profile".equals(name)){

        }else if("beta".equals(name)){

        }


        System.out.println(name);
        return demoService.save();
    }

    @GetMapping("/find")
    public String find(){
        return demoService.find();
    }


    @GetMapping("/error")
    public String error(){

        return demoService.error();

    }

}
