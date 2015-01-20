package nl.mprog.projects.npuzzle10385827;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.content.SharedPreferences;

// This class represents the starting screen of the game and gives you
// a few options to click
public class MainActivity extends ActionBarActivity implements OnClickListener {

	SharedPreferences data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Making button 1,2 and 3
		Button start_button = (Button) findViewById(R.id.button1);
		start_button.setOnClickListener(this);
		Button difficulty_button = (Button) findViewById(R.id.button2);
		difficulty_button.setOnClickListener(this);
		Button resume_button = (Button) findViewById(R.id.button3);
		resume_button.setOnClickListener(this);

		// Here we check if the player has played a game, if that's the
		// case the player should be able to click 'Resume'
		data = getSharedPreferences("savedstate", 0);		
		boolean game = data.getBoolean("game", false);

		if (game == false) {
			resume_button.setVisibility(View.INVISIBLE);
		}
	}

	public void onClick(View v) {
		
		// Checking which button is clicked and giving it extra information for
		// the next activity
		switch (v.getId()) {
			case R.id.button1:
				int prefdifficulty = data.getInt("prefdifficulty", 1);
				Intent intent1 = new Intent(this, ImageActivity.class);
				intent1.putExtra("difficulty", prefdifficulty);
				intent1.putExtra("newgame", true);
				startActivity(intent1);
				break;

			case R.id.button2:
				Intent intent2 = new Intent(this, DifficultyActivity.class);
				intent2.putExtra("newgame", true);
				startActivity(intent2);
				break;

			case R.id.button3:
				Intent intent3 = new Intent(this, GameActivity.class);
				intent3.putExtra("newgame", false);
				startActivity(intent3);
				break;

			}
		}
	}
