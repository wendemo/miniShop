__author__ = 'jeff'

import httplib,urllib;
import json

def httpGet(host, path, params):
    conn = httplib.HTTPConnection(host);
    conn.request(method="GET",url=path + '?' + urllib.urlencode(params));
    response = conn.getresponse()
    print path + ':' + str(response.status);
    if response.status != 200 :
        conn.close();
        raise NameError("Http Satus:" + str(response.status));
    res = response.read();
    conn.close();
    return json.loads(res);

def httpPost(host, path, params):
    headers = {"Content-Type":"application/x-www-form-urlencoded",
           "Connection":"Keep-Alive"};
    conn = httplib.HTTPConnection(host);
    conn.request(method="POST",url=path,body=urllib.urlencode(params),headers=headers);
    response = conn.getresponse();
    print path + ':' + str(response.status);
    if response.status != 200 :
        conn.close();
        raise NameError("Http Satus:" + str(response.status));
    res = response.read();
    conn.close();
    return json.loads(res);
