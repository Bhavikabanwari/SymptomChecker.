package com.example.symptomchecker;

import com.example.symptomchecker.R;
import com.example.symptomchecker.Registration;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FirstActivity extends Activity{
	Button b,s;
	TextView res,t1,t2,t3;
	EditText u,p;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		u=(EditText)findViewById(R.id.name);
		p=(EditText)findViewById(R.id.upass);
		res=(TextView)findViewById(R.id.textView1);
		t1=(TextView)findViewById(R.id.textView2);
		t2=(TextView)findViewById(R.id.textView3);
		t3=(TextView)findViewById(R.id.textView4);
		b=(Button)findViewById(R.id.login);
		s=(Button)findViewById(R.id.signup);
        s.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i =new Intent(FirstActivity.this,Registration.class);
				startActivity(i);
				
			}
		});
		
		db=openOrCreateDatabase("data", Context.MODE_PRIVATE, null);
		try {
			
			db.execSQL("create table entry (name varchar(30),upass varchar(10),utype varchar(10),gen varchar(10)); ");
			Toast.makeText(this, "Table created", Toast.LENGTH_LONG).show();
			
			
		} catch (Exception e ) {
			// TODO: handle exception
		
			
		}
		
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String unm=u.getText().toString();
				String ups=p.getText().toString();
				Cursor c= db.rawQuery("select utype from entry where name='"+unm+"' and upass='"+ups+"'",null);
				
				if(c.moveToNext())
				{
					String type=c.getString(0);
					Intent a=new Intent(FirstActivity.this,ThirdActivity.class);
					startActivity(a);
				}
				else
				{
					res.setText("Invalid username and password");
				}
				
			}
		});	
		

	}

}



