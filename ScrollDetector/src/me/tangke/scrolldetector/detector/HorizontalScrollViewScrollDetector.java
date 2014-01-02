package me.tangke.scrolldetector.detector;

import me.tangke.scrolldetector.ScrollDetector;
import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * Scroll detect impl for @{link HorizontalScrollView}
 * 
 * @author Tank
 * 
 */
public class HorizontalScrollViewScrollDetector implements
		ScrollDetector<HorizontalScrollView> {

	@Override
	public boolean detectLeftScrollable(HorizontalScrollView view) {
		if (0 == view.getChildCount()) {
			return false;
		}

		View child = view.getChildAt(0);

		return view.getScrollX() + view.getWidth() < child.getWidth();
	}

	@Override
	public boolean detectRightScrollable(HorizontalScrollView view) {
		return view.getScrollX() > 0;
	}

	@Override
	public boolean detectUpScrollable(HorizontalScrollView view) {
		return false;
	}

	@Override
	public boolean detectDownScrollable(HorizontalScrollView view) {
		return false;
	}

}
