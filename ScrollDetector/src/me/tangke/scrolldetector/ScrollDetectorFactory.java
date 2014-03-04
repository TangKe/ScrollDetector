package me.tangke.scrolldetector;

import android.view.View;

/**
 * Factory interface for developer the define your own {$link
 * {@link ScrollDetector}
 * 
 * @author Tank
 * 
 */
public interface ScrollDetectorFactory {
	public <T extends View> ScrollDetector<T> newScrollDetector(T view);
}
