package cn.springmvc.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.springmvc.model.Shop;
import cn.springmvc.service.ShopService;



public class UserTest {

    private ShopService shopService;
	
	@Before
	public void before(){                                                                    
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
				,"classpath:conf/spring-mybatis.xml"});
		shopService = (ShopService) context.getBean("ShopServiceImpl");
	}
	
	@Test
	public void selectShop(){
		Shop info = shopService.getShop();
		System.out.print(info.toString());
	}
}
