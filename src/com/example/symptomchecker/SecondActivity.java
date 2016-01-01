package com.example.symptomchecker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity {
	Button b1,b2,b3,b4,b5;
    TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		tv=(TextView)findViewById(R.id.textView2);
		b1=(Button)findViewById(R.id.btn1);
		b2=(Button)findViewById(R.id.btn2);
		
		
		
	
		
	}

}
