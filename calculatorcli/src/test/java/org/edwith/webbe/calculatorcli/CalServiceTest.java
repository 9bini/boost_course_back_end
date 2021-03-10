package org.edwith.webbe.calculatorcli;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// JUnit은 확장기능
// JUnit이 테스트 코드를 실행할 때 스프링 빈 컨테이너가 내부적으로 생성되도록 합니다.
@RunWith(SpringJUnit4ClassRunner.class)
// 내부적으로 생성된 스프링 빈 컨테이너가 사용할 설정파일을 지정할 때 사용
@ContextConfiguration(classes = { ApplicationConfig.class })
public class CalServiceTest {
	
	@Autowired
	// 스프링 빈 컨테이너는 CalculatorService를 주입(Inject)할 수 있게 됩니다. 
	CalService calService;

	@Test
	public void plus() throws Exception {
		// given
		int value1 = 10;
		int value2 = 5;

		// when
		int result = calService.plus(value1, value2);

		// then
		Assert.assertEquals(15, result); // 결과와 15가 같을 경우에만 성공
	}

	@Test
	public void divide() throws Exception {
		// given
		int value1 = 10;
		int value2 = 5;

		// when
		int result = calService.divide(value1, value2);

		// then
		Assert.assertEquals(2, result); // 결과와 2가 같을 경우에만 성공
	}

	@Test
	public void divideExceptionTest() throws Exception {
		// given
		int value1 = 10;
		int value2 = 0;

		try {
			calService.divide(value1, value2);
		} catch (ArithmeticException ae) {
			Assert.assertTrue(true); // 이부분이 실행되었다면 성공
			return; // 메소드를 더이상 실행하지 않는다.
		}
		Assert.fail(); // 이부분이 실행되면 무조건 실패다.

	}

}
