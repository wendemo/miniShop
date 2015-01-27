<%@page language="java" import="java.util.regex.*" contentType="text/html; charset=utf-8"%>
<% 
String wap = "http://3g.ssss.com.cn"; 

String agent = request.getHeader("user-agent"); 
String agentcheck = agent.trim().toLowerCase(); 
boolean isWAP = false; 
String[] keywords = {"mobile", "android", 
"symbianos", "iphone", "wp\\d*", "windows phone", 
"mqqbrowser", "nokia", "samsung", "midp-2", 
"untrusted/1.0", "windows ce", "blackberry","ucweb", 
"brew", "j2me", "yulong", "coolpad", "tianyu", "ty-", 
"k-touch", "haier", "dopod", "lenovo", "huaqin", "aigo-", 
"ctc/1.0", "ctc/2.0", "cmcc", "daxian", "mot-", 
"sonyericsson", "gionee", "htc", "zte", "huawei", "webos", 
"gobrowser", "iemobile", "wap2.0","WAPI"}; 
Pattern pf = Pattern.compile("wp\\d*"); 
Matcher mf = pf.matcher(agentcheck); 
if (agentcheck!=null&&(agentcheck.indexOf("windows nt") == -1 && agentcheck 
.indexOf("Ubuntu") == -1) 
|| (agentcheck.indexOf("windows nt") > -1 && mf.find())) { 
for (int i = 0; i < keywords.length; i++) { 
Pattern p = Pattern.compile(keywords[i]); 
Matcher m = p.matcher(agentcheck); 
//排除 苹果桌面系统 和ipad 、iPod 
if (m.find() && agentcheck.indexOf("ipad") == -1 
&& agentcheck.indexOf("ipod") == -1 
&& agentcheck.indexOf("macintosh") == -1) { 
isWAP = true; 
break; 
} 
} 
} 
if (isWAP) { 
    response.sendRedirect("mobile/index.do"); 
} else {
    response.sendRedirect("index.do"); 
}
%>
</i>