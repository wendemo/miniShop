package com.minishop.ui;

import com.minishop.R;
import com.minishop.utils.BaseActivity;

import android.os.Bundle;
import android.view.Menu;

public class ProductActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

}
