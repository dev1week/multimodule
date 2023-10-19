
package dev.be.moduleapi.service;


import dev.be.moduleapi.exception.CustomException;
import dev.be.modulecommon.domain.Member;
import dev.be.modulecommon.enums.CodeEnum;
import dev.be.modulecommon.repositories.MemberRepository;
import dev.be.modulecommon.service.CommonDemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DemoService {

    private final CommonDemoService commonDemoService;


    private final MemberRepository memberRepository;

    public String save(){
        memberRepository.save(Member.builder().name(Thread.currentThread().getName()).build());
        return "save";
    }



    public String find(){
        int size = memberRepository.findAll().size();
        System.out.println(size);
        log.info(size+" ");
        return "find";
    }


    public String error(){

        if(true){
            throw new CustomException(CodeEnum.UNKNOWN_ERROR);
        }
        return "error";
    }




}
