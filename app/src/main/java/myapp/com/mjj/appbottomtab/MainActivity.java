package myapp.com.mjj.appbottomtab;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import myapp.com.mjj.appbottomtab.frtabhost.FrTabHostStyleAct;
import myapp.com.mjj.appbottomtab.layout.DialogHelper;
import myapp.com.mjj.appbottomtab.radiogroup.RadioGroupStyleAct;
import myapp.com.mjj.appbottomtab.tablayout.TabLayoutStyleAct;

/**
 * 不同方式实现APP底部tab切换功能
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn1:
                jumpActivity(MainActivity.this, RadioGroupStyleAct.class);
                break;
            case R.id.btn2:
                jumpActivity(MainActivity.this, FrTabHostStyleAct.class);
                break;
            case R.id.btn3:
                jumpActivity(MainActivity.this, TabLayoutStyleAct.class);
                break;
            case R.id.btn4:
                DialogHelper.getMessageDialog(MainActivity.this, "此种方式现在已基本淘汰掉了,因为所有的图片和文字均是通过布局写上去的,灵活性差，也比较浪费时间,这里就不提供代码了.").show();
                break;
        }
    }

    private void jumpActivity(Context context, Class clz) {
        Intent intent = new Intent(context, clz);
        context.startActivity(intent);
    }
}
