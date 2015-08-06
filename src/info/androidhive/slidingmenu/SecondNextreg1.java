package info.androidhive.slidingmenu;

import info.androidhive.slidingmenuclient.R;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;


/////////////////// *** Start  Class *** ///////////////////////////	

public class SecondNextreg1 extends Activity {

/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
	public SharedPreferences preferences;
	 String id,nam,clubnam,con,maill,pos,pass,clubidd,clientidd,Message,countryy,clubidd1,country1,state1,city1,name1,Status,statee,cityy;
	 Button Register;
	 ImageButton search;
	 String content1,status1,message1,c;
	 HttpEntity resEntity;
	 String response_string,response_string1; 
	 List<NameValuePair> nameValuePairs,nameValuePairs1;
	 HttpResponse response,response1;
	 HttpClient httpclient,httpclient1;
	 HttpPost httppost,httppost1;
	 EditText clubid,country,state,city,clubname;
	 ProgressDialog progress;
	 ProgressBar progress3;
	 
/////////////////// *** Close  Variable Declaration *** ///////////////////////////	
	 

/////////////////// *** Start OnCreateMethod *** ///////////////////////////
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_second_nextreg);
		clubid=(EditText)findViewById(R.id.clubID);
		country=(EditText)findViewById(R.id.country);
		search=(ImageButton)findViewById(R.id.imageButton1);
		state=(EditText)findViewById(R.id.state);
		 city=(EditText)findViewById(R.id.city);
	     clubname=(EditText)findViewById(R.id.clubname);
	     progress = new ProgressDialog(this);
	      Register=(Button)findViewById(R.id.register);
	    progress3=(ProgressBar)findViewById(R.id.progressBar2);
	    
		 preferences = getApplicationContext().getSharedPreferences("7", MODE_PRIVATE);
	
		con=(preferences.getString("ID", ""));
		 nam=(preferences.getString("N", ""));
		 pos=(preferences.getString("N1", ""));
		 pass=(preferences.getString("N2", ""));
		maill=(preferences.getString("PASS", ""));
		clientidd=(preferences.getString("N3", ""));
		 country.setVisibility(View.INVISIBLE);
		 state.setVisibility(View.INVISIBLE);
		 clubname.setVisibility(View.INVISIBLE);
		 city.setVisibility(View.INVISIBLE);
		
			progress3.setVisibility(View.INVISIBLE);

		 
		 search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if(clubid.length() > 0)
				 {
						
					 progress.setMessage("Please wait while Searching... ");
				     progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
				     progress.setIndeterminate(true);
				     progress.show();
				     clubidd=clubid.getText().toString();
				 	Search();
		        }
				 else
			        {
						
			            Toast.makeText(SecondNextreg1.this,"Please enter All The Details ", Toast.LENGTH_LONG).show();
			        }
				
				
			

			 
			}
		});
		 Register.setOnClickListener(new OnClickListener() {
				
			 
				@Override
				public void onClick(View arg0) {
					Save_Profile();
				}
				});
				
		}

/////////////////// *** Close OnCreateMethod *** ///////////////////////////		
	
	private void Search() {                                //search method for clubid
		// TODO Auto-generated method stub
		
		
			new Thread()
			{
				@Override
				public void run()
				{
			   
				try
					 {  
					
						httpclient1=new DefaultHttpClient();
		                httppost1= new HttpPost("http://anythinginfotech.in/Android/club/reg_match_clubid.php");
		                nameValuePairs1 = new ArrayList<NameValuePair>(1);
			            nameValuePairs1.add(new BasicNameValuePair("club_id",clubidd));
			            httppost1.setEntity(new UrlEncodedFormEntity(nameValuePairs1));
		                ResponseHandler<String> responseHandler = new BasicResponseHandler();
		                response_string1 = httpclient1.execute(httppost1, responseHandler);
		                System.out.println("Response2 : " + response_string1);
		           //     Toast.makeText(getApplicationContext(), response_string1, 70000).show();
		                JSONArray array1=new JSONArray(response_string1);
		                Log.e("u",response_string1);
		                JSONObject DATA=null;
		       for(int i=0;i<array1.length();i++)
	          			{
	        	   			DATA=array1.getJSONObject(i);
	         	   			Status=DATA.getString("status");
	         	   		Message=DATA.getString("message");
	         	   		if (Status.equals("Ok")){
	         	   		//n=DATA.getString("user");
	         	   		progress.cancel();
	         	   		countryy = DATA.getString("country");
	         	   		statee= DATA.getString("state");
	         	   		cityy= DATA.getString("city");
	         	   		clubnam = DATA.getString("club_name");
	         	 
	         	   		}
	         	   		
	         	   					}
	         	 runOnUiThread(new Runnable()
	         	 	{
		                public void run() 
		                {
		                	
		                
	         		country.setText(countryy);
	         		state.setText(statee);
	         		city.setText(cityy);
	         		clubname.setText(clubnam);
	         	
	         		country.setVisibility(View.VISIBLE);
	         		country.setEnabled(false);
	         		state.setVisibility(View.VISIBLE);
	         		state.setEnabled(false);
	         		city.setVisibility(View.VISIBLE);
	         		country.setEnabled(false);
	         		clubname.setVisibility(View.VISIBLE);
	         		country.setEnabled(false);
	         		

		                }
		            });
	               }
				catch(Exception e)
				{
		            System.out.println("Exception : " + e.getMessage());
		        }
				}
			}.start();
	   	}

		
		 
		 

	 private void Save_Profile() {
		 
	

			new Thread() {
					@Override
					public void run() { 
						if(clubid.length() > 0 && city.length() > 0 && country.length() > 0 && clubname.length() > 0 )
			        
								
{	country1 = country.getText().toString();   

							city1 = city.getText().toString();   
							 clubidd=clubid.getText().toString();
						 	clubidd1 = clubidd;
			                 
			              name1= clubname.getText().toString();
			              	


	runOnUiThread(new Runnable() {
	   
	    	public void run() {
				progress3.setVisibility(View.VISIBLE);
		    	Register.setVisibility(View.INVISIBLE);
	    }
	});

HttpClient client = new DefaultHttpClient();
String postURL = ("http://132connect.com/club/user_reg.php");
HttpPost post = new HttpPost(postURL);
try {
String[] c = new String[] {
country1,city1,clubidd1,name1,con,nam,pos,pass,maill
};



     
     List<NameValuePair> pairs = new ArrayList<NameValuePair>(1);

     pairs.add(new BasicNameValuePair("country", country1));
     pairs.add(new BasicNameValuePair("city", city1));
 
     pairs.add(new BasicNameValuePair("club_name", name1));
     pairs.add(new BasicNameValuePair("club_id", clubidd1));
     pairs.add(new BasicNameValuePair("mail", maill));
     pairs.add(new BasicNameValuePair("phone", con));
     pairs.add(new BasicNameValuePair("pwd", pass));
     pairs.add(new BasicNameValuePair("job_postion", pos));
     pairs.add(new BasicNameValuePair("user_name", nam));
     pairs.add(new BasicNameValuePair("user_id", clientidd));
     UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
     post.setEntity(uefe);
	
try{
 HttpResponse response = client.execute(post);
 
  resEntity = response.getEntity();
  content1 = EntityUtils.toString(resEntity);
}  catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println(content1);
Log.e("gju", content1);
// System.out.println("Response : " + con);
JSONArray array=new JSONArray(content1);
JSONObject DATA=null;
for(int i=0;i<array.length();i++)
{
DATA=array.getJSONObject(0);
status1=DATA.getString("status");
message1=DATA.getString("message");
 
 
}
runOnUiThread(new Runnable() {
 public void run() {
 	//progress2.cancel();
 	Toast.makeText(getApplicationContext(),
	            message1, Toast.LENGTH_LONG).show();
 	progress3.setVisibility(View.INVISIBLE);
 	Register.setVisibility(View.VISIBLE);
 	
 	if(status1.equals("SUCCESS")){
 		 Intent i= new Intent(getApplicationContext(),Login1.class);
			 startActivity(i); 
			 finish();
 	}
 }
});


} catch (UnsupportedEncodingException uee) {
 uee.printStackTrace();
} catch (JSONException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}  
}
	 else
     {
		 runOnUiThread(new Runnable() {
			    public void run() {
			    	Toast.makeText(getApplicationContext(),
			    			"Please Fill All  The Details", Toast.LENGTH_LONG).show();
			    }
			}); 

     }


}
}.start();




	 }
}

/////////////////// *** Close Class *** ///////////////////////////	