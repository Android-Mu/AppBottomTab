package myapp.com.mjj.appbottomtab.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import myapp.com.mjj.appbottomtab.R;

/**
 * Description：
 * Created by Mjj on 2016/11/2 0002.
 */

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        TextView textView = (TextView) view.findViewById(R.id.tv_fr);
        textView.setText("SecondFragment");
        return view;
    }
}
