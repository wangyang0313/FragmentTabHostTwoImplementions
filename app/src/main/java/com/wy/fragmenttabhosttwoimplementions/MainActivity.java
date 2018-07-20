package com.wy.fragmenttabhosttwoimplementions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.btn_first)
    Button btnFirst;
    @InjectView(R.id.btn_second)
    Button btnSecond;
    @InjectView(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

    }

    @OnClick({R.id.btn_first, R.id.btn_second})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_first://用FragmentTabHost实现底部导航栏
                startActivity(new Intent(getApplicationContext(), FirstImplementionsActivity.class));
                break;
            case R.id.btn_second://自定义MyFragmentTabHost实现带图片的底部导航栏
                startActivity(new Intent(getApplicationContext(), SecondImplementionsActivity.class));
                break;
        }
    }
}
