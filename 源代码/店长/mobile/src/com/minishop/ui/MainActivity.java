package com.minishop.ui;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.minishop.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.minishop.utils.*;

public class MainActivity extends BaseActivity {

	final int SCAN_IMG = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ViewUtils.inject(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.		
		return true;
	}
	
	
	@OnClick(R.id.scanImg)
	public void onClickScanImg(View view){
		Intent in = new Intent(this, ScanActivity.class);
		in.putExtra("type", 1);
        startActivityForResult(in, SCAN_IMG);
	}

}
