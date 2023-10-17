package dev.be.moduleapi.ExceptionHandler;

import dev.be.moduleapi.Response.CommonResponse;
import dev.be.moduleapi.exception.CustomException;
import dev.be.modulecommon.enums.CodeEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //커스텀 예외를 매핑하여 내보낸다.
    @ExceptionHandler(CustomException.class)
    public CommonResponse handlerCustomException(CustomException e){

        return CommonResponse.builder()
                .returnCode(e.getReturnCode())
                .returnMessage(e.getReturnMessage())
                .build();
    }


    //절대 예상치 못한 예외가 터졌을 때 어처피 조상 클래스가 Exception이기 때문에 이를 들고 온다.
    @ExceptionHandler(Exception.class)
    public CommonResponse handlerException(Exception e){
        return CommonResponse.builder()
                .returnCode(CodeEnum.UNKNOWN_ERROR.getCode())
                .returnMessage(CodeEnum.UNKNOWN_ERROR.getMessage())
                .build();
    }

}
