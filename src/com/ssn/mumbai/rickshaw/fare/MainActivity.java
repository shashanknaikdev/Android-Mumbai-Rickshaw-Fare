package com.ssn.mumbai.rickshaw.fare;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;

import android.app.ProgressDialog;
import android.app.TabActivity;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends TabActivity {

	//initialize DataBaseHelper object
	DataBaseHelper myDbHelper = new DataBaseHelper(this);
	
	ProgressDialog mProgress;
    
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        //Setting the TabHost layout
        TabHost tabHost=(TabHost)findViewById(android.R.id.tabhost);
    	tabHost.setup();
    	
    	TabSpec spec1=tabHost.newTabSpec("Tab 1");
    	spec1.setContent(R.id.tab1);
    	spec1.setIndicator("FARE");
    	TabSpec spec2=tabHost.newTabSpec("Tab 2");
    	spec2.setIndicator("COMPLAINT");
    	spec2.setContent(R.id.tab2);
    	TabSpec spec3=tabHost.newTabSpec("Tab 3");
    	spec3.setIndicator("ABOUT");
    	spec3.setContent(R.id.tab3);
    	tabHost.addTab(spec1);
    	tabHost.addTab(spec2);
    	tabHost.addTab(spec3);
    	
    	
    	//ADDING THE ADS
    	
    	
    /*	
    	try{
    		
    		
    	HttpClient httpClient = new DefaultHttpClient();
    	HttpConnectionParams.setConnectionTimeout(httpClient.getParams(),10000);
    	HttpConnectionParams.setSoTimeout(httpClient.getParams(),10000);
    	HttpPost httpPost = new HttpPost(url);  
    	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();  
    	nameValuePairs.add(new BasicNameValuePair("motorvehicleno", "MH-02 1234"));  
    	nameValuePairs.add(new BasicNameValuePair("Vehicle_Type", "autorickshaw"));
    	nameValuePairs.add(new BasicNameValuePair("dateofOccurrence", "12/12/12"));
    	nameValuePairs.add(new BasicNameValuePair("placeofOccurrence", "mumbai"));
    	nameValuePairs.add(new BasicNameValuePair("Nature_of_Complaint", "Indecentbehaviour"));
    	nameValuePairs.add(new BasicNameValuePair("AnyOtherComplaintmsg", "testing"));
    	nameValuePairs.add(new BasicNameValuePair("date", "12/12/12"));
    	nameValuePairs.add(new BasicNameValuePair("complaintdetails", "name and address")); 
    	nameValuePairs.add(new BasicNameValuePair("email", "abc@xyz.com")); 
    	nameValuePairs.add(new BasicNameValuePair("mob", "1234567890")); 
    	// etc...
    	
    	
    		httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs)); 
        	HttpResponse response = httpClient.execute(httpPost);
        	BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        	String data;  
            while((data = br.readLine()) != null)   
            {  
                //data = br.readLine( );                                       
                Log.v("SHASHANK","SHASHANK "+data);  
            }                   
    	}
    	catch(Exception e)
    	{
    		
    	}
    	*/
    	
    	/*
    	final WebView myWebView=(WebView)findViewById(R.id.complaint);
    	WebSettings webSettings = myWebView.getSettings();
    	webSettings.setJavaScriptEnabled(true);
    	webSettings.setBuiltInZoomControls(true);
    	
    	myWebView.loadUrl("http://trafficpolicemumbai.org/Complaint_Auto_taxi_form.htm");
    		
    	//   final Activity MyActivity = this;
    	    myWebView.setWebChromeClient(new WebChromeClient() {
    	    public void onProgressChanged(WebView view, int progress)   
    	    {
    	        //Make the bar disappear after URL is loaded, and changes string to Loading...
    	    	
    	        MainActivity.this.setTitle("Loading...(Tab 2)");
    	        MainActivity.this.setProgress(progress * 100); //Make the bar disappear after URL is loaded

    	        // Return the app name after finish loading
    	        if(progress == 100)
    	            MainActivity.this.setTitle(R.string.app_name);
    	        

    	    }
    	    });
    	    
    	    myWebView.setWebViewClient(new WebViewClient() {
    	    	
    	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
    	            view.loadUrl(url);
    	            return true;
    	        }
    	    }
    	    );
    	
    	/*myWebView.setWebViewClient(new WebViewClient() {
			
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				mProgress=ProgressDialog.show(MainActivity.this,"loading","loading",true);
		        view.loadUrl(url);
			    return true;
			   }

			public void onPageStarted(WebView view, String url) {
				Log.v("SHASHANK","PAGE IS LOADING");
				mProgress=ProgressDialog.show(MainActivity.this,"loading","loading",true);
				//mProgress.show(MainActivity.this,"loading","loading",true);
	           }
		   public void onPageFinished(WebView view, String url) {
			   Log.v("SHASHANK","PAGE IS LOADED");
			   if(mProgress.isShowing())
			   {
			   mProgress.dismiss();
		       }
		   }
		}
		);
    	
    	*/
    		/*
    	getTabHost().setOnTabChangedListener(new OnTabChangeListener(){
    		
    	public void onTabChanged(String tabId) {
    		// TODO Auto-generated method stub
    		    int selectedTab = getTabHost().getCurrentTab();
    		    if(selectedTab==1)
    		    {
    	mProgress=ProgressDialog.show(MainActivity.this,"loading","loading",true);

    		    		
    		    }
    		 }
    	}
    	);
    	*/
    	//Setting the WebView object
    	
    	
    	//Initialize the Database
        try {
        	
         	myDbHelper.createDataBase();
         	
   	     } 
        catch (IOException ioe) {
        	
        	throw new Error("Unable to create database");
  		
         }
 
        try {
 
        	myDbHelper.openDataBase();
 		
        }
        catch(SQLException sqle){
 
        	throw sqle;
 
        }
 
               
   }
    
    //END OF ONCREATE()
    
    
    public void showProgress()
    {
    	mProgress = ProgressDialog.show(this, "Loading", "Please wait for a moment...");

    }
    
    //The following method is used to concat the strings of LEFTTEXT AND RIGHTTEXT
   public String getconcat()
    {
	    TextView lefttext=(TextView)findViewById(R.id.lefttext);
        String t1=lefttext.getText().toString();
    	TextView righttext=(TextView)findViewById(R.id.righttext);
       	String t2=righttext.getText().toString();
       	String t3=t1+"."+t2;
       	return t3;
    }
   
   //The following method RESETS the LEFTTEXT AND RIGHTTEXT
   public void reset(View view)
   {
	    TextView lefttext=(TextView)findViewById(R.id.lefttext);
   		TextView righttext=(TextView)findViewById(R.id.righttext);
   		TextView resultreg=(TextView)findViewById(R.id.resultreg);
   		TextView resultnight=(TextView)findViewById(R.id.resultnight);
   		lefttext.setText("1");
   		righttext.setText("00");
   		resultreg.setText("12.00");
   		resultnight.setText("15.00");
   	}
    
    public void callleftup(View view)
    {
    	TextView lefttext=(TextView)findViewById(R.id.lefttext);
    	TextView righttext=(TextView)findViewById(R.id.righttext);
        String leftstring=lefttext.getText().toString();
        String rightstring=righttext.getText().toString();
    	int leftint=Integer.parseInt(leftstring);
    	int rightint=Integer.parseInt(rightstring);
    	if(leftint==18&&rightint>20)
    	{
    		leftint=19;
    		rightint=20;
    		leftstring=String.valueOf(leftint);
			lefttext.setText(leftstring);
    		rightstring=String.valueOf(rightint);
        	righttext.setText(rightstring);
    	}
    	if(leftint<19){
    		leftint++;
    		leftstring=String.valueOf(leftint);
    		lefttext.setText(leftstring);
    	}
    	
    	String concat=getconcat(); //GETTING THE CONCAT STRING
    	String result[]=new String[3]; //INITIALIZING THE ARRAY OF STRINGS WHICH WILL RECIEVE THE VALUES OF "RESULTREG","RESULTNIGHT" AND "DISTANCE"
    	result=myDbHelper.calculate(concat);//RESULT OF CALCULATE STORED IN RESULT ARRAY
    	TextView resultreg=(TextView)findViewById(R.id.resultreg);//INITIALIZING "RESULTREG" AND
    	TextView resultnight=(TextView)findViewById(R.id.resultnight);//"RESULTNIGHT VIEWS
    	resultreg.setText(result[0]);//DISPLAY THE RESULTS
     	resultnight.setText(result[1]);
    	
    }
    public void callleftdown(View view)
    {
        TextView lefttext=(TextView)findViewById(R.id.lefttext);
        
    	String leftstring=lefttext.getText().toString();
    	int leftint=Integer.parseInt(leftstring);
    	if(leftint!=1)
    	{
    		leftint--;
        	leftstring=String.valueOf(leftint);
        	lefttext.setText(leftstring);
    	}
    	
    	String concat=getconcat();
    	String result[]=new String[3];
    	result=myDbHelper.calculate(concat);
    	TextView resultreg=(TextView)findViewById(R.id.resultreg);
    	TextView resultnight=(TextView)findViewById(R.id.resultnight);
    	resultreg.setText(result[0]);
    	resultnight.setText(result[1]);
    	   	
    }
    public void callrightup(View view)
    {
    	TextView righttext=(TextView)findViewById(R.id.righttext);
        TextView lefttext=(TextView)findViewById(R.id.lefttext);
        String leftstring=lefttext.getText().toString();
    	String rightstring=righttext.getText().toString();
    	int leftint=Integer.parseInt(leftstring);
    	int rightint=Integer.parseInt(rightstring);
    	if(leftint!=19)
    	{
    		if(rightint!=90)
    	
    		{rightint+=10;
    		rightstring=String.valueOf(rightint);
        	righttext.setText(rightstring);
    		}
    	else
    		{rightint=0;
    		rightstring=String.valueOf(rightint);
        	righttext.setText(rightstring+"0");
    		}
    	}
    	else
    	{
    		if(rightint==20)
    		{
    		}
    		else
    		{rightint+=10;
    		rightstring=String.valueOf(rightint);
        	righttext.setText(rightstring);
    		}
    			
    	}
    	
    	//calculate();
    	
    	String concat=getconcat();
    	String result[]=new String[3];
    	result=myDbHelper.calculate(concat);
    	TextView resultreg=(TextView)findViewById(R.id.resultreg);
    	resultreg.setText(result[0]);
    	TextView resultnight=(TextView)findViewById(R.id.resultnight);
    	resultnight.setText(result[1]);
    }
    public void callrightdown(View view)
    {
    	TextView righttext=(TextView)findViewById(R.id.righttext);
    	String rightstring=righttext.getText().toString();

        TextView lefttext=(TextView)findViewById(R.id.lefttext);
    
	String leftstring=lefttext.getText().toString();
    	int rightint=Integer.parseInt(rightstring);
    	
	
	int leftint=Integer.parseInt(leftstring);
	
    	
    	switch (rightint){  
    	  case 10:
          	righttext.setText("00");
    	 break;
    	  case 0:
    		  if(leftint==19)
    		  {
    			  rightint=20;
    		  }
    		  else
    		  {
    			  rightint=90;
    		  }
      		rightstring=String.valueOf(rightint);
          	righttext.setText(rightstring);
    	  break;
    	  default:
    		  rightint-=10;
      		rightstring=String.valueOf(rightint);
          	righttext.setText(rightstring);
    	  }
    	
    	//calculate();
    	
    	String concat=getconcat();
    	String result[]=new String[3];
    	result=myDbHelper.calculate(concat);
    	TextView resultreg=(TextView)findViewById(R.id.resultreg);
    	resultreg.setText(result[0]);
    	TextView resultnight=(TextView)findViewById(R.id.resultnight);
    	resultnight.setText(result[1]);
    }
    
    public void submitForm(View view)
    {
    	EditText motorvehicleno_1=(EditText) findViewById(R.id.motorvehicleno_1);
    	EditText motorvehicleno_2=(EditText) findViewById(R.id.motorvehicleno_2);
    	EditText dateofOccurrencevalue=(EditText) findViewById(R.id.dateofOccurrencevalue);
    	EditText placeofOccurrencevalue=(EditText) findViewById(R.id.placeofOccurrencevalue);
    	EditText fullnameAndAddress=(EditText) findViewById(R.id.fullNameAndAddress);
    	EditText emailid=(EditText) findViewById(R.id.emailId);
    	EditText phno=(EditText) findViewById(R.id.PhoneNumber);
    	RadioGroup RG=(RadioGroup) findViewById(R.id.Vehicle_Type_Group);
    	//RadioButton RB=(RadioButton) findViewById(R.id.Vehicle_type_Auto);
    	CheckBox refusedFare=(CheckBox) findViewById(R.id.RefusedFare);
    	CheckBox faultybrokenmeter=(CheckBox) findViewById(R.id.FaultyBrokenMeter);
    	CheckBox chargedexcess=(CheckBox) findViewById(R.id.ChargedExcess);
    	CheckBox indecent=(CheckBox) findViewById(R.id.indecentBehaviour);
    	
    	boolean checkvalue=false;
    	checkvalue=check();
    	
    	if(checkvalue)
    	{
    		String vehiclenumbersend=motorvehicleno_1.toString()+" "+motorvehicleno_2.toString();
    		int rgint=RG.getCheckedRadioButtonId();
    		RadioButton RBid=(RadioButton)findViewById(rgint);
    		String rgstring=RBid.getText().toString();
    		if (rgstring=="Auto")
    			rgstring="autorickshaw";
    		else
    			rgstring="taxi";
    		
    		String date=dateofOccurrencevalue.getText().toString();
    		String place=placeofOccurrencevalue.getText().toString();
    		String fname=fullnameAndAddress.getText().toString();
    		String email=emailid.getText().toString();
    		String phone=phno.getText().toString();
    	
    	String url="http://trafficpolicemumbai.org/complaintautotaxi.asp";
    	try
    	{
    	HttpClient httpClient = new DefaultHttpClient();
    	HttpConnectionParams.setConnectionTimeout(httpClient.getParams(),10000);
    	HttpConnectionParams.setSoTimeout(httpClient.getParams(),10000);
    	HttpPost httpPost = new HttpPost(url);  
    	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();  
    	nameValuePairs.add(new BasicNameValuePair("motorvehicleno", vehiclenumbersend));  
    	nameValuePairs.add(new BasicNameValuePair("Vehicle_Type", rgstring));
    	nameValuePairs.add(new BasicNameValuePair("dateofOccurrence", date));
    	nameValuePairs.add(new BasicNameValuePair("placeofOccurrence", place));
    	if(refusedFare.isChecked())
    		nameValuePairs.add(new BasicNameValuePair("Nature_of_Complaint", "refusedtoplydestination"));
    	if(faultybrokenmeter.isChecked())
    		nameValuePairs.add(new BasicNameValuePair("Nature_of_Complaint", "faultyworkingmeter"));
    	if(indecent.isChecked())
    		nameValuePairs.add(new BasicNameValuePair("Nature_of_Complaint", "Indecentbehaviour"));
    	if(chargedexcess.isChecked())
    		nameValuePairs.add(new BasicNameValuePair("Nature_of_Complaint", "excessfare"));
    	
    	//nameValuePairs.add(new BasicNameValuePair("Nature_of_Complaint", "Indecentbehaviour"));
    	//nameValuePairs.add(new BasicNameValuePair("AnyOtherComplaintmsg", "none"));
    	//nameValuePairs.add(new BasicNameValuePair("date", "12/12/12"));
    	nameValuePairs.add(new BasicNameValuePair("complaintdetails", fname)); 
    	nameValuePairs.add(new BasicNameValuePair("email", email)); 
    	nameValuePairs.add(new BasicNameValuePair("mob", phone)); 
    	// etc...
    	
    	/*
    	 * httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs)); 
        	HttpResponse response = httpClient.execute(httpPost);
        	
        	BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        	Toast.makeText(this, "Form Submitted",Toast.LENGTH_SHORT).show();
        	String data;  
            while((data = br.readLine()) != null)   
            {  
                //data = br.readLine( );                                       
                Log.v("SHASHANK","SHASHANK "+data);  
            }         
    	 */
    		httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs)); 
        	httpClient.execute(httpPost);
        	
        	
        	Toast.makeText(this, "Form Submitted",Toast.LENGTH_SHORT).show();
        	                   
    	}
    
    	catch(Exception e)
    	{
    		Toast.makeText(this, "Network Error: Check Data Connection",Toast.LENGTH_SHORT).show();
    	}
    	}
    }
    
    
    public boolean check()
    {
    	EditText motorvehicleno_1=(EditText) findViewById(R.id.motorvehicleno_1);
    	EditText motorvehicleno_2=(EditText) findViewById(R.id.motorvehicleno_2);
    	EditText dateofOccurrencevalue=(EditText) findViewById(R.id.dateofOccurrencevalue);
    	EditText placeofOccurrencevalue=(EditText) findViewById(R.id.placeofOccurrencevalue);
    	EditText fullnameAndAddress=(EditText) findViewById(R.id.fullNameAndAddress);
    	EditText emailid=(EditText) findViewById(R.id.emailId);
    	EditText phno=(EditText) findViewById(R.id.PhoneNumber);
    	RadioGroup RG=(RadioGroup) findViewById(R.id.Vehicle_Type_Group);
    	//RadioButton RB=(RadioButton) findViewById(R.id.Vehicle_type_Auto);
    	CheckBox refusedFare=(CheckBox) findViewById(R.id.RefusedFare);
    	CheckBox faultybrokenmeter=(CheckBox) findViewById(R.id.FaultyBrokenMeter);
    	CheckBox chargedexcess=(CheckBox) findViewById(R.id.ChargedExcess);
    	CheckBox indecent=(CheckBox) findViewById(R.id.indecentBehaviour);
    	
    	int flag=0;
    	int vehicleno_1=5;
    	int vehicleno_2=5;
    	
    	
    	String vehicleno1=motorvehicleno_1.getText().toString();
    	String vehicleno2=motorvehicleno_2.getText().toString();
    	
    	
    	
    	
    	String dateofoccurence=dateofOccurrencevalue.getText().toString();
    	String place=placeofOccurrencevalue.getText().toString();
    	String nameandaddress=fullnameAndAddress.getText().toString();
    	String email=emailid.getText().toString();
    	String phnumber=phno.getText().toString();
    	
    
    	//CONTINUE HERE
    	
    	String error="";
    	
    	if(dateofoccurence.length()==0||place.length()==0||nameandaddress.length()==0||phnumber.length()==0||email.length()==0||vehicleno1.length()==0||vehicleno2.length()==0)
    	{
    	
    		flag=1;
    		Toast.makeText(this, "Fill all the fields",Toast.LENGTH_SHORT).show();
    	}	
    		
    	else // ATLEAST ALL FIELDS ARE FILLED
    	{	
    		vehicleno_1=Integer.parseInt(vehicleno1);
    	vehicleno_2=Integer.parseInt(vehicleno2);
    	if(vehicleno_1>3||vehicleno1.length()<2)
		{flag=1;
	    //Toast.makeText(this, "Check the vehicle number",Toast.LENGTH_SHORT).show();
		error=error+" Check the vehicle number \n";
		
		}
    	int pos_at=email.indexOf(64);
    	int pos_dot=email.indexOf(46);
    	if (pos_at==-1||pos_at==0||pos_dot==-1||pos_dot-pos_at<2||email.length()-pos_dot<2)
    	{flag=1;
    	 error=error+" Check email ID";
	   // Toast.makeText(this, "Enter valid email",Toast.LENGTH_SHORT);
    	}
    	}
    	
    	
    	
    	
    	   	
    	if(!refusedFare.isChecked()&&!faultybrokenmeter.isChecked()&&!chargedexcess.isChecked()&&!indecent.isChecked())
    		{flag=1;
    	    //Toast.makeText(this, "Check Nature Of Complaint",Toast.LENGTH_SHORT);
    	    error=error+" Check atleast one Nature Of Complaint";
    		}
    	
    	    	
    	
    	
    	
    	
    	
    		
    	
    		if(flag==0)
    	return true;
    		else 
    		{
    			if(error!="")
    			{Toast.makeText(this,error,Toast.LENGTH_SHORT).show();}
      
    			return false;
        
    		}
    }
    
    
    public void clearForm(View view)
    {
    	EditText motorvehicleno_1=(EditText) findViewById(R.id.motorvehicleno_1);
    	EditText motorvehicleno_2=(EditText) findViewById(R.id.motorvehicleno_2);
    	EditText dateofOccurrencevalue=(EditText) findViewById(R.id.dateofOccurrencevalue);
    	EditText placeofOccurrencevalue=(EditText) findViewById(R.id.placeofOccurrencevalue);
    	EditText fullnameAndAddress=(EditText) findViewById(R.id.fullNameAndAddress);
    	EditText emailid=(EditText) findViewById(R.id.emailId);
    	EditText phno=(EditText) findViewById(R.id.PhoneNumber);
    	RadioGroup RG=(RadioGroup) findViewById(R.id.Vehicle_Type_Group);
    	//RadioButton RB=(RadioButton) findViewById(R.id.Vehicle_type_Auto);
    	CheckBox refusedFare=(CheckBox) findViewById(R.id.RefusedFare);
    	CheckBox faultybrokenmeter=(CheckBox) findViewById(R.id.FaultyBrokenMeter);
    	CheckBox chargedexcess=(CheckBox) findViewById(R.id.ChargedExcess);
    	CheckBox indecent=(CheckBox) findViewById(R.id.indecentBehaviour);
    	
    	motorvehicleno_1.setText("");
    	motorvehicleno_2.setText("");
    	dateofOccurrencevalue.setText("");
    	placeofOccurrencevalue.setText("");
    	fullnameAndAddress.setText("");
    	emailid.setText("");
    	phno.setText("");
    	RG.check(R.id.Vehicle_type_Auto);
    	refusedFare.setChecked(false);
    	faultybrokenmeter.setChecked(false);
    	chargedexcess.setChecked(false);
    	indecent.setChecked(false);
    	
    }
    
   
   /*
        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.activity_main, menu);
   return true;
    }
   
   */
}

  