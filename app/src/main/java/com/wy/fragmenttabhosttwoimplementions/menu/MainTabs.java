package com.wy.fragmenttabhosttwoimplementions.menu;

import com.wy.fragmenttabhosttwoimplementions.R;
import com.wy.fragmenttabhosttwoimplementions.fragment.HomeTabFragment;
import com.wy.fragmenttabhosttwoimplementions.fragment.OrderTabFragment;
import com.wy.fragmenttabhosttwoimplementions.fragment.StatisticsTabFragment;

public enum MainTabs {
    Home(0,"首页", R.drawable.selector_tab_home, HomeTabFragment.class),
    Classify(1,"订单", R.drawable.selector_tab_home, OrderTabFragment.class),
    ShoppingCar(2,"统计", R.drawable.selector_tab_home, StatisticsTabFragment.class);

    private int i;
    private String name;
    private int icon;
    private Class<?> cla;

     MainTabs(int i, String name, int icon, Class<?> cla) {
        this.i = i;
        this.name = name;
        this.icon = icon;
        this.cla = cla;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Class<?> getCla() {
        return cla;
    }

    public void setCla(Class<?> cla) {
        this.cla = cla;
    }
}
