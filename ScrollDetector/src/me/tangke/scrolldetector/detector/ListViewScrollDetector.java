package me.tangke.scrolldetector.detector;

import me.tangke.scrolldetector.ScrollDetector;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Scroll detect impl for @{link ListView}
 * 
 * @author Tank
 * 
 */
public class ListViewScrollDetector implements ScrollDetector<ListView> {

	@Override
	public boolean detectLeftScrollable(ListView view) {
		return false;
	}

	@Override
	public boolean detectRightScrollable(ListView view) {
		return false;
	}

	@Override
	public boolean detectUpScrollable(ListView view) {
		final ListAdapter adapter = view.getAdapter();
		if (null == adapter || 0 == adapter.getCount()) {
			return false;
		}

		return !(adapter.getCount() - 1 == view.getLastVisiblePosition() && view
				.getChildAt(view.getChildCount() - 1).getBottom() <= view
				.getHeight());
	}

	@Override
	public boolean detectDownScrollable(ListView view) {
		final int childCount = view.getChildCount();
		if (0 == childCount) {
			return false;
		}

		return !(0 == view.getFirstVisiblePosition() && view.getChildAt(0)
				.getTop() >= 0);
	}

}
