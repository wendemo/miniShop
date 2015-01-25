__author__ = 'jeff'

import httplib,urllib;
import json

def httpGet(host, path, params = None):
    conn = httplib.HTTPConnection(host);
    if params == None :
        conn.request(method="GET",url=path);
    else:
        conn.request(method="GET",url=path + '?' + urllib.urlencode(params));
    response = conn.getresponse()
    print path + ':' + str(response.status);
    if response.status != 200 :
        conn.close();
        raise NameError("Http Satus:" + str(response.status));
    res = response.read();
    conn.close();
    message = json.loads(res);
    if message["code"] != '200' :
        raise NameError(str(message["desc"]) + ":\n" + str(message["content"]));
    return message;

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
    message = json.loads(res);
    if message["code"] != '200' :
        raise NameError(str(message["desc"]) + ":\n" + str(message["content"]));
    return message;
