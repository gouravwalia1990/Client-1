package info.androidhive.slidingmenu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;
import info.androidhive.slidingmenuclient.R;

/////////////////// *** Start  Class *** ///////////////////////////

public class Register extends Activity {
	
/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
	Button next;
	EditText name,jobposition,password;
	String nam,jobpos,pass;
	public SharedPreferences preferences;
	
/////////////////// *** Close  Variable Declaration *** ///////////////////////////
	
/////////////////// *** Start OnCreateMethod *** ///////////////////////////	
	
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			getWindow().requestFeature(Window.FEATURE_NO_TITLE);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
			setContentView(R.layout.register);
			
			
			name=(EditText)findViewById(R.id.clientName);
			jobposition=(EditText)findViewById(R.id.jobposition);
			password=(EditText)findViewById(R.id.Password);
			preferences = getApplicationContext().getSharedPreferences("7", MODE_PRIVATE);
			next=(Button)findViewById(R.id.NextButton);
			next.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
			nam = name.getText().toString();
		jobpos = jobposition.getText().toString();
		pass = password.getText().toString();
				
				if(nam.length()>0 && jobpos.length()>0 && pass.length()>0 ){

	          		  SharedPreferences.Editor editor = preferences.edit();
	          
	          		
	          		  editor.putString("ID",nam);
	          		editor.putString("N",jobpos);
	          	  editor.putString("PASS",pass);
	          	
	          		
	          		  editor.commit();
				 
	          		  Intent in=new Intent(getApplicationContext(),Nextregister1.class);
	          		  startActivity(in);
	          		
					
				}
				else{
					
					Toast.makeText(getApplicationContext(), "Please Fill All Details", 40000).show();
				}
		
			}
		});
		
		
	}
/////////////////// *** Close OnCreateMethod *** ///////////////////////////
					
	}
/////////////////// *** Close Class *** ///////////////////////////	
