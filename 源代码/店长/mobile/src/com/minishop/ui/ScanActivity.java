package com.minishop.ui;

import net.sourceforge.zbar.Config;
import net.sourceforge.zbar.Image;
import net.sourceforge.zbar.ImageScanner;
import net.sourceforge.zbar.Symbol;
import net.sourceforge.zbar.SymbolSet;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.minishop.R;
import com.minishop.utils.BaseActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;

public class ScanActivity extends BaseActivity {
	boolean mCheck = false;

	private static final float BEEP_VOLUME = 0.10f;
	private static final long VIBRATE_DURATION = 200L;

	private Camera mCamera;
	private CameraPreview mPreview;
	private Handler autoFocusHandler;
	private MediaPlayer mediaPlayer;
	private boolean playBeep = true;
	
	private boolean lightStatus = false;

	private ListView lv;

	ImageScanner scanner;

	private boolean previewing = true;

	static {
		System.loadLibrary("iconv");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_scan);

		ViewUtils.inject(this);

		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

		autoFocusHandler = new Handler();
		mCamera = getCameraInstance();

		/* Instance barcode scanner */
		scanner = new ImageScanner();
		scanner.setConfig(0, Config.X_DENSITY, 3);
		scanner.setConfig(0, Config.Y_DENSITY, 3);

		mPreview = new CameraPreview(this, mCamera, previewCb, autoFocusCB);
		FrameLayout preview = (FrameLayout) findViewById(R.id.cameraPreview);
		preview.addView(mPreview);

		mCamera.setPreviewCallback(previewCb);
		mCamera.startPreview();
		previewing = true;
		mCamera.autoFocus(autoFocusCB);

		AudioManager audioService = (AudioManager) getSystemService(AUDIO_SERVICE);

		if (audioService.getRingerMode() != AudioManager.RINGER_MODE_NORMAL) {
			playBeep = false;
		}

	}

	@Override
	protected void onResume() {
		super.onResume();

	}

	public void onPause() {
		super.onPause();
		releaseCamera();
	}

	public static Camera getCameraInstance() {
		Camera c = null;
		try {
			c = Camera.open();
		} catch (Exception e) {
		}
		return c;
	}

	private void releaseCamera() {
		if (mCamera != null) {
			previewing = false;
			Camera.Parameters parameters = mCamera.getParameters();     
			parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);    
			mCamera.setParameters( parameters );
			lightStatus = false;
			mCamera.setPreviewCallback(null);
			mCamera.release();
			mCamera = null;
		}
	}

	private Runnable doAutoFocus = new Runnable() {
		public void run() {
			if (previewing)
				mCamera.autoFocus(autoFocusCB);
		}
	};

	PreviewCallback previewCb = new PreviewCallback() {
		public void onPreviewFrame(byte[] data, Camera camera) {
			Camera.Parameters parameters = camera.getParameters();
			Size size = parameters.getPreviewSize();

			Image barcode = new Image(size.width, size.height, "Y800");
			barcode.setData(data);

			int result = scanner.scanImage(barcode);

			if (result != 0) {
				previewing = false;
				mCamera.setPreviewCallback(null);
				mCamera.stopPreview();

				SymbolSet syms = scanner.getResults();

				final String[] codes = new String[syms.size()];

				int i = 0;

				for (Symbol sym : syms) {
					// Log.e("Test", sym.getData());
					codes[i] = sym.getData();
					i++;
				}

				AlertDialog builder = new AlertDialog.Builder(ScanActivity.this)
						.setTitle("条形码列表")
						.setSingleChoiceItems(codes, 0, null)
						.setPositiveButton("确定",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										String content = "";

										for (int i = 0; i < codes.length; i++) {
											if (lv.getCheckedItemPositions()
													.get(i)) {
												if (content.equals("")) {
													content = lv.getAdapter()
															.getItem(i)
															.toString();
												} else {
													content += ","
															+ lv.getAdapter()
																	.getItem(i);
												}
											}
										}

										// 用户至少选择了一个列表项
										if (lv.getCheckedItemPositions().size() > 0) {
											Intent intent = new Intent(
													ScanActivity.this,
													ProductActivity.class);

											intent.putExtra("code", content);
											startActivity(intent);

											finish();
										}

										// 用户未选择任何列表项
										else if (lv.getCheckedItemPositions()
												.size() <= 0) {
											mCamera.setPreviewCallback(previewCb);
											mCamera.startPreview();
											previewing = true;
											mCamera.autoFocus(autoFocusCB);
										}
									}
								})
						.setNegativeButton("取消",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										mCamera.setPreviewCallback(previewCb);
										mCamera.startPreview();
										previewing = true;
										mCamera.autoFocus(autoFocusCB);
									}

								}).create();

				lv = builder.getListView();
				builder.show();

				/*
				 * String code = "";
				 * 
				 * for (Symbol sym : syms) { //Log.e("Test", sym.getData());
				 * code = sym.getData(); }
				 * 
				 * if(code != ""){ Intent intent = new Intent(ScanActivity.this,
				 * ProductActivity.class);
				 * 
				 * intent.putExtra("code", code); startActivity(intent);
				 * 
				 * finish(); }
				 */

			}
		}
	};

	// Mimic continuous auto-focusing
	AutoFocusCallback autoFocusCB = new AutoFocusCallback() {
		public void onAutoFocus(boolean success, Camera camera) {
			autoFocusHandler.postDelayed(doAutoFocus, 1000);
		}
	};

	@OnClick(R.id.backImg)
	public void OnClickBack(View view) {
		finish();
	}
	
	@OnClick(R.id.lightImg)
	public void OnClickLight(View view){
		if(!lightStatus){
			Camera.Parameters parameters = mCamera.getParameters();     
			parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);    
			mCamera.setParameters( parameters );
			lightStatus = true;
		}else{
			Camera.Parameters parameters = mCamera.getParameters();     
			parameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);    
			mCamera.setParameters( parameters );
			lightStatus = false;
		}

	}
}
