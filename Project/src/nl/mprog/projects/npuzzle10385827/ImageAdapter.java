package nl.mprog.projects.npuzzle10385827;

import java.util.ArrayList;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

// This class is an adapter for the gridview in GameActivity
public class ImageAdapter extends BaseAdapter {

	private ArrayList<Bitmap> crops;
	private ArrayList<Integer> ID;
	private Context mContext;

	public ImageAdapter(Context c, ArrayList<Bitmap> crops,
			ArrayList<Integer> ID) {
		mContext = c;
		this.crops = crops;
		this.ID = ID;
	}

	public int getCount() {
		return crops.size();
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	// Create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView imageView;
		if (convertView == null) { // if it's not recycled, initialize some
									// attributes
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
			imageView.setPadding(8, 8, 8, 8);
		} else {
			imageView = (ImageView) convertView;
		}
		
		// This step is important! It actually sets all bitmaps of 'crops' on the right
		// position and sets the right tags on these bitmaps. With Invalidatemoves(), I
		// reset the ImageAdapter with a 'new' crops/ID array, which results in a new
		// gridview
		imageView.setImageBitmap(crops.get(position));
		imageView.setTag((ID.get(position)));
		return imageView;
	}
}
