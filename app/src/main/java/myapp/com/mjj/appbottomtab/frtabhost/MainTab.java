package myapp.com.mjj.appbottomtab.frtabhost;

import myapp.com.mjj.appbottomtab.R;
import myapp.com.mjj.appbottomtab.fragment.FirstFragment;
import myapp.com.mjj.appbottomtab.fragment.FourthFragment;
import myapp.com.mjj.appbottomtab.fragment.SecondFragment;
import myapp.com.mjj.appbottomtab.fragment.ThirdFragment;

public enum MainTab {

    NEWS(0, R.string.main_tab_name_explore, R.drawable.radio_homepage,
            FirstFragment.class),

    TWEET(1, R.string.main_tab_name_tweet, R.drawable.radio_ordersearch,
            SecondFragment.class),

    QUICK(2, R.string.main_tab_name_quick, R.drawable.radio_personal,
            ThirdFragment.class),

    EXPLORE(3, R.string.main_tab_name_my, R.drawable.radio_my,
            FourthFragment.class);

    private int idx;
    private int resName;
    private int resIcon;
    private Class<?> clz;

    private MainTab(int idx, int resName, int resIcon, Class<?> clz) {
        this.idx = idx;
        this.resName = resName;
        this.resIcon = resIcon;
        this.clz = clz;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getResName() {
        return resName;
    }

    public void setResName(int resName) {
        this.resName = resName;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }

    public Class<?> getClz() {
        return clz;
    }

    public void setClz(Class<?> clz) {
        this.clz = clz;
    }
}
