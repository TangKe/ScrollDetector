package me.tangke.scrolldetectorsample.sample;

import me.tangke.scrolldetectorsample.R;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewScrollDetectorActivity extends BaseScrollDetectorActivity {
	private WebView mWebView;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_web_view);
	}

	@Override
	public void onContentChanged() {
		super.onContentChanged();
		mWebView = (WebView) findViewById(R.id.target);
		mWebView.setWebViewClient(new BaseWebViewClient());
		mWebView.loadUrl("http://www.sina.com");
	}

	private class BaseWebViewClient extends WebViewClient {
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;
		}
	}
}
