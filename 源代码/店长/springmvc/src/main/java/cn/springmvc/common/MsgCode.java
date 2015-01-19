package cn.springmvc.common;

public enum MsgCode {
    OK("200", "Success"), 
    EXCEPTION("500", "Server Exception");
   
    private MsgCode(String code, String desc){
    	mCode = code;
    }

    public String getCode() {
    	// TODO Auto-generated method stub
    	return mCode;
    }
    
    public String getDesc() {
    	// TODO Auto-generated method stub
    	return mDesc;
    }
    
    String mCode;
    String mDesc;
}
