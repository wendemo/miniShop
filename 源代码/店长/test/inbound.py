__author__ = 'jeff'

import json
import httpwrap

def insertInbound():
    params = {'inGoods':'[{"code":"1","company":"mini","count":1,"name":"Hello Kitty","operatorId":1,"price":1000,"purchasePrice":100,"shopId":1,"trademark":"22","type":1}, \
                        {"code":"2","company":"mini","count":1,"name":"Hello Kitty","operatorId":1,"price":1000,"purchasePrice":100,"shopId":1,"trademark":"22","type":1}]'};
    httpwrap.httpPost("localhost:8080", "/springmvc/putInProduct", params);

def updateInbound():
    params = {'code':'1'};
    resp = httpwrap.httpGet("localhost:8080", "/springmvc/getGoodsFromCode", params);
    goods = {
        'goodsId':resp["content"]["id"],
        'code':resp["content"]["code"],
        'name':resp["content"]["name"],
        'company':resp["content"]["company"],
        "type": resp["content"]["type"],
        "trademark":resp["content"]["trademark"],
        "count":1,
        "operatorId":1,
        "price":1000,
        "purchasePrice":100,
        "shopId":1,

    };
    goodsList = [goods];
    params = {'inGoods':json.dumps(goodsList)};
    httpwrap.httpPost("localhost:8080", "/springmvc/putInProduct", params);

updateInbound();