package lab.spring.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Restaurant {
//	@Setter는 자동으로 setChef()를 컴파일시 생성
	@Setter(onMethod_=@Autowired)
	private Chef chef;
}
