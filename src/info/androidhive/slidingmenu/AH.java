package info.androidhive.slidingmenu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import info.androidhive.slidingmenuclient.R;

/////////////////// *** Start  Class *** ///////////////////////////	

public class AH extends Activity {
	
/////////////////// *** Start  Variable Declaration *** ///////////////////////////
	
Button b1;


/////////////////// *** Close  Variable Declaration *** ///////////////////////////

/////////////////// *** Start OnCreateMethod *** ///////////////////////////

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_ah);
		b1=(Button)findViewById(R.id.submit);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplicationContext(),Summary.class);
				startActivity(i);
			}
		});
	}


/////////////////// *** Close OnCreateMethod *** ///////////////////////////	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ah, menu);
		return true;
	}

}


/////////////////// *** Close Class *** ///////////////////////////	
