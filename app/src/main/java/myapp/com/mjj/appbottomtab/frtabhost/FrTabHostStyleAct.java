package myapp.com.mjj.appbottomtab.frtabhost;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import myapp.com.mjj.appbottomtab.R;

/**
 * Description：FragmentTabHost实现APP底部导航tab
 * <p>
 * Created by Mjj on 2016/11/3 0003.
 */

public class FrTabHostStyleAct extends AppCompatActivity implements TabHost.OnTabChangeListener, View.OnTouchListener {

    private MyFragmentTabHost mTabHost;
    private CharSequence mTitle; // tab的底部文字
    private String[] mTitles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frtabhoststyleact);
        initView();
    }

    private void initView() {
        mTitle = getResources().getString(R.string.main_tab_name_explore);
        mTitles = getResources().getStringArray(R.array.main_titles_arrays);
        mTabHost = (MyFragmentTabHost) findViewById(R.id.mytabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        if (android.os.Build.VERSION.SDK_INT > 10) {
            mTabHost.getTabWidget().setShowDividers(0);
        }

        initTabs();

        mTabHost.setCurrentTab(0);
        mTabHost.setOnTabChangedListener(this);
    }

    private void initTabs() {
        MainTab[] tabs = MainTab.values();
        int size = tabs.length;
        for (int i = 0; i < size; i++) {
            MainTab mainTab = tabs[i];
            TabHost.TabSpec tab = mTabHost.newTabSpec(getString(mainTab.getResName()) + this.toString());
            View indicator = View.inflate(this, R.layout.tab_indicator, null);
            TextView title = (TextView) indicator.findViewById(R.id.tab_title);
            ImageView icon = (ImageView) indicator.findViewById(R.id.iv_user_flow_icon);

            Drawable drawable = this.getResources().getDrawable(mainTab.getResIcon());
            icon.setImageDrawable(drawable);

            // 中间添加tab处理
            if (i == 2) {
                // 当点击了中间tab时，其它tab状态恢复为默认
                title.setText("");
                icon.setImageDrawable(null);
                // 当点击了中间tab时，记录在此之前被点击的tab,方便恢复
//                indicator.setVisibility(View.INVISIBLE);
                mTabHost.setNoTabChangedTag(getString(mainTab.getResName()));
            } else {
                title.setText(getString(mainTab.getResName()));
            }
            tab.setIndicator(indicator);

            mTabHost.addTab(tab, mainTab.getClz(), null);
            mTabHost.getTabWidget().getChildAt(i).setOnTouchListener(this);
        }
    }

    @Override
    public void onTabChanged(String s) {
        final int size = mTabHost.getTabWidget().getTabCount();
        for (int i = 0; i < size; i++) {
            View v = mTabHost.getTabWidget().getChildAt(i);
            if (i == mTabHost.getCurrentTab()) {
                v.setSelected(true);
//                mTitle = mTitles[i == 3 ? i - 1 : i];
                if (2 == i) {
                    Toast.makeText(FrTabHostStyleAct.this, "中间tab已添加", Toast.LENGTH_SHORT).show();
                }
                // 中间增加tab
                mTitle = mTitles[i == 4 || i == 3 ? i - 1 : i];
            } else {
                v.setSelected(false);
            }
        }
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        boolean consumed = false;
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN
                && view.equals(mTabHost.getCurrentTabView())) {
            Fragment currentFragment = getCurrentFragment();
            if (currentFragment != null
                    && currentFragment instanceof OnTabReselectListener) {
                OnTabReselectListener listener = (OnTabReselectListener) currentFragment;
                listener.onTabReselect();
                consumed = true;
            }
        }
        return consumed;
    }

    private Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentByTag(
                mTabHost.getCurrentTabTag());
    }

}
