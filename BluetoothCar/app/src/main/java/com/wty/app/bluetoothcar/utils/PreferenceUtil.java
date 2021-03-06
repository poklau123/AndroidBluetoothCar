package com.wty.app.bluetoothcar.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author wty
 * ShareP 工具类  请在Application oncreate初始化
 **/
public class PreferenceUtil {

	private static volatile PreferenceUtil sInstance = null;

	private static String PREFERENCES_NAME = "Preferences";//preference名字
	public static String LEFT_CODE = "left";//等级
	public static String RIGHT_CODE = "right";//
	public static String UP_CODE = "up";//
	public static String DOWN_CODE = "down";//
	public static String STOP_CODE = "stop";//
	public static String BLUR_CODE = "blur";//

	private SharedPreferences mSharedPreferences;

	/**
	 * 单例模式，获取instance实例
	 * @return
	 */
	public synchronized static PreferenceUtil getInstance() {
		if (sInstance == null) {
			throw new RuntimeException("please init first!");
		}
		return sInstance;
	}

	/**
	 * context用AppContext
	 **/
	public static void init(Context context) {
		if (sInstance == null) {
			synchronized (PreferenceUtil.class) {
				if (sInstance == null) {
					sInstance = new PreferenceUtil(context);
				}
			}
		}
	}

	private PreferenceUtil(Context context) {
		mSharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
	}

	public String getLeftCode() {
		return mSharedPreferences.getString(LEFT_CODE,"A");
	}

	public String getRightCode() {
		return mSharedPreferences.getString(RIGHT_CODE,"D");
	}

	public String getUpCode() {
		return mSharedPreferences.getString(UP_CODE,"W");
	}

	public String getDownCode() {
		return mSharedPreferences.getString(DOWN_CODE,"S");
	}

	public String getStopCode() {
		return mSharedPreferences.getString(STOP_CODE,"P");
	}

	public String getBlurCode() { return mSharedPreferences.getString(BLUR_CODE,"B");}
	/**
	 *	功能描述:保存到sharedPreferences
	 */
	public void writePreferences(String key,String value){
		mSharedPreferences.edit().putString(key, value).commit();// 提交修改;
	}

	public void writePreferences(String key,Boolean value){
		mSharedPreferences.edit().putBoolean(key, value).commit();// 提交修改;
	}

	public void writePreferences(String key,int value){
		mSharedPreferences.edit().putInt(key, value).commit();// 提交修改;
	}
}
