package com.minishop.ui;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.minishop.R;
import com.minishop.utils.BaseActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ProductActivity extends BaseActivity {
	
	//@ViewInject(R.id.codeText)
	TextView textCode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product);
		
		ViewUtils.inject(this);
		
		Intent in = this.getIntent();
		
		//textCode.setText(in.getStringExtra("code"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		
		return true;
	}
	
	@OnClick(R.id.backImg)
	public void OnClickBack(View view) {
		finish();
	}

}
