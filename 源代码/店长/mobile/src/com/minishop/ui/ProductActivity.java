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
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ProductActivity extends BaseActivity {
	
	@ViewInject(R.id.codeEdit)
	EditText textCode;
	
	@ViewInject(R.id.purchaseLayout)
	RelativeLayout purcLayout;
	
	@ViewInject(R.id.priceLayout)
	RelativeLayout priceLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product);
		
		ViewUtils.inject(this);
		
		Intent in = this.getIntent();
		
		textCode.setText(in.getStringExtra("code"));
		
		int type = in.getIntExtra("type", -1);
		
		if(type == 1){
			purcLayout.setVisibility(View.GONE);
		} else if(type == 0){
			purcLayout.setVisibility(View.VISIBLE);
			priceLayout.setVisibility(View.VISIBLE);
		} else {
			purcLayout.setVisibility(View.GONE);
			priceLayout.setVisibility(View.GONE);			
		}
		
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
