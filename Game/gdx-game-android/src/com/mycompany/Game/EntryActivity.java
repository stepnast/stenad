package com.mycompany.Game;

    import android.content.Intent;
	import android.app.Activity;
	import android.os.Bundle;
	import android.view.View;
	import android.view.Window;
	import android.view.WindowManager;
public class EntryActivity extends Activity
{
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
			setContentView(R.layout.entry_menu_activity);

		}
	public void PlayEntry(View view){
		Intent intent=new Intent(this,MainActivity.class);
		startActivity(intent);
	}
}
