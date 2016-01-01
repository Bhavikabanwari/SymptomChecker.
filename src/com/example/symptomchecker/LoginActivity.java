package com.example.symptomchecker;

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

public class LoginActivity extends Activity{
	EditText u,p;
	TextView res;
	Button l;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.id.login);
		u=(EditText)findViewById(R.id.name);
		p=(EditText)findViewById(R.id.upass);
        res=(TextView)findViewById(R.id.textView1);
        l=(Button)findViewById(R.id.log);
        db=openOrCreateDatabase("userdata", Context.MODE_PRIVATE, null);
		try {
			
			db.execSQL("create table data (name varchar(30),upass varchar(10),utype varchar(10),gen varchar(10)); ");
			
			
			
		} catch (Exception e ) {
			// TODO: handle exception
		
			
		}
		
		l.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String unm=u.getText().toString();
				String ups=p.getText().toString();
				Cursor c= db.rawQuery("select utype from data where name='"+unm+"' and upass='"+ups+"'",null);
				
				if(c.moveToNext())
				{
					String type=c.getString(0);
					Intent i=new Intent(LoginActivity.this,MainActivity.class);
					startActivity(i);
				}
				else
				{
					res.setText("Invalid Username and password");
				}
			}
		});
		

	}



        
	}


