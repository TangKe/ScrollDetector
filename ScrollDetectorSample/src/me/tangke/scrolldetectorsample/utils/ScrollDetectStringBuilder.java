package me.tangke.scrolldetectorsample.utils;

import me.tangke.scrolldetector.Scrollable;
import me.tangke.scrolldetectorsample.R;
import android.content.Context;

public class ScrollDetectStringBuilder {
	public static String buildScrollState(Context context, Scrollable<?> scroll) {
		StringBuilder builder = new StringBuilder();
		builder.append(scroll.toString());
		builder.append("\n");
		builder.append(context.getString(R.string.label_scroll_state,
				scroll.canScrollLeft(), scroll.canScrollRight(),
				scroll.canScrollUp(), scroll.canScrollDown()));
		return builder.toString();
	}
}
