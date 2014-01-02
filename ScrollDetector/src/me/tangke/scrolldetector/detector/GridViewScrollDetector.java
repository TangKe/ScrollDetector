package me.tangke.scrolldetector.detector;

import me.tangke.scrolldetector.ScrollDetector;
import android.widget.GridView;
import android.widget.ListAdapter;

/**
 * Scroll detect impl for @{link GridView}
 * 
 * @author Tank
 * 
 */
public class GridViewScrollDetector implements ScrollDetector<GridView> {

	@Override
	public boolean detectLeftScrollable(GridView view) {
		return false;
	}

	@Override
	public boolean detectRightScrollable(GridView view) {
		return false;
	}

	@Override
	public boolean detectUpScrollable(GridView view) {
		final ListAdapter adapter = view.getAdapter();
		if (null == adapter || 0 == adapter.getCount()) {
			return false;
		}

		return !(adapter.getCount() - 1 == view.getLastVisiblePosition() && view
				.getChildAt(view.getChildCount() - 1).getBottom() <= view
				.getHeight());
	}

	@Override
	public boolean detectDownScrollable(GridView view) {
		final ListAdapter adapter = view.getAdapter();
		if (null == adapter || 0 == adapter.getCount()) {
			return false;
		}

		return !(view.getFirstVisiblePosition() == 0 && view.getChildAt(0)
				.getTop() >= 0);
	}

}
