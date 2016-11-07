package myapp.com.mjj.appbottomtab.radiogroup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import myapp.com.mjj.appbottomtab.R;
import myapp.com.mjj.appbottomtab.fragment.FirstFragment;
import myapp.com.mjj.appbottomtab.fragment.FourthFragment;
import myapp.com.mjj.appbottomtab.fragment.SecondFragment;
import myapp.com.mjj.appbottomtab.fragment.ThirdFragment;

/**
 * Description：使用RadioGrup方式实现app底部的tab切换
 * <p>
 * Created by Mjj on 2016/11/3 0003.
 */

public class RadioGroupStyleAct extends AppCompatActivity {

    private List<Fragment> mFragments;
    private FrameLayout frameLayout;
    private RadioGroup mRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiogroup);
        frameLayout = (FrameLayout) findViewById(R.id.fl_contains_fr);
        mRadioGroup = (RadioGroup) findViewById(R.id.rg_tab_menu);
        initFragments();
        initView();
    }

    //初始化碎片
    private void initFragments() {
        mFragments = new ArrayList<>();
        mFragments.add(new FirstFragment());
        mFragments.add(new SecondFragment());
        mFragments.add(new ThirdFragment());
        mFragments.add(new FourthFragment());
    }

    private void initView() {
        RgToFmUtils.newInstance(this).showTabToFragment(mFragments, mRadioGroup, getSupportFragmentManager(), R.id.fl_contains_fr);
    }
}
