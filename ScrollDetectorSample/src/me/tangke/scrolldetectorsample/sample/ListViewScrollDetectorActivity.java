package me.tangke.scrolldetectorsample.sample;

import me.tangke.scrolldetectorsample.R;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewScrollDetectorActivity extends BaseScrollDetectorActivity {
	private ListView mListView;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_list_view);
	}

	@Override
	public void onContentChanged() {
		super.onContentChanged();
		mListView = (ListView) findViewById(R.id.target);
		mListView.setAdapter(ArrayAdapter.createFromResource(this,
				R.array.data, android.R.layout.simple_list_item_1));
	}
}
