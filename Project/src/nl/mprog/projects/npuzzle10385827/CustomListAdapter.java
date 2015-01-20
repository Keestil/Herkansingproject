package nl.mprog.projects.npuzzle10385827;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

//This class is just an adapter for our listview in ImageActivity
public class CustomListAdapter extends BaseAdapter {

	private Context context;
	private Integer[] imgid;

	//Defining the imported data from ImageActivity
	public CustomListAdapter(Context context, Integer[] imgid) {
		
		this.context = context;
		this.imgid = imgid;
	}

	//This method shows us the images
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		
		ImageView imageView = new ImageView(context);
		imageView.setImageResource(imgid[position]);
		return imageView;
	}

	//Counts the elements of our listview
	@Override
	public int getCount() {
		return imgid.length;
	}

	
	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	};
}