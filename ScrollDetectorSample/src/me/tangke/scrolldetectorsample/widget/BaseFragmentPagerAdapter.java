package me.tangke.scrolldetectorsample.widget;

import me.tangke.scrolldetectorsample.fragment.BaseListFragment;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class BaseFragmentPagerAdapter extends FragmentPagerAdapter {
	private Context mContext;

	public BaseFragmentPagerAdapter(Context context, FragmentManager fm) {
		super(fm);
		mContext = context;
	}

	@Override
	public Fragment getItem(int position) {
		return Fragment.instantiate(mContext, BaseListFragment.class.getName());
	}

	@Override
	public int getCount() {
		return 5;
	}

}
