package nl.mprog.projects.npuzzle10385827;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

// This class shows us the pictures we can choose to play with
public class ImageActivity extends ListActivity {

	// Pictures i want to use of the folder drawable-mpdi.

	Integer[] imgid = { R.drawable.assassin, R.drawable.smile, R.drawable.man,
			R.drawable.daffy, R.drawable.falout, R.drawable.headphones };

	int difficulty;
	boolean newgame;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);

		// Importing data sent from other activities
		Bundle extras = this.getIntent().getExtras();
		difficulty = extras.getInt("difficulty");
		newgame = extras.getBoolean("newgame");

		// Making an adapter for a listview, and give this adapter the variable
		// imigid
		CustomListAdapter adapter = new CustomListAdapter(this, imgid);
		setListAdapter(adapter);
	}

	// This function determines what happens when one clicks on items within
	// the listview, it saves specific data of the clicked image and sent it
	// to the GameActivity class.
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent intent0 = new Intent(this, GameActivity.class);
		intent0.putExtra("Image", imgid[position]);
		intent0.putExtra("difficulty", difficulty);
		intent0.putExtra("newgame", newgame);
		startActivity(intent0);
		finish();

	}

}
