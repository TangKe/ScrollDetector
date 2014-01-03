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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import me.tangke.scrolldetector.ScrollDetector;
import android.webkit.WebView;

/**
 * Scroll detect impl for @{link WebView}
 * 
 * @author Tank
 * 
 */
public class WebViewScrollDetector implements ScrollDetector<WebView> {
	private Method mComputeHorizontalScrollOffsetMethod;
	private Method mComputeHorizontalScrollRangeMethod;
	private Method mComputeVerticalScrollOffsetMethod;
	private Method mComputeVerticalScrollRangeMethod;

	public WebViewScrollDetector() {
		Class<WebView> webViewClazz = WebView.class;
		try {
			mComputeHorizontalScrollOffsetMethod = webViewClazz
					.getDeclaredMethod("computeHorizontalScrollOffset");
			mComputeHorizontalScrollOffsetMethod.setAccessible(true);
			mComputeHorizontalScrollRangeMethod = webViewClazz
					.getDeclaredMethod("computeHorizontalScrollRange");
			mComputeHorizontalScrollRangeMethod.setAccessible(true);
			mComputeVerticalScrollOffsetMethod = webViewClazz
					.getDeclaredMethod("computeVerticalScrollOffset");
			mComputeVerticalScrollOffsetMethod.setAccessible(true);
			mComputeVerticalScrollRangeMethod = webViewClazz
					.getDeclaredMethod("computeVerticalScrollRange");
			mComputeVerticalScrollRangeMethod.setAccessible(true);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean detectLeftScrollable(WebView view) {
		try {
			final int horizontalScrollOffset = (Integer) mComputeHorizontalScrollOffsetMethod
					.invoke(view);
			final int horizontalScrollRange = (Integer) mComputeHorizontalScrollOffsetMethod
					.invoke(view);
			return horizontalScrollOffset < horizontalScrollRange
					- view.getWidth();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean detectRightScrollable(WebView view) {
		return view.getScrollX() > 0;
	}

	@Override
	public boolean detectUpScrollable(WebView view) {
		try {
			final int verticalScrollOffset = (Integer) mComputeVerticalScrollOffsetMethod
					.invoke(view);
			final int verticalScrollRange = (Integer) mComputeVerticalScrollRangeMethod
					.invoke(view);
			return verticalScrollOffset < verticalScrollRange
					- view.getHeight();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean detectDownScrollable(WebView view) {
		return view.getScrollY() > 0;
	}

}
