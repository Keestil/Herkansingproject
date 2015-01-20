package nl.mprog.projects.npuzzle10385827;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

// This class is just a boring congrats-screen nothing special
public class CongratsActivity extends ActionBarActivity implements OnClickListener {
	
	SharedPreferences data;
	int moves;
	boolean game;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_congrats);
		
		// Importing data from other activity's.
		Bundle extras = this.getIntent().getExtras();
		moves = extras.getInt("Moves");
		
		// Making textviews and buttons.
		TextView mTextField = (TextView)findViewById(R.id.moves);
		mTextField.setText("You needed " + moves + " moves");
		Button menu_button = (Button) findViewById(R.id.menubutton);
		menu_button.setOnClickListener(this);		
		
		// Making sure the 'Resume' button disappears in MainActivity
		data = getSharedPreferences("savedstate", 0);
		SharedPreferences.Editor editor0 = data.edit();
		editor0.putBoolean("game", false);
		editor0.commit();
	}
	
	// Function that sends you back to main if button is clicked
	public void onClick(View v){
		switch(v.getId()){
			case R.id.menubutton:
				Intent intent1 = new Intent(this, MainActivity.class);
				startActivity(intent1);
				break;					
		}	
	}
}

