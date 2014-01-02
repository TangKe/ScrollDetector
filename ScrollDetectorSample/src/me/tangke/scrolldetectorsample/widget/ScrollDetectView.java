package me.tangke.scrolldetectorsample.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class ScrollDetectView extends FrameLayout {
	public interface OnScrollDetectListener {
		public void onScrollDetect(MotionEvent event);
	}

	private OnScrollDetectListener mScrollDetectListener;

	public ScrollDetectView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public ScrollDetectView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public ScrollDetectView(Context context) {
		this(context, null);
	}

	public void setOnScrollDetectListener(OnScrollDetectListener listener) {
		mScrollDetectListener = listener;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		if (null != mScrollDetectListener) {
			mScrollDetectListener.onScrollDetect(ev);
		}
		return super.dispatchTouchEvent(ev);
	}

}
