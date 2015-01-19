package cn.springmvc.service.impl;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.GoodsMapper;
import cn.springmvc.model.Goods;

@Service
public class BarCodeService {
	
	@Autowired
	GoodsMapper goodsDao;
	
    public Goods getGoodsInfo(String code) throws HttpException, IOException{
    	Goods info = null;
    	
    	//info = goodsDao.getByCode(code);
    	
    	if(info == null){
    		PostMethod postMethod = new PostMethod("http://search.anccnet.com/searchResult2.aspx");
    		postMethod.addRequestHeader("keyword", code);
    		HttpClient httpclient = new HttpClient();
    		int statusCode = httpclient.executeMethod(postMethod);
    		if(statusCode == 200){
    			String respone = postMethod.getResponseBodyAsString();
    			System.out.print(respone);
    			info = new Goods();
    		}
    	}
    	
    	return info;
    }
}
