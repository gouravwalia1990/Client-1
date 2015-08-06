package info.androidhive.slidingmenu;

import info.androidhive.slidingmenuclient.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;





import android.widget.ListView;
import android.app.Dialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.sax.RootElement;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


/////////////////// *** Start  Class *** ///////////////////////////

public class View_MeetingFragment1 extends Fragment {
	
/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
	Button Edit;
	ProgressDialog pDialog;
	HttpPost httppost,httppost1;
	String response_string,response_string1,status1,message1; 
	StringBuffer buffer;
	HttpResponse response,response1;
	HttpClient httpclient,httpclient1;
	String parsedString = "";
	ArrayAdapter<String> mAdapter;	
	List<NameValuePair> nameValuePairs, nameValuePairs1;
	ListAdapter adapter;
	public View_MeetingFragment1(){}
	private static final String TAG_USER = "view_meeting";
	private static final String TAG_SENTFROM = "meeting name";
	private static final String TAG_DATE = "time date";
	private static final String TAG_AMOUNT1 = "word";
	ListView lv;
	View rootView;
	JSONArray line = null;
	ArrayList<HashMap<String, String>> contactList;
	

/////////////////// *** Close  Variable Declaration *** ///////////////////////////	
	
/////////////////// *** Start OnCreateMethod *** ///////////////////////////	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
         rootView = inflater.inflate(R.layout.view_meeting, container, false);
         
       lv=(ListView)rootView.findViewById(R.id.list_view_meeting);
        contactList = new ArrayList<HashMap<String, String>>();
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Please wait...");
		pDialog.setCancelable(true);
		pDialog.show();
      
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// getting values from selected ListItem
				
				String cost = ((TextView) view.findViewById(R.id.email))
						.getText().toString();
				String description = ((TextView) view.findViewById(R.id.mobile))
						.getText().toString();
				Toast.makeText(getActivity(), cost, 70000).show();
				Log.e("ud", description);
				
				// set the custom dialog
				
				final Dialog dialog = new Dialog(getActivity());
				dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				dialog.setContentView(R.layout.dialog);
				EditText meetingname = (EditText) dialog.findViewById(R.id.meeting);
				EditText time = (EditText) dialog.findViewById(R.id.time);
				dialog.show();
				Button create =(Button) dialog.findViewById(R.id.create);
				
				create.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				});


			}
		});

		new ProgressTask().execute();
        return rootView;
        
    }
	
/////////////////// *** Close OnCreateMethod *** ///////////////////////////		
	
	private class ProgressTask extends AsyncTask <Void,Void,Void>{
        @Override
        protected void onPreExecute(){
           
        }

        @Override
        protected Void doInBackground(Void... arg0) {
        	GeteData();
			return null;   
               
        }

        @Override
        protected void onPostExecute(Void result) {
          
        }
    }
	
	//start getedata to get the data from server
	private void GeteData() {
		// TODO Auto-generated method stub
		new Thread()
	{
		@Override
			public void run()
		{
	   
		try
			 {        
			
			
		
					httpclient1=new DefaultHttpClient();
	                httppost1= new HttpPost("http://anythinginfotech.in/Android/club/view_meeting.php");
	                nameValuePairs1 = new ArrayList<NameValuePair>();
	                httppost1.setEntity(new UrlEncodedFormEntity(nameValuePairs1));
	                response1=httpclient1.execute(httppost1);
	                ResponseHandler<String> responseHandler = new BasicResponseHandler();
	                response_string1 = httpclient1.execute(httppost1, responseHandler);
	                System.out.println("Response111 : " + response_string1);
	               Log.e("r1111", response_string1);
	               
	                  
	                if (response_string1 != null) {
	    				try {
	    					JSONObject jsonObj = new JSONObject(response_string1);
	    					
	    					// Getting JSON Array node
	    					line = jsonObj.getJSONArray(TAG_USER);

	    					
	    					for (int l = 0; l < line.length(); l++) {
	    						JSONObject c = line.getJSONObject(l);
	    						
	    						String sentfro = c.getString(TAG_SENTFROM);
	    						String dat = c.getString(TAG_DATE);
	    						String nk = c.getString(TAG_AMOUNT1);
	    						
	    					Log.e("gu",dat);
	    					Log.e("gu",nk);
	    					
	    						
	    						HashMap<String, String> contact = new HashMap<String, String>();

	    						
	    						contact.put(TAG_SENTFROM,  sentfro);
	    						contact.put(TAG_DATE, dat);
	    					
	    						contact.put(TAG_AMOUNT1, nk);
	    						
	    					}
	    					getActivity().runOnUiThread(new Runnable() {

	    		                @Override
	    		                public void run() {
	    		                	Setarray();
	    		                }
	    		            });
	    					
	    				} catch (JSONException e) {
	    					e.printStackTrace();
	    					
	    				}
	    			} else {
	    				Log.e("ServiceHandler", "Couldn't get any data from the url");
	    				
	    			}
			 

			 }
	                catch(Exception e)
			{
	            System.out.println("Exception : " + e.getMessage());
	           
	        }
			}

		

		
		
		}.start();
   
	

}
	
	//Set Array
	public void Setarray() {
		// TODO Auto-generated method stub
		
	
		if (pDialog.isShowing())
			pDialog.dismiss();
		adapter = new SimpleAdapter(
				getActivity(), contactList,
				R.layout.list_item3, new String[] {TAG_AMOUNT1,  TAG_SENTFROM, TAG_DATE}, new int[] { R.id.name,R.id.mobile,
						R.id.email });
        lv.setAdapter(adapter);
	
	}
}

/////////////////// *** Close Class *** ///////////////////////////	