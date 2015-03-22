package com.minishop.ui;

import com.minishop.R;
import com.minishop.R.layout;
import com.minishop.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import com.minishop.utils.*;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.		
		return true;
	}

}
