package me.tangke.scrolldetectorsample.sample;

import me.tangke.scrolldetectorsample.R;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class GridViewScrollDetectorActivity extends BaseScrollDetectorActivity {
	private GridView mGridView;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_grid_view);
	}

	@Override
	public void onContentChanged() {
		super.onContentChanged();
		mGridView = (GridView) findViewById(R.id.target);
		mGridView.setAdapter(ArrayAdapter.createFromResource(this,
				R.array.data, android.R.layout.simple_list_item_1));
	}
}
