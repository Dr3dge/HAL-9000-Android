package com.whatsmename.hal9000;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.TextView;

import com.whatsmename.hal9000.lib.strings;

public class DisplayMessageActivity extends Activity {

	@SuppressLint("NewApi")
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String input;
        String message;

        // Get the message from the intent
        Intent intent = getIntent();
        input = intent.getStringExtra(strings.EXTRA_MESSAGE);
        message = input.toLowerCase();

        
        if (message.equals("help"))	{
        	TextView textView = new TextView(this);
        	textView.setTextSize(14);
            textView.setText(strings.HELP);
            setContentView(textView);
        	
        }	else if (message.equals("off"))	{
        	Shutdown.shutdown_sys();
        	
        }	else if (message.equals("reboot"))	{
        	Shutdown.reboot_sys();
        	
        }	else if (message.contains("run") || message.contains("launch"))	{
        	Intent LaunchIntent = getPackageManager()
        			.getLaunchIntentForPackage("com.android.chrome");
        	startActivity(LaunchIntent);
        	
        }	else	{
            	TextView textView = new TextView(this);
                textView.setTextSize(20);
                textView.setText(message);
                setContentView(textView);
        }
        
    }
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}