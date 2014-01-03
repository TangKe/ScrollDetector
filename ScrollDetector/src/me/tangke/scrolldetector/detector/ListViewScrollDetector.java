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
