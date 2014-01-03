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

import android.view.View;

/**
 * This class provide scroll detect features
 * 
 * @author Tank
 * 
 * @param <T>
 *            the type of view wrapped
 */
public class Scrollable<T extends View> {
	private T mView;
	private ScrollDetector<T> mDetector;

	Scrollable(T view, ScrollDetector<T> detector) {
		mView = view;
		mDetector = detector;
	}

	void setScrollDetector(ScrollDetector<T> detector) {
		mDetector = detector;
	}

	public T getDetectView() {
		return mView;
	}

	public boolean canScrollLeft() {
		return mDetector.detectLeftScrollable(mView);
	}

	public boolean canScrollRight() {
		return mDetector.detectRightScrollable(mView);
	}

	public boolean canScrollUp() {
		return mDetector.detectUpScrollable(mView);
	}

	public boolean canScrollDown() {
		return mDetector.detectDownScrollable(mView);
	}
}
