package org.edwith.webbe.calculatorcli;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class) // mockito가 제공하는 Junit 확장 클래스
//@ContextConfiguration(classes = {ApplicationConfig.class})
public class MyServiceTest {
	//@Autowired
	@InjectMocks
	MyService myService;
	
	// 여러분이 객체를 생성하지 않아도 자동으로 객체가 생성되고 해당 필드가 초기화 된다는 것
	@Mock 
	CalService calService;

	@Test
    public void execute() throws Exception{
        // given
        int value1 = 5;
        int value2 = 10;
        given(calService.plus(5, 10)).willReturn(15);
        //when

        // when
        int result = myService.execute(value1, value2);

        // then
        verify(calService).plus(anyInt(), anyInt());
        Assert.assertEquals(30, result);
    }
}