package com.example.mtom;

import org.apache.cordova.DroidGap;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.webkit.DownloadListener;

public class MainActivity extends DroidGap{
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/index.html");
        appView.setDownloadListener(new DownloadListener(){
        	public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size){
        		Intent viewIntent = new Intent(Intent.ACTION_VIEW);
        		viewIntent.setDataAndType(Uri.parse(url), mimeType);
        		try{ 
        			startActivity(viewIntent);
        		}
        		catch(ActivityNotFoundException ex){
        			Log.w("MainErre","Mime형식을 찾을 수 없습니다.1"+mimeType);
        		}
        	}
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
