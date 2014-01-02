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
