//해당 패키지를 기준으로 컴포넌트 스캔을 한다.
package dev.be.moduleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//scanVasePackages 옵션을 주어 해결
//필요한 패키지만 명시하여 전체 로드하는 것이 아닌 선택적으로 로드하여 전체 실행 시간 단축 가능 
@SpringBootApplication(
		scanBasePackages ={"dev.be.moduleapi", "dev.be.modulecommon"}
)
public class ModuleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModuleApiApplication.class, args);
	}

}
