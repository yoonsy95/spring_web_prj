package lab.spring.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import lombok.Setter;
import lombok.extern.log4j.Log4j;

// test code가 spring 실행하는 역할을 할 것
@RunWith(SpringJUnit4ClassRunner.class)
// spring의 빈으로 등록됨
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// lombok을 이용해 록를 기록하는 Logger를 변수로 생성함
// 별도의 Logger 객체 선언이 없어도 Log4j lib와 설정이 존재한다면 바로 새용할 수 있음
// 그러나 'spring legacy project'로 생성하는 경우 기본ㅇ로 Log4j와 해당 설정이 완료됨
// 로그에 대한 내용은 ~~/resources에 별도로 존재함
@Log4j
public class SampleTests {
	@Setter(onMethod_= {@Autowired})
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("------------------------");
		log.info(restaurant.getChef());
	}
}
