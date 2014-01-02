package me.tangke.scrolldetectorsample.sample;

import me.tangke.scrolldetectorsample.R;
import me.tangke.scrolldetectorsample.widget.BaseFragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

public class ViewPagerScrollDetectorActivity extends BaseScrollDetectorActivity {
	private ViewPager mPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_pager);
	}

	@Override
	public void onContentChanged() {
		super.onContentChanged();
		mPager = (ViewPager) findViewById(R.id.target);
		mPager.setAdapter(new BaseFragmentPagerAdapter(this,
				getSupportFragmentManager()));
	}

}
