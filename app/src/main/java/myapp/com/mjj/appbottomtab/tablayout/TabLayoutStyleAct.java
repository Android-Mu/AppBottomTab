package myapp.com.mjj.appbottomtab.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import myapp.com.mjj.appbottomtab.R;

import static android.view.View.inflate;

/**
 * Description：使用TabLayout实现APP底部tab
 * <p>
 * Created by Mjj on 2016/11/3 0003.
 */

public class TabLayoutStyleAct extends FragmentActivity {

    private TabLayout mTabLayout;
    private int[] tabNames = {R.string.main_tab_name_explore, R.string.main_tab_name_tweet, R.string.main_tab_name_quick, R.string.main_tab_name_quick, R.string.main_tab_name_my};
    private int[] tabIcons = {R.drawable.radio_homepage, R.drawable.radio_ordersearch, R.drawable.cb_icon_pen_normal, R.drawable.radio_personal, R.drawable.radio_my};

    private FrameLayout container;
    private MyFragmentPagerAdaper adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflate(this, R.layout.activity_tablayout, null);
        setContentView(view);

        mTabLayout = (TabLayout) findViewById(R.id.tab_tablayout);

        for (int i = 0; i < tabNames.length; i++) {
            View tabView = view.inflate(this, R.layout.tab_indicator, null);
            TextView textView = (TextView) tabView.findViewById(R.id.tab_title);
            if (i == 2) {
                textView.setText("");
                textView.setBackgroundResource(R.drawable.cb_icon_pen_normal);
                ImageView icon = (ImageView) tabView.findViewById(R.id.iv_user_flow_icon);
                icon.setVisibility(View.GONE);
            } else {
                textView.setText(tabNames[i]);
                // 利用这种办法设置图标是为了解决默认设置图标和文字出现的距离较大问题
                textView.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[i], 0, 0);
            }
            mTabLayout.addTab(mTabLayout.newTab().setCustomView(textView));
        }

        container = (FrameLayout) findViewById(R.id.fl_contains);
        adapter = new MyFragmentPagerAdaper(getSupportFragmentManager());

        // 初始化默认显示的fragment
        Fragment fragment = (Fragment) adapter.instantiateItem(container, 0);
        adapter.setPrimaryItem(container, 0, fragment);
        adapter.finishUpdate(container);
        adapter.destroyItem(container, 0, fragment);

        // Tablayout选择tab监听
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = mTabLayout.getSelectedTabPosition();//tab.getPosition();
                Fragment fragment = (Fragment) adapter.instantiateItem(container, position);
                adapter.setPrimaryItem(container, position, fragment);
                adapter.finishUpdate(container);
                adapter.destroyItem(container, position, fragment);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
