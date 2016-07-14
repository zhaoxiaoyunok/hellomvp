package com.lyyj.hellomvp;



import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;

public class BaseApplication extends Application{

	private static BaseApplication instance = null;
	public static int version = 0;
	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;

		try {
			PackageInfo packageInfo = getApplicationContext()
					.getPackageManager().getPackageInfo(getPackageName(), 0);
			version = packageInfo.versionCode;
		}catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static BaseApplication getApplication() {
		return instance;
	}

}
