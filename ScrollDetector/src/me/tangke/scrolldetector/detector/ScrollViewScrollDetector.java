package me.tangke.scrolldetector.detector;

import me.tangke.scrolldetector.ScrollDetector;
import android.view.View;
import android.widget.ScrollView;

/**
 * Scroll detect impl for @{link ScrollView}
 * 
 * @author Tank
 * 
 */
public class ScrollViewScrollDetector implements ScrollDetector<ScrollView> {

	@Override
	public boolean detectLeftScrollable(ScrollView view) {
		return false;
	}

	@Override
	public boolean detectRightScrollable(ScrollView view) {
		return false;
	}

	@Override
	public boolean detectUpScrollable(ScrollView view) {
		final int childCount = view.getChildCount();
		if (0 == childCount) {
			return false;
		}

		View child = view.getChildAt(0);

		return view.getScrollY() + view.getHeight() < child.getHeight();
	}

	@Override
	public boolean detectDownScrollable(ScrollView view) {
		return view.getScrollY() > 0;
	}

}
