package info.androidhive.slidingmenu;


import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Path.FillType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import info.androidhive.slidingmenuclient.R;

/////////////////// *** Start  Class *** ///////////////////////////	

public class Gramarrian extends Activity {
	
/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
Button signin;

/////////////////// *** Close  Variable Declaration *** ///////////////////////////	

/////////////////// *** Start OnCreateMethod *** ///////////////////////////	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.gramarrian);
		signin=(Button)findViewById(R.id.fill);
		signin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Dialog dialog = new Dialog(Gramarrian.this);
				dialog.setContentView(R.layout.dialogwrite);
			dialog.setTitle("                     Update");

				// set the custom dialog components - text, image and button
				
				dialog.show();
				
				Button b1=(Button)dialog.findViewById(R.id.create);
	

			}

		});
	}
/////////////////// *** Close OnCreateMethod *** ///////////////////////////	s

}

/////////////////// *** Close Class *** ///////////////////////////	