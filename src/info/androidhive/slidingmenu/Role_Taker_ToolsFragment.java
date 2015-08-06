package info.androidhive.slidingmenu;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import info.androidhive.slidingmenuclient.R;

/////////////////// *** Start  Class *** ///////////////////////////

public class Role_Taker_ToolsFragment extends Fragment {
	
/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
	Button evaluator,gramarrian;
	public Role_Taker_ToolsFragment(){}
	
	
/////////////////// *** Close  Variable Declaration *** ///////////////////////////	
	
/////////////////// *** Start OnCreateMethod *** ///////////////////////////	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.role_taker_tools, container, false);
        evaluator=(Button)rootView.findViewById(R.id.evaluator);
        gramarrian=(Button)rootView.findViewById(R.id.grammarian);
		evaluator.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent in =new Intent(getActivity(),Evaluator.class);
			startActivity(in);
			}
		});
		
gramarrian.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			Intent in =new Intent(getActivity(),Gramarrian.class);
			startActivity(in);
			}
		});
        return rootView;
    }
	
/////////////////// *** Close OnCreateMethod *** ///////////////////////////			
	
}
/////////////////// *** Close Class *** ///////////////////////////	
