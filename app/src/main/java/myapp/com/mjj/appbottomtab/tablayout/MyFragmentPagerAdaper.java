package myapp.com.mjj.appbottomtab.tablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import myapp.com.mjj.appbottomtab.fragment.FirstFragment;
import myapp.com.mjj.appbottomtab.fragment.FourthFragment;
import myapp.com.mjj.appbottomtab.fragment.SecondFragment;
import myapp.com.mjj.appbottomtab.fragment.ThirdFragment;

/**
 * Description：TabLayout监听时切换Fragment.
 * <p>
 * Created by Mjj on 2016/11/3 0003.
 */

public class MyFragmentPagerAdaper extends FragmentPagerAdapter {

    public MyFragmentPagerAdaper(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            case 2:
                // 点击中间tab时，为了验证结果，这里重复创建了一个FourthFragment.
                return new FourthFragment();
            case 3:
                return new ThirdFragment();
            case 4:
                return new FourthFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        super.finishUpdate(container);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
