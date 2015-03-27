package com.minishop.ui;

import java.io.IOException;
import java.util.Vector;

import com.google.zxing.BarcodeFormat;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.minishop.R;
import com.minishop.camera.CameraManager;
import com.minishop.decoding.CaptureActivityHandler;
import com.minishop.utils.BaseActivity;
import com.minishop.view.ViewfinderView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.SurfaceHolder.Callback;

public class ProductActivity extends BaseActivity implements Callback  {

	private ViewfinderView viewfinderView;
	private CaptureActivityHandler handler;
	private boolean hasSurface;
	
	private Vector<BarcodeFormat> decodeFormats;
	private String characterSet;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product);
		
		ViewUtils.inject(this);
		
		viewfinderView = (ViewfinderView) findViewById(R.id.viewScan);
		
		CameraManager.init(this);
		hasSurface = false;
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		SurfaceView surfaceView = (SurfaceView) findViewById(R.id.preview_view);
		SurfaceHolder surfaceHolder = surfaceView.getHolder();
		if (hasSurface) {
			initCamera(surfaceHolder);
		} else {
			surfaceHolder.addCallback(this);
			surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		}
	}
	
	private void initCamera(SurfaceHolder surfaceHolder) {
		try {
			CameraManager.get().openDriver(surfaceHolder);
		} catch (IOException ioe) {
			return;
		} catch (RuntimeException e) {
			return;
		}
		if (handler == null) {
			handler = new CaptureActivityHandler(this, decodeFormats,
					characterSet);
		}
	}
	
	public Handler getHandler() {
		return handler;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		return true;
	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		if (!hasSurface) {
			hasSurface = true;
			initCamera(holder);
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		hasSurface = false;
	}
	
	public void drawViewfinder() {
		viewfinderView.drawViewfinder();
	}
	
	public ViewfinderView getViewfinderView() {
		return viewfinderView;
	}
}
