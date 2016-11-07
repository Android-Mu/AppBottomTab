package myapp.com.mjj.appbottomtab.radiogroup;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

/**
 * RadioGroup方式实现APP底部tab切换工具类
 */
public class RgToFmUtils {

    private int showindex;
    private int hideindex;
    private List<Fragment> fragmentList;
    private FragmentManager supportFragmentManager;
    private int id;
    private RadioGroup radioGroup;
    private Context context;

    //1.构造方法私有化
    private RgToFmUtils(Context context) {
        this.context = context;
    }

    //2.暴露出一个方法，返回当前类的对象
    private static RgToFmUtils mInstance;

    public static RgToFmUtils newInstance(Context context) {
        if (mInstance == null) {
            synchronized (RgToFmUtils.class) {
                if (mInstance == null) {
                    mInstance = new RgToFmUtils(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 外部使用调用此方法即可
     *
     * @param fragmentList           装在fragment的集合
     * @param radioGroup；            底部导航布局
     * @param supportFragmentManager fragment管理器
     * @param id                     装在fragment的容器id
     */
    public void showTabToFragment(List<Fragment> fragmentList, RadioGroup radioGroup, FragmentManager supportFragmentManager, int id) {
        this.radioGroup = radioGroup;
        this.id = id;
        this.fragmentList = fragmentList;
        this.supportFragmentManager = supportFragmentManager;
        ((RadioButton) radioGroup.getChildAt(showindex)).setChecked(true);//初始化选中第一个
        showFragment(showindex, hideindex);//初始化碎片

        initsetOnClickListener();
    }

    /**
     * 作用：监听
     */
    private void initsetOnClickListener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
                radioButton.setChecked(true);
                int i = group.indexOfChild(radioButton);
                showFragment(i, hideindex);
                hideindex = i;
            }
        });
    }

    /**
     * 作用：显示碎片的逻辑
     */
    private void showFragment(int showindex, int hideindex) {
        Fragment showfragment = fragmentList.get(showindex);
        Fragment hidefragment = fragmentList.get(hideindex);
        FragmentTransaction ft = supportFragmentManager.beginTransaction();
        if (!showfragment.isAdded()) {  // 避免重复添加
            ft.add(id, showfragment);
        }
        if (showindex == hideindex) {
            ft.show(showfragment);
        } else {
            ft.show(showfragment);
            ft.hide(hidefragment);
        }
        ft.commit();
    }

}
