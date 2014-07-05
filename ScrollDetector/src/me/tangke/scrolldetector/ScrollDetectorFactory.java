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
	public ScrollDetector newScrollDetector(View view);
}
