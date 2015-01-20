package nl.mprog.projects.npuzzle10385827;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.content.SharedPreferences;

public class DifficultyActivity extends ActionBarActivity implements
		OnClickListener {

	SharedPreferences data;
	boolean difficultycheck;
	boolean newgame;
	int resource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_difficulty);

		// Importing data from other activity's
		Bundle extras = this.getIntent().getExtras();
		newgame = extras.getBoolean("newgame");
		resource = extras.getInt("Image");
		
		// Making three difficultylevelbuttons
		Button easy_button = (Button) findViewById(R.id.easy);
		easy_button.setOnClickListener(this);
		Button medium_button = (Button) findViewById(R.id.medium);
		medium_button.setOnClickListener(this);
		Button hard_button = (Button) findViewById(R.id.hard);
		hard_button.setOnClickListener(this);

		// Boolean check to see if difficulty is being clicked in the menu of GameActivity
		// or in the difficultybutton of the MainActivity
		data = getSharedPreferences("savedstate", 0);		
		difficultycheck = data.getBoolean("difficultycheck", false);
	}

	public void onClick(View v) {
		
		// This step checks if we need to go to GameActivity or to ImageActivity
		// depending on which difficultybutton has been clicked! First we look
		// at what happens if one presses the difficultybutton in the menu of
		// GameActivity
		if (difficultycheck == true){
			switch (v.getId()) {
				case R.id.easy:
					dataGame(0);
					break;

				case R.id.medium:
					dataGame(1);
					break;

				case R.id.hard:
					dataGame(2);
					break;
			}
		} else {
			
			// Here we get the case that the difficulty-button in the MainActivity is
			// being pressed. Note that it is almost exactly the same, except the fact
			// that we jump to ImageActivity here instead of GameActivity
			switch (v.getId()) {
				case R.id.easy:
					dataMain(0);
					break;

				case R.id.medium:
					dataMain(1);
					break;

				case R.id.hard:
					dataMain(2);
					break;
			}
		}
	}
	
	// Function that stores data if difficulty clicked in Gameactivity
	private void dataGame(int i){
		Intent intent = new Intent(this, GameActivity.class);
		intent.putExtra("difficulty", i);
		intent.putExtra("Image", resource);
		intent.putExtra("newgame", newgame);
	
		// Here we put data in "savedstate" database so we can save
		// the players preferences. and put the difficultychekc back to
		// false so no errors will occur when pressing the difficultybutton
		// in Main
		SharedPreferences.Editor editor = data.edit();
		editor.putInt("prefdifficulty", i);
		editor.putBoolean("difficultycheck", false);
		editor.commit();
		startActivity(intent);
	}
	
	// Function that stores data if difficulty clicked in Mainactivity
	private void dataMain(int i){
		Intent intent = new Intent(this, ImageActivity.class);
		intent.putExtra("difficulty", i);
		intent.putExtra("newgame", newgame);

		// Here we put data in "savedstate" database so we can save
		// the players preferences.
		SharedPreferences.Editor editor = data.edit();
		editor.putInt("prefdifficulty", i);
		editor.commit();
		startActivity(intent);
	}
}