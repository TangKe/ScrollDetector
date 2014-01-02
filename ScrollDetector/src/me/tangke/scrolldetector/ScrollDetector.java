package me.tangke.scrolldetector;

import android.view.View;

/**
 * 
 * @author Tank
 * 
 * @param <T>
 */
public interface ScrollDetector<T extends View> {
	public boolean detectLeftScrollable(T view);

	public boolean detectRightScrollable(T view);

	public boolean detectUpScrollable(T view);

	public boolean detectDownScrollable(T view);
}
