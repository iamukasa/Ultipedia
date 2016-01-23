package com.amusoft.ultipedialite;




import android.content.Intent;
import android.os.Bundle;
import android.widget.ScrollView;

public class Utilhelp extends Quiz{
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_util_help);
		
		
	}
	
	
	public void onBackPressed() {
		Utilhelp.this.finish();

		final Intent i = new Intent(getApplicationContext(), UtilMenu.class);
		startActivity(i);

	} 

}
