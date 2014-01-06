package me.tangke.scrolldetector.detector;

import android.widget.Gallery;
import me.tangke.scrolldetector.ScrollDetector;

public class GalleryScrollDetector implements ScrollDetector<Gallery> {

	@Override
	public boolean detectLeftScrollable(Gallery view) {
		return false;
	}

	@Override
	public boolean detectRightScrollable(Gallery view) {
		return false;
	}

	@Override
	public boolean detectUpScrollable(Gallery view) {
		return false;
	}

	@Override
	public boolean detectDownScrollable(Gallery view) {
		return false;
	}

}
