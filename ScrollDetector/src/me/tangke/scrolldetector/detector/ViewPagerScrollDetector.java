/* Copyright (c) 2011-2014 Tang Ke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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