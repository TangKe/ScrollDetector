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
package me.tangke.scrolldetector;

import java.util.WeakHashMap;

import me.tangke.scrolldetector.detector.DefaultScrollDetector;
import me.tangke.scrolldetector.detector.GalleryScrollDetector;
import me.tangke.scrolldetector.detector.GridViewScrollDetector;
import me.tangke.scrolldetector.detector.HorizontalScrollViewScrollDetector;
import me.tangke.scrolldetector.detector.ListViewScrollDetector;
import me.tangke.scrolldetector.detector.ScrollViewScrollDetector;
import me.tangke.scrolldetector.detector.ViewPagerScrollDetector;
import me.tangke.scrolldetector.detector.WebViewScrollDetector;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.webkit.WebView;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.ScrollView;

/**
 * Provide detect impl for Android basic widgets
 * 
 * @author Tank
 * 
 */
public class ScrollDetectors {
	private final static WeakHashMap<Class<? extends View>, ScrollDetector<?>> sDetectorImples = new WeakHashMap<Class<? extends View>, ScrollDetector<?>>();
	private final static WeakHashMap<View, Scrollable<?>> sScrollableCaches = new WeakHashMap<View, Scrollable<?>>();
	private static ScrollDetectorFactory sFactory;

	/**
	 * 
	 * @param <T>
	 * @param view
	 * @return
	 */
	public static <T extends View> Scrollable<T> detect(T view) {
		if (null == view) {
			throw new NullPointerException(
					"The view which you want to checked can not be null");
		}

		ScrollDetector<T> scrollDetector = getScrollDetectorImpl(view);
		Scrollable scrollable = sScrollableCaches.get(view);
		if (null != scrollable && view == scrollable.getDetectView()) {
			// if the detector implement has been changed, we update the
			// Scrollable's ScrollDetector to the latest
			if (null != scrollDetector) {
				scrollable.setScrollDetector(scrollDetector);
			}
			return scrollable;
		}
		scrollable = new Scrollable<T>(view, scrollDetector);
		sScrollableCaches.put(view, scrollable);
		return scrollable;
	}

	public static void setScrollDetectorFactory(ScrollDetectorFactory factory) {
		sFactory = factory;
	}

	public static <T extends View> ScrollDetector<T> getScrollDetectorImpl(T v) {
		Class<? extends View> clazz = v.getClass();
		ScrollDetector imple = sDetectorImples.get(clazz);

		if (null != imple) {
			return imple;
		}

		if (v instanceof ViewPager) {
			imple = new ViewPagerScrollDetector();
		} else if (v instanceof HorizontalScrollView) {
			imple = new HorizontalScrollViewScrollDetector();
		} else if (v instanceof WebView) {
			imple = new WebViewScrollDetector();
		} else if (v instanceof ListView) {
			imple = new ListViewScrollDetector();
		} else if (v instanceof GridView) {
			imple = new GridViewScrollDetector();
		} else if (v instanceof ScrollView) {
			imple = new ScrollViewScrollDetector();
		} else if (v instanceof Gallery) {
			imple = new GalleryScrollDetector();
		} else if (null != sFactory) {
			imple = sFactory.newScrollDetector(v);
		}
		
		if (null == imple) {
			imple = new DefaultScrollDetector();
		}

		sDetectorImples.put(clazz, imple);
		return imple;
	}

}