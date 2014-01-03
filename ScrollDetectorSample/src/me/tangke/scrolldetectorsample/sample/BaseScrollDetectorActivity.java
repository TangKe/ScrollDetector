package me.tangke.scrolldetectorsample.sample;

import me.tangke.scrolldetector.ScrollDetectors;
import me.tangke.scrolldetector.Scrollable;
import me.tangke.scrolldetectorsample.R;
import me.tangke.scrolldetectorsample.utils.ScrollDetectStringBuilder;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

public class BaseScrollDetectorActivity extends FragmentActivity implements
		Runnable {
	private TextView mIndicator;
	private View mView;

	@Override
	public void onContentChanged() {
		super.onContentChanged();
		mIndicator = (TextView) findViewById(R.id.indicator);
		mView = findViewById(R.id.target);
		mView.postDelayed(this, 100);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mView.removeCallbacks(this);
	}

	@Override
	public final void run() {
		Scrollable<?> pager = ScrollDetectors.detect(mView);
		String scrollState = ScrollDetectStringBuilder.buildScrollState(this,
				pager);
		mIndicator.setText(scrollState);
		mView.postDelayed(this, 100);
	}
}
