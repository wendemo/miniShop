__author__ = 'jeff'

import httpwrap

def outboundGoods():
    res = httpwrap.httpGet("localhost:8080", "/springmvc/getWarehouseFromCode", {'code':'1'})
    count = res['content']['count'];
    if count > 0 :
        goods = {
            'count' : 1,
            'goodsId' : res['content']['goodsId'],
            'price' : res['content']['price'],
            'operatorId' : 1
        }
    else:
        print "no warehouse"
        return

    httpwrap.httpPost("localhost:8080", "/springmvc/putOutProduct", {'outGoods':[goods]});

outboundGoods()
