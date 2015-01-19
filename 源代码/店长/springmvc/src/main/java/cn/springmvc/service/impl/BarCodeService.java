package cn.springmvc.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.tags.DefinitionListBullet;
import org.htmlparser.tags.InputTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.GoodsMapper;
import cn.springmvc.model.Goods;

@Service
public class BarCodeService {
	
	@Autowired
	GoodsMapper goodsDao;

	String mStateValue;
	String mEventValue;
	
	String mTrademark;
	String mCompany;	
	String mName;
	
	public void getForm() throws HttpException, IOException, ParserException{
		GetMethod getMethod = new GetMethod(
				"http://search.anccnet.com/searchResult2.aspx");
		HttpClient httpclient = new HttpClient();
		int statusCode = httpclient.executeMethod(getMethod);
		if (statusCode == 200) {
			String body = getMethod.getResponseBodyAsString();
			Parser parser = new Parser(body);
			NodeFilter state = new HasAttributeFilter("id", "__VIEWSTATE");
			NodeFilter event = new HasAttributeFilter("id", "__EVENTVALIDATION");
			NodeFilter filter = new OrFilter(state, event);
			NodeList nodes = parser.extractAllNodesThatMatch(filter);
			if (nodes != null) {
				for (int i = 0; i < nodes.size(); i++) {
					InputTag textnode = (InputTag) nodes.elementAt(i);

					if (textnode.getAttribute("id").equals("__VIEWSTATE")) {
						mStateValue = textnode.getAttribute("value");
					}

					if (textnode.getAttribute("id").equals("__EVENTVALIDATION")) {
						mEventValue = textnode.getAttribute("value");
					}
				}
			}
		}
	}
	
	private void getBarCode() throws HttpException, IOException, ParserException{
		NameValuePair state = new NameValuePair("__VIEWSTATE", mStateValue);
		NameValuePair event = new NameValuePair("__EVENTVALIDATION", mEventValue);
		NameValuePair key = new NameValuePair("keyword", "6953392510388");
		NameValuePair btn = new NameValuePair("gdsBtn", "商品搜索");

		PostMethod postMethod = new PostMethod(
				"http://search.anccnet.com/searchResult2.aspx");
		postMethod
				.setRequestBody(new NameValuePair[] { state, event, key, btn });

		HttpClient httpclient = new HttpClient();
		int statusCode = httpclient.executeMethod(postMethod);

		if (statusCode == 200) {
			String body = postMethod.getResponseBodyAsString();
			Parser parser = new Parser(body);
			NodeFilter dd = new TagNameFilter("dd");

			NodeList nodes = parser.extractAllNodesThatMatch(dd);
			if (nodes != null) {
				for (int i = 0; i < nodes.size(); i++) {
					DefinitionListBullet divnode = (DefinitionListBullet) nodes
							.elementAt(i);

					switch (i) {
					case 0:
						mTrademark = divnode.getChildrenHTML();
						break;
					case 1:
						mCompany = divnode.getChildrenHTML().split("[>|<]")[2];
						break;
					case 3:
						mName = divnode.getChildrenHTML();
						break;
					}

				}
			}
		}
	}
	
    public Goods getGoodsInfo(String code) throws HttpException, IOException, ParserException{
    	Goods info = null;
    	
    	info = goodsDao.getByCode(code);
    	
    	if(info == null){
    		getForm();
    		getBarCode();
    		
    		info = new Goods();
    		
    		info.setCode(code);
    		info.setCompany(mCompany);
    		info.setName(mName);
    		info.setTrademark(mTrademark);
    	}
    	
    	return info;
    }
}
