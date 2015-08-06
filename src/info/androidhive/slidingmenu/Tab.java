package info.androidhive.slidingmenu;


import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

import android.widget.TabHost;
import android.widget.TextView;
import info.androidhive.slidingmenuclient.R;

/////////////////// *** Start  Class *** ///////////////////////////	

@SuppressWarnings("deprecation")
public class Tab extends TabActivity {

/////////////////// *** Start OnCreateMethod *** ///////////////////////////	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_tabb);
		Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
    
		TabHost tabHost=(TabHost)findViewById(android.R.id.tabhost);
		tabHost.setup();
		TabHost mTabHost = getTabHost();
		
	       mTabHost.addTab(mTabHost.newTabSpec("timer")
	    		
	              .setIndicator(("TIMER"))
	         .setContent(new Intent(this, Timer.class)));
	       mTabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.selector);
	       mTabHost.getTabWidget().getChildAt(0).getBottom();
     
	 
	       mTabHost.addTab(mTabHost.newTabSpec("evaluator")
	               .setIndicator(("EVALUATOR     FORM"))
	         .setContent(new Intent(this, Evaluator.class)));
	       mTabHost.getTabWidget().getChildAt(1).setBackgroundResource(R.drawable.selector);
	       mTabHost.getTabWidget().getChildAt(1).getBottom();
	    
	       mTabHost.addTab(mTabHost.newTabSpec("grammarian")
		    		
		              .setIndicator(("GRAMMARIAN"))
		         .setContent(new Intent(this, Gramarrian.class)));
		       mTabHost.getTabWidget().getChildAt(2).setBackgroundResource(R.drawable.selector);
		       mTabHost.getTabWidget().getChildAt(2).getBottom();
		       
		       mTabHost.addTab(mTabHost.newTabSpec("counter")
			    	  .setIndicator(("AH COUNTER"))
			         .setContent(new Intent(this, AH.class)));
			       mTabHost.getTabWidget().getChildAt(3).setBackgroundResource(R.drawable.selector);
			       mTabHost.getTabWidget().getChildAt(3).getBottom();
	 
	               mTabHost.setCurrentTab(0);
	               mTabHost.getTabWidget().getChildAt(0).getLayoutParams().width = 160;
	               mTabHost.getTabWidget().getChildAt(1).getLayoutParams().width = 160;
	               mTabHost.getTabWidget().getChildAt(2).getLayoutParams().width = 160;
	               mTabHost.getTabWidget().getChildAt(3).getLayoutParams().width = 160;
		    
		       
	          for(int i=0;i<mTabHost.getTabWidget().getChildCount();i++) 
	          {
	              TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
              tv.setTextSize(10);
	              
	              tv.setTextColor(Color.parseColor("#ffffff"));
	          }
	         
	}
/////////////////// *** Close OnCreateMethod *** ///////////////////////////		

}
/////////////////// *** Close Class *** ///////////////////////////	
