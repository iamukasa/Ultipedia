package com.amusoft.ultipedialite;

import android.content.Context;

import com.google.android.gcm.GCMBroadcastReceiver;

public class App42GCMReceiver extends GCMBroadcastReceiver{
	@Override
	protected String getGCMIntentServiceClassName(Context context) { 
		return "com.amusoft.ultipedialite.App42GCMService"; 
	} 
}