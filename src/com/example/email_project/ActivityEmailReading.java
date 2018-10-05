package com.example.email_project;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityEmailReading extends Activity 
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_emailreading);
		setTitle("Read Email");
		Bundle extras = getIntent().getExtras();
		
		String from = extras.getString("from");
		String to = extras.getString("to");
		String cc = extras.getString("cc");
		String bcc = extras.getString("bcc");
		String subject = extras.getString("subject");
		String content = extras.getString("content");
		
		Intent emailIntent = new Intent(Intent.ACTION_SEND);
		emailIntent.setData(Uri.parse("mailto:"));
		emailIntent.putExtra(Intent.EXTRA_EMAIL, to.split(" "));
		emailIntent.putExtra(Intent.EXTRA_CC, cc.split(" "));
		emailIntent.putExtra(Intent.EXTRA_BCC, bcc.split(" "));
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
		emailIntent.putExtra(Intent.EXTRA_TEXT, content);
		emailIntent.setType("message/rfc822");
		startActivity(Intent.createChooser(emailIntent, "Email"));
		
		TextView tv_from_content = (TextView)this.findViewById(R.id.tv_from_content);
		TextView tv_to_content = (TextView)this.findViewById(R.id.tv_to_content);
		TextView tv_cc_content = (TextView)this.findViewById(R.id.tv_cc_content);
		TextView tv_subject_content = (TextView)this.findViewById(R.id.tv_subject_content);
		TextView tv_email_content = (TextView)this.findViewById(R.id.tv_email_content);
		tv_from_content.setText(from);
		tv_to_content.setText(to);
		tv_cc_content.setText(cc);
		tv_subject_content.setText(subject);
		tv_email_content.setText(content);
		
		Button bt_back = (Button)findViewById(R.id.bt_back);
		OnClickListener lst_back = new OnClickListener()
		{
			@Override
			public void onClick(View arg0) 
			{
				Intent intent0 = new Intent(ActivityEmailReading.this,MainActivity.class);
				startActivity(intent0);				
			}
			
		};
		bt_back.setOnClickListener(lst_back);
	}
}
