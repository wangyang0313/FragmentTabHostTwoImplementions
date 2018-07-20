package com.wy.fragmenttabhosttwoimplementions;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.wy.fragmenttabhosttwoimplementions.menu.MainTabsSecond;

/**
 * 第二种实现：自定义MyFragmentTabHost实现带图片的底部导航栏
 */
public class SecondImplementionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_implementions);

        //判断当前设备版本号是否为4.4以上，如果是，则通过调用setTranslucentStatus让状态栏变透明
        //透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        initFragmentTabHost();
    }

    /**
     * 初始化FragmentTabHost
     */
    private void initFragmentTabHost() {
        //初始化tabHost
        FragmentTabHost tabHost = (FragmentTabHost) findViewById(R.id.tabhost);
        ImageView listen = (ImageView) findViewById(R.id.listen);
        //将tabHost和FragmentLayout关联
        tabHost.setup(getApplicationContext(), getSupportFragmentManager(), R.id.fl_content);

        //去掉分割线
        if (Build.VERSION.SDK_INT > 10) {
            tabHost.getTabWidget().setShowDividers(0);
        }
        //添加tab和其对应的fragment
        MainTabsSecond[] tabs = MainTabsSecond.values();
        for (int i = 0; i < tabs.length; i++) {
            MainTabsSecond mainTabs = tabs[i];
            TabHost.TabSpec tabSpec = tabHost.newTabSpec(mainTabs.getName());

            View indicator = View.inflate(getApplicationContext(), R.layout.tab_indicator, null);
            TextView tv_indicator = (TextView) indicator.findViewById(R.id.tv_indicator);
            Drawable drawable = getApplicationContext().getResources().getDrawable(mainTabs.getIcon());

            //当tab替换成ImageView时，隐藏tab并保持占位
            if (i == 1) {
                tv_indicator.setVisibility(View.INVISIBLE);
            } else {
                tv_indicator.setCompoundDrawablesWithIntrinsicBounds(null, drawable, null, null);
                tv_indicator.setText(mainTabs.getName());
            }
            tabSpec.setIndicator(indicator);
            tabHost.addTab(tabSpec, mainTabs.getCla(), null);

            //图片的点击事件
            listen.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "点击了图片", Toast.LENGTH_SHORT).show();
                    //替换Fragment
                    //不推荐这么干，因为将tab替换成了ImageView
//                    getSupportFragmentManager().beginTransaction()
//                            .add(R.id.fl_content, new OrderTabFragment()).commit();
                }
            });
        }
    }
}
