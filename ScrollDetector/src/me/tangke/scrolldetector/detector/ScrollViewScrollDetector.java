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
