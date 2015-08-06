package info.androidhive.slidingmenu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Nextregister extends Activity  {
	public SharedPreferences preferences;
	 String con,maill,nam,pos,pass,clientidd;
	 Button next;
	
	 EditText mail,phone,clientid;
	 String selState,selstate1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_nextregister);
		   mail=(EditText)findViewById(R.id.mail);
		   clientid=(EditText)findViewById(R.id.clientid);
	        phone=(EditText)findViewById(R.id.phone);
	        preferences = getApplicationContext().getSharedPreferences("7", MODE_PRIVATE);
	        nam=(preferences.getString("ID", ""));
			 pos=(preferences.getString("N", ""));
			 pass=(preferences.getString("PASS", ""));
			 
		 Toast.makeText(getApplicationContext(), nam +" , "+ pos +" , " + pass , 40000).show();
	        next=(Button)findViewById(R.id.NextButton);
			next.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					// TODO Auto-generated method stub

					maill = mail.getText().toString();   
					clientidd = clientid.getText().toString();   
					con = phone.getText().toString();   
				if(maill.length()>0 && con.length()>0 && clientidd.length()>0 ){

	          		  SharedPreferences.Editor editor = preferences.edit();
	          	
	          		  editor.putString("PASS",maill);
	          		  editor.putString("ID",con);
	          		  editor.putString("N",nam);
	          		  editor.putString("N1",pos);
	          		  editor.putString("N2",pass);
	          		 editor.putString("N3",clientidd);
	          	
	          	
	          		
	          		  editor.commit();
	          		
	          		  Intent in=new Intent(getApplicationContext(),SecondNextreg.class);
	          		  startActivity(in);
	          		
					
				}
				else{
					
					Toast.makeText(getApplicationContext(), "Please Provide All The Details", 40000).show();
				}
		
			}
		});
	        
	
	        
		} 
		
		

		
		
	}
		
	

