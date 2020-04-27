package com.chnn10.community;

import com.chnn10.community.config.AlphaConfig;
import com.chnn10.community.service.AlphaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests  {

	@Autowired
	private AlphaConfig alphaConfig;

	@Test
	public void myTest(){
		System.out.println(alphaConfig.simpleDateFormat().format(new Date()));
	}


}
