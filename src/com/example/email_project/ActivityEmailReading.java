package com.example.email_project;

import android.app.Activity;
import android.content.Intent;
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
		TextView tv_from_content = (TextView)this.findViewById(R.id.tv_from_content);
		TextView tv_to_content = (TextView)this.findViewById(R.id.tv_to_content);
		TextView tv_cc_content = (TextView)this.findViewById(R.id.tv_cc_content);
		TextView tv_bcc_content = (TextView)this.findViewById(R.id.tv_bcc_content);
		TextView tv_subject_content = (TextView)this.findViewById(R.id.tv_subject_content);
		TextView tv_email_content = (TextView)this.findViewById(R.id.tv_email_content);
		tv_from_content.setText(extras.getString("from"));
		tv_to_content.setText(extras.getString("to"));
		tv_cc_content.setText(extras.getString("cc"));
		tv_bcc_content.setText(extras.getString("bcc"));
		tv_subject_content.setText(extras.getString("subject"));
		tv_email_content.setText(extras.getString("content"));
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
