package com.example.symptomchecker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Registration extends Activity{
	EditText n,p,t;
	Button reg;
	RadioGroup gn;
	String gen;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		n=(EditText)findViewById(R.id.name);
		p=(EditText)findViewById(R.id.upass);
		t=(EditText)findViewById(R.id.utype);
		gn=(RadioGroup)findViewById(R.id.gen);
		gn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				if (checkedId==R.id.radio0) 
				  gen="Male";
				
					else
						gen="Female";																
			}
		});
		reg=(Button)findViewById(R.id.register);
			
		db=openOrCreateDatabase("userdata", Context.MODE_PRIVATE, null);
		try {
			
			db.execSQL("create table entry (name varchar(30),upass varchar(10),utype varchar(10),gen varchar(10)); ");
			Toast.makeText(this, "Table created", Toast.LENGTH_LONG).show();
			
			
		} catch (Exception e ) {
			// TODO: handle exception
			
		}
		  reg.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String nm=n.getText().toString();
				String ups=p.getText().toString();
				String ty=t.getText().toString();
				
				db.execSQL("insert into entry values('"+nm+"','"+ups+"','"+ty+"','"+gen+"');");
			    Toast.makeText(Registration.this, "Record inserted", Toast.LENGTH_LONG).show();
			    Intent i = new Intent(Registration.this,FirstActivity.class);
			    startActivity(i);
				
				
			}
		});
		
	}

}
