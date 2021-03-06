package com.example.oldultipedia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class UtilSettings extends QuizActivity{
	
	SharedPreferences mGameSettings;
	static final int DATE_DIALOG_ID = 0;
	static final int PASSWORD_DIALOG_ID = 1;
     static final int AVATAR_DIALOG_ID=2;
  public	Button pass,pickDate;
  static final int TAKE_AVATAR_CAMERA_REQUEST = 1;
  static final int TAKE_AVATAR_GALLERY_REQUEST = 2;
	protected void onCreate(Bundle savedInstanceState){
		
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_util_settings);
		mGameSettings =
				getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
		
				 final EditText usernameText =
						(EditText) findViewById(R.id.EnterUsername);
						
				 usernameText.setOnKeyListener(new View.OnKeyListener() {
						public boolean onKey(View v, int keyCode, KeyEvent event) {
						if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
						(keyCode == KeyEvent.KEYCODE_ENTER)) {
						String strUsernameToSave = usernameText.getText().toString();
						// TODO: Save Nickname setting (strNicknameToSave)
						Editor editor = mGameSettings.edit();
						editor.putString(GAME_PREFERENCES_USERNAME, strUsernameToSave);
						editor.commit();
						usernameText.setText(strUsernameToSave);
						
						return true;
						}
						return false;
						}
						});
						
			ImageButton ava=(ImageButton)findViewById(R.id.avatar);
			
			
			ava.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					showDialog(AVATAR_DIALOG_ID);
					
					
				}
			});
			
		
			
						
			final EditText emailText =
								(EditText) findViewById(R.id.enterEmail);
			emailText.setOnKeyListener(new View.OnKeyListener() {
								public boolean onKey(View v, int keyCode, KeyEvent event) {
								if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
								(keyCode == KeyEvent.KEYCODE_ENTER)) {
								String strEmailToSave = emailText.getText().toString();
								// TODO: Save Nickname setting (strNicknameToSave)
								Editor editor = mGameSettings.edit();
								editor.putString(GAME_PREFERENCES_EMAIL, strEmailToSave);
								editor.commit();
								emailText.setText(strEmailToSave);
								return true;
								}
								return false;
								}
								});
			
		 pass=(Button)findViewById(R.id.SetPassword);
		pass.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				showDialog(PASSWORD_DIALOG_ID);
				}
             });
		 
		pickDate = (Button) findViewById(R.id.SetDate);
		pickDate.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
		showDialog(DATE_DIALOG_ID);
		}
		});
	final Button save=(Button)findViewById(R.id.saveSett);
	save.setOnClickListener(new  OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method
			String username = usernameText.getText().toString();
			String emil=emailText.getText().toString();
			Editor editor = mGameSettings.edit();
			editor.putString(GAME_PREFERENCES_EMAIL,emil);
		     editor.putString(GAME_PREFERENCES_USERNAME, username);
		     editor.commit();
		     usernameText.setText(null);
		    emailText.setText(null);
		    usernameText.setText(username);
		    emailText.setText(emil);
		Toast.makeText(getApplicationContext(),"User Settings Saved",Toast.LENGTH_SHORT).show();
		UtilSettings.this.finish();
		 
		Intent i = new Intent(getApplicationContext(), UtilMenu.class);
		startActivity(i);
		}
	});
		
	
	}
	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case DATE_DIALOG_ID:
		// TODO: Return a DatePickerDialog here
			DatePickerDialog dateDialog =
			new DatePickerDialog(this,
			new DatePickerDialog.OnDateSetListener() {
			public void onDateSet(DatePicker view, int year,
			int monthOfYear, int dayOfMonth) {
			Time dateOfBirth = new Time();
			dateOfBirth.set(dayOfMonth, monthOfYear, year);
			long dtDob = dateOfBirth.toMillis(true);
			TextView dob =(TextView)findViewById(R.id.ShowDate);
			dob.setText(DateFormat
			.format("MMMM dd, yyyy", dtDob));
			Editor editor = mGameSettings.edit();
			editor.putLong(GAME_PREFERENCES_DOB, dtDob);
			editor.commit();
			}
			}, 0, 0, 0);
			return dateDialog;
		
		case PASSWORD_DIALOG_ID:
			LayoutInflater inflater =
			(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			final View layout =
			inflater.inflate(R.layout.password,
			(ViewGroup) findViewById(R.id.root));
			
			final EditText p1 =
					(EditText) layout.findViewById(R.id.enterPassword);
					final EditText p2 =
					(EditText) layout.findViewById(R.id.enterPassword2);
					final TextView error = 
							(TextView)layout.findViewById(R.id.eror);
					
					p2.addTextChangedListener(new TextWatcher() {
						@Override
						public void afterTextChanged(Editable s) {
						String strPass1 = p1.getText().toString();
						String strPass2 = p2.getText().toString();
						if (strPass1.equals(strPass2)) {
						 error.setText(R.string.settings_pwd_equal);
						}else{
						error.setText(R.string.settings_pwd_not_equal);
						}
						}

						@Override
						public void beforeTextChanged(CharSequence a,
								int b, int c, int d) {
							// TODO Auto-generated method stub
							
						}

						@Override
						public void onTextChanged(CharSequence a, int b,
								int c, int d) {
							// TODO Auto-generated method stub
							
						}

						
					});
					AlertDialog.Builder builder = new AlertDialog.Builder(this);
					builder.setView(layout);
					builder.setTitle(R.string.settings_button_pwd);
					builder.setPositiveButton(android.R.string.ok,
							new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
							TextView passwordInfo =
							(TextView) findViewById(R.id.ShowPassword);
							String strPassword1 = p1.getText().toString();
							String strPassword2 = p2.getText().toString();
							if (strPassword1.equals(strPassword2)) {
							Editor editor = mGameSettings.edit();
							editor.putString(GAME_PREFERENCES_PASSWORD,
							strPassword1);
							editor.commit();
							passwordInfo.setText(strPassword1);
							} else {
							Log.d(DEBUG_TAG, "Passwords do not match. "
							+ "Not saving. Keeping old password (if set).");
							}
							UtilSettings.this
							.removeDialog(PASSWORD_DIALOG_ID);
							}
							});
					builder.setNegativeButton(android.R.string.cancel,
							new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int whichButton) {
								UtilSettings.this
							.removeDialog(PASSWORD_DIALOG_ID);
							}
							});
					AlertDialog passwordDialog = builder.create();
					return passwordDialog;
		case AVATAR_DIALOG_ID:
			LayoutInflater inflater2 =
			(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			final View layout2 =
			inflater2.inflate(R.layout.avatar_picker,
			(ViewGroup) findViewById(R.id.chooseAva));
			final Button btnCamera=(Button)layout2.findViewById(R.id.camera);
			final Button btnGallery=(Button)layout2.findViewById(R.id.gallery);
					btnCamera.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Intent pictureIntent = new Intent(
									android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
									startActivityForResult(pictureIntent, TAKE_AVATAR_CAMERA_REQUEST);
									UtilSettings.this
									.removeDialog(AVATAR_DIALOG_ID);
							
							
							
						}
					});
				btnGallery.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent pickPhoto = new Intent(Intent.ACTION_PICK);
						pickPhoto.setType("image/*");
						startActivityForResult(pickPhoto, TAKE_AVATAR_GALLERY_REQUEST);
						UtilSettings.this
						.removeDialog(AVATAR_DIALOG_ID);
						
					}
				});
				
				AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
				builder2.setView(layout2);
				builder2.setTitle(R.string.settings_button_ava);
				builder2.setPositiveButton(android.R.string.ok,
						new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							
						UtilSettings.this
						.removeDialog(AVATAR_DIALOG_ID);
						
						}
						});
				
				builder2.setNegativeButton(android.R.string.cancel,
						new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int whichButton) {
							UtilSettings.this
						.removeDialog(AVATAR_DIALOG_ID);
						}
						});

				AlertDialog chooseDialog = builder2.create();
				return chooseDialog ;
	
	}
		return null;
		
		
	
	
}
	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
	super.onPrepareDialog(id, dialog);
	switch (id) {
	case DATE_DIALOG_ID:
	// Handle any DatePickerDialog initialization here
	DatePickerDialog dateDialog = (DatePickerDialog) dialog;
	int iDay, iMonth, iYear;
	// Check for date of birth preference
	if (mGameSettings.contains(GAME_PREFERENCES_DOB)) {
	// Retrieve Birth date setting from preferences
	long msBirthDate = mGameSettings.getLong(GAME_PREFERENCES_DOB, 0);
	Time dateOfBirth = new Time();
	dateOfBirth.set(msBirthDate);
	iDay = dateOfBirth.monthDay;
	iMonth = dateOfBirth.month;
	iYear = dateOfBirth.year;
	} else {
	Calendar cal = Calendar.getInstance();
	// Today�s date fields
	iDay = cal.get(Calendar.DAY_OF_MONTH);
	iMonth = cal.get(Calendar.MONTH);
	iYear = cal.get(Calendar.YEAR);
	}
	// Set the date in the DatePicker to the date of birth OR to the
	// current date
	dateDialog.updateDate(iYear, iMonth, iDay);
	return;
	}
	}
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch(requestCode) {
		case TAKE_AVATAR_CAMERA_REQUEST:
		if (resultCode == Activity.RESULT_CANCELED) {
		// Avatar camera mode was canceled.
		} else if (resultCode == Activity.RESULT_OK) {
		// TODO: HANDLE PHOTO TAKEN
			Bitmap cameraPic = (Bitmap) data.getExtras().get("data");
			saveAvatar(cameraPic);
		}
		break;
		case TAKE_AVATAR_GALLERY_REQUEST:
		if (resultCode == Activity.RESULT_CANCELED) {
		// Avatar gallery request mode was canceled.
		} else if (resultCode == Activity.RESULT_OK) {
		// TODO: HANDLE IMAGE CHOSEN
			Uri photoUri = data.getData();
			try {
				Bitmap galleryPic = Media.getBitmap(getContentResolver(), photoUri);
				saveAvatar(galleryPic);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		break;
		}
		}
private void saveAvatar(Bitmap avatar)
{
// TODO: Save the Bitmap as a local file called avatar.jpg
	String strAvatarFilename = "avatar.jpg";
	try {
		avatar.compress(CompressFormat.JPEG,
		100, openFileOutput(strAvatarFilename, MODE_PRIVATE));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
// TODO: Determine the Uri to the local avatar.jpg file
	
// TODO: Save the Uri path as a String preference
	Uri imageUri = Uri.fromFile(new File(getFilesDir(), strAvatarFilename));
// TODO: Update the ImageButton with the new image
	ImageButton ava=(ImageButton)findViewById(R.id.avatar);
	
	ava.setImageURI(imageUri);
	String curimg=imageUri.getPath().toString();
	
	Editor edit=mGameSettings.edit();
   edit.putString(GAME_PREFERENCES_AVATAR,curimg);
   edit.commit();
	
	
}

protected void onDestroy(){
	Log.d(DEBUG_TAG, "SHARED PREFERENCES");
	
	Log.d(DEBUG_TAG, "Username is: "
	+ mGameSettings.getString(GAME_PREFERENCES_USERNAME, "Not set"));
	Log.d(DEBUG_TAG, "Email is: "
	+ mGameSettings.getString(GAME_PREFERENCES_EMAIL, "Not set"));
	
			// We are not saving the password yet
			Log.d(DEBUG_TAG, "Password is: "
			+ mGameSettings.getString(GAME_PREFERENCES_PASSWORD, "Not set"));
			// We are not saving the date of birth yet
			Log.d(DEBUG_TAG, "DOB is: "
			+ DateFormat.format("MMMM dd, yyyy", mGameSettings.getLong(
					GAME_PREFERENCES_DOB, 0)));
	super.onDestroy();
	
}
public void onBackPressed(){
UtilSettings.this.finish();
Intent i = new Intent(getApplicationContext(), UtilMenu.class);
		startActivity(i);
		 
		 
	
}
protected void onResume(){
	super.onResume();
	mGameSettings.getString(GAME_PREFERENCES_USERNAME, null);
	mGameSettings.getString(GAME_PREFERENCES_EMAIL,null);
	if (mGameSettings.contains(GAME_PREFERENCES_AVATAR)){
		String img =mGameSettings.getString(GAME_PREFERENCES_AVATAR,null);
		Uri path=Uri.parse(img);
		ImageButton ava=(ImageButton)findViewById(R.id.avatar);
		ava.setImageURI(null);
		ava.setImageURI(path);
		
	}
	if(mGameSettings.contains(GAME_PREFERENCES_DOB)){
		long dtDob=mGameSettings.getLong(GAME_PREFERENCES_DOB,0);
		TextView dob =(TextView)findViewById(R.id.ShowDate);
		dob.setText(DateFormat
		.format("MMMM dd, yyyy", dtDob));
		
	}
	
	final EditText usernameText =
			(EditText) findViewById(R.id.EnterUsername);
	usernameText.setText(mGameSettings.getString(GAME_PREFERENCES_USERNAME, null));
	final EditText emailText =
			(EditText) findViewById(R.id.enterEmail);
	emailText.setText(mGameSettings.getString(GAME_PREFERENCES_EMAIL,null));
	
	TextView passwordInfo =
			(TextView) findViewById(R.id.ShowPassword);
	passwordInfo.setText(mGameSettings.getString(GAME_PREFERENCES_PASSWORD, null));
	

	
}

}
