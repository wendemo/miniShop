package cn.springmvc.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.DefinitionListBullet;
import org.htmlparser.tags.InputTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.springmvc.model.GoodsInbound;



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
        List<GoodsInbound> goods = new ArrayList<GoodsInbound>();
		
		Integer i = 0;
		
		for(i = 0; i< 2; i++){
			GoodsInbound info = new GoodsInbound();
			
			info.setCode(String.valueOf(i + 1));
			info.setCompany("mini");
			info.setCount(1);
			info.setName("Hello Kitty");
			info.setPrice(1000);
			info.setPurchasePrice(100);
			info.setShopId(1);
			info.setTrademark("22");
			info.setType(1);
			info.setOperatorId(1);
			
			goods.add(info);
		}
		
		System.out.print(JSON.toJSON(goods));
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
				try {
					Parser parser = new Parser(body);
					NodeFilter state = new HasAttributeFilter( "id", "__VIEWSTATE" );
					NodeFilter event = new HasAttributeFilter( "id", "__EVENTVALIDATION" );
					NodeFilter filter = new OrFilter( state, event );
					NodeList nodes = parser.extractAllNodesThatMatch(filter);
					if(nodes!=null) {
		                for (int i = 0; i < nodes.size(); i++) {
		                	InputTag textnode = (InputTag) nodes.elementAt(i);
		                    
		                	if(textnode.getAttribute("id").equals("__VIEWSTATE")){
		                		form1 = textnode.getAttribute("value");
		                	}
		                	
		                	if(textnode.getAttribute("id").equals("__EVENTVALIDATION")){
		                		form2 = textnode.getAttribute("value");
		                	}
		                }
		            }
				} catch (ParserException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.print("Form1:" + form1 + " Form2:" + form2 + "\n");
			}
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
		//getForm();
		/*NameValuePair state   = new NameValuePair("__VIEWSTATE", form1);
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
				Parser parser = new Parser(body);
				NodeFilter dd = new TagNameFilter( "dd" );
				
				NodeList nodes = parser.extractAllNodesThatMatch(dd);
				if(nodes!=null) {
	                for (int i = 0; i < nodes.size(); i++) {
	                	DefinitionListBullet divnode = (DefinitionListBullet) nodes.elementAt(i);
                   
	                	switch(i){
	                	case 0:
	                		System.out.print("商标:" + divnode.getChildrenHTML() + "\n");
	                		break;
	                	case 1:
	                		String [] tmp = divnode.getChildrenHTML().split("[>|<]");
	                		System.out.print("厂家:" + tmp[2] + "\n");
	                		break;
	                	case 3:
	                		System.out.print("名称:" + divnode.getChildrenHTML() + "\n");
	                		break;
	                	}
	    				
	                }
	            }
			}
			
		} catch (HttpException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (ParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
