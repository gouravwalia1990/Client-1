package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import info.androidhive.slidingmenuclient.R;

/////////////////// *** Start  Class *** ///////////////////////////

public class PagesFragment extends Fragment {
	
/////////////////// *** Start  Variable Declaration *** ///////////////////////////	
	
	public PagesFragment(){}
	

/////////////////// *** Close  Variable Declaration *** ///////////////////////////
	
/////////////////// *** Start OnCreateMethod *** ///////////////////////////	
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_pages, container, false);
         
        return rootView;
    }

/////////////////// *** Close OnCreateMethod *** ///////////////////////////
}

/////////////////// *** Close Class *** ///////////////////////////	