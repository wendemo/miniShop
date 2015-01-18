package cn.springmvc.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.springmvc.model.Shop;
import cn.springmvc.service.ShopService;



public class UserTest {

	/*@Before
	public void before(){                                                                    
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml"
				,"classpath:conf/spring-mybatis.xml"});
		shopService = (ShopService) context.getBean("ShopServiceImpl");
	}*/
	
	@Test
	public void testUrlEncoder(){
		
	}
	
	String form1 = "";
	String form2 = "";
	String form3 = "";
	
	public void getForm(){
		GetMethod getMethod = new GetMethod("http://search.anccnet.com/searchResult2.aspx");
		HttpClient httpclient = new HttpClient();
		try {
			int statusCode = httpclient.executeMethod(getMethod);
			if(statusCode == 200){
				String body = getMethod.getResponseBodyAsString();				
				Pattern wp = Pattern.compile("id=\"__VIEWSTATE.+value=\"(.+)\"");   
			    Matcher m = wp.matcher(body);  
			    if(m.find() && m.groupCount() > 0){
			    	form1 = m.group(1);			    	
			    }	
			    
			    wp = Pattern.compile("id=\"__EVENTVALIDATION.+value=\"(.+)\"");   
			    m = wp.matcher(body);  
			    if(m.find() && m.groupCount() > 0){
			    	form2 = m.group(1);			    	
			    }	
			}
			//System.out.print(getMethod.getResponseBodyAsString());
		} catch (HttpException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	@Test
	public void getBarCode(){		
		getForm();
		NameValuePair state   = new NameValuePair("__VIEWSTATE", form1);
		NameValuePair event   = new NameValuePair("__EVENTVALIDATION", form2);
		NameValuePair key     = new NameValuePair("keyword", "6953392510388");
		NameValuePair btn     = new NameValuePair("gdsBtn", "商品搜索");
		
		PostMethod postMethod = new PostMethod("http://search.anccnet.com/searchResult2.aspx");
		postMethod.setRequestBody( 
				 new NameValuePair[] {state, event, key, btn});
		
		HttpClient httpclient = new HttpClient();
		try {
			int statusCode = httpclient.executeMethod(postMethod);
			
			if(statusCode == 200){
				String body = postMethod.getResponseBodyAsString();
			}
			
		} catch (HttpException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
