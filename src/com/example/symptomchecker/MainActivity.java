package com.example.symptomchecker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.TextView;

public class MainActivity extends Activity{
	Button b1,b2,b3,b4,b5;
	//TextView tv;
@Override
protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	b1=(Button)findViewById(R.id.button1);
	b2=(Button)findViewById(R.id.button2);
	b3=(Button)findViewById(R.id.button3);
	b4=(Button)findViewById(R.id.button4);
	b5=(Button)findViewById(R.id.button5);
	//tv=(TextView)findViewById(R.id.textView1);
    b1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i=new Intent(MainActivity.this,SecondActivity.class);
			startActivity(i);
		}
	});
    b2.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i=new Intent(MainActivity.this,ThirdActivity.class);
			startActivity(i);
			
		}
	});
	
}
}
