package me.tangke.scrolldetectorsample.sample;

import me.tangke.scrolldetector.ScrollDetectors;
import me.tangke.scrolldetector.Scrollable;
import me.tangke.scrolldetectorsample.R;
import me.tangke.scrolldetectorsample.utils.ScrollDetectStringBuilder;
import me.tangke.scrolldetectorsample.widget.ScrollDetectView;
import me.tangke.scrolldetectorsample.widget.ScrollDetectView.OnScrollDetectListener;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class BaseScrollDetectorActivity extends FragmentActivity implements
		OnScrollDetectListener {
	private TextView mIndicator;
	private ScrollDetectView mDetectView;
	private View mView;

	@Override
	public void onContentChanged() {
		super.onContentChanged();
		mIndicator = (TextView) findViewById(R.id.indicator);
		mDetectView = (ScrollDetectView) findViewById(R.id.detect);
		mDetectView.setOnScrollDetectListener(this);
		mView = findViewById(R.id.target);
	}

	@Override
	public void onScrollDetect(MotionEvent event) {
		Scrollable<?> pager = ScrollDetectors.detect(mView);
		String scrollState = ScrollDetectStringBuilder.buildScrollState(this,
				pager);
		mIndicator.setText(scrollState);
	}
}
