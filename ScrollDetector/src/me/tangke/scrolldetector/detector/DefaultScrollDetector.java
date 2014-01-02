package me.tangke.scrolldetector.detector;

import me.tangke.scrolldetector.ScrollDetector;
import android.view.View;

/**
 * Default scroll detect impl for all non scrollable views
 * 
 * @author Tank
 * 
 */
public class DefaultScrollDetector implements ScrollDetector<View> {

	@Override
	public boolean detectLeftScrollable(View view) {
		return false;
	}

	@Override
	public boolean detectRightScrollable(View view) {
		return false;
	}

	@Override
	public boolean detectUpScrollable(View view) {
		return false;
	}

	@Override
	public boolean detectDownScrollable(View view) {
		return false;
	}

}