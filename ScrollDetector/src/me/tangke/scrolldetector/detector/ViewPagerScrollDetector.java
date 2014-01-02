package me.tangke.scrolldetector.detector;

import me.tangke.scrolldetector.ScrollDetector;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Scroll detect impl for @{link ViewPager}
 * 
 * @author Tank
 * 
 */
public class ViewPagerScrollDetector implements ScrollDetector<ViewPager> {

	@Override
	public boolean detectLeftScrollable(ViewPager view) {
		PagerAdapter pagerAdapter = view.getAdapter();
		if (null == pagerAdapter || 0 == pagerAdapter.getCount()) {
			return false;
		}
		return view.getCurrentItem() < pagerAdapter.getCount() - 1;
	}

	@Override
	public boolean detectRightScrollable(ViewPager view) {
		PagerAdapter pagerAdapter = view.getAdapter();
		if (null == pagerAdapter || 0 == pagerAdapter.getCount()) {
			return false;
		}
		return view.getCurrentItem() > 0;
	}

	@Override
	public boolean detectUpScrollable(ViewPager view) {
		return false;
	}

	@Override
	public boolean detectDownScrollable(ViewPager view) {
		return false;
	}

}