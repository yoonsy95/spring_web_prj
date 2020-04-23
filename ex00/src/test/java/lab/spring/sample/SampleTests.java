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

// test code�� spring �����ϴ� ������ �� ��
@RunWith(SpringJUnit4ClassRunner.class)
// spring�� ������ ��ϵ�
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// lombok�� �̿��� �ϸ� ����ϴ� Logger�� ������ ������
// ������ Logger ��ü ������ ��� Log4j lib�� ������ �����Ѵٸ� �ٷ� ������ �� ����
// �׷��� 'spring legacy project'�� �����ϴ� ��� �⺻���� Log4j�� �ش� ������ �Ϸ��
// �α׿� ���� ������ ~~/resources�� ������ ������
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
