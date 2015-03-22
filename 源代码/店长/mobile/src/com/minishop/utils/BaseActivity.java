package com.minishop.utils;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

//import com.testin.agent.TestinAgent;

/**
 * 
 * <p>用于做公共管理的界面基类 </p>
 *
 * @author Ares.Hu
 * @version $Id: BaseActivity.java, v 0.1 2014年10月9日 下午1:46:51  $
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.create().addActivity(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.create().finishActivity(this);
       
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        //TestinAgent.onResume(this);
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        //TestinAgent.onStop(this);
    }
}
