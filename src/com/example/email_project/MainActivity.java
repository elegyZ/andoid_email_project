package com.example.email_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle("Send Email");
		final EditText txt_from = (EditText) this.findViewById(R.id.txt_from);
		final EditText txt_to = (EditText) this.findViewById(R.id.txt_to);
		final EditText txt_cc = (EditText) this.findViewById(R.id.txt_cc);
		final EditText txt_bcc = (EditText) this.findViewById(R.id.txt_bcc);
		final EditText txt_subject = (EditText) this.findViewById(R.id.txt_subject);
		final EditText txt_content = (EditText) this.findViewById(R.id.txt_content);
		Button bt_send = (Button) findViewById(R.id.bt_send);
		Button bt_clear = (Button) findViewById(R.id.bt_clear);
		OnClickListener lst_send = new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String strFrom = txt_from.getText().toString();
				String strTo = txt_to.getText().toString();
				String strCc = txt_cc.getText().toString();
				String strBcc = txt_bcc.getText().toString();
				String strSubject = txt_subject.getText().toString();
				String strContent = txt_content.getText().toString();

				if (strFrom.isEmpty())
					Toast.makeText(MainActivity.this, "Please input your email address!", Toast.LENGTH_SHORT).show();
				else if (strTo.isEmpty())
					Toast.makeText(MainActivity.this, "Please input destination email address!", Toast.LENGTH_SHORT)
							.show();
				else {
					readEmail(strFrom, strTo, strCc, strBcc, strSubject, strContent);
				}
			}
		};
		OnClickListener lst_clear = new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				txt_from.setText("");
				txt_to.setText("");
				txt_cc.setText("");
				txt_bcc.setText("");
				txt_subject.setText("");
				txt_content.setText("");
			}
		};
		bt_send.setOnClickListener(lst_send);
		bt_clear.setOnClickListener(lst_clear);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void readEmail(String s1, String s2, String s3, String s4, String s5, String s6) {
		Intent intent0 = new Intent("ActivityEmailReading");
		intent0.putExtra("from", s1);
		intent0.putExtra("to", s2);
		intent0.putExtra("cc", s3);
		intent0.putExtra("bcc", s4);
		intent0.putExtra("subject", s5);
		intent0.putExtra("content", s6);
		startActivity(intent0);
	}

}
