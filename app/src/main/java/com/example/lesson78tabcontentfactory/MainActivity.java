package com.example.lesson78tabcontentfactory;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends TabActivity {

    final String TABS_TAG_1 = "Tag 1";
    final String TABS_TAG_2 = "Tag 2";
    private TabHost.TabContentFactory tabFactory = new TabHost.TabContentFactory() {
        @Override
        public View createTabContent(String tag) {
            TextView tv = new TextView(MainActivity.this);
            tv.setText("Cretead by me");
            if (tag.equals(TABS_TAG_1))
                return getLayoutInflater().inflate(R.layout.tab, null);
            else if (tag.equals(TABS_TAG_2))
                return tv;
            return null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec(TABS_TAG_1);
        tabSpec.setContent(tabFactory);
        tabSpec.setIndicator("Вкладка 1");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec(TABS_TAG_2);
        tabSpec.setContent(tabFactory);
        tabSpec.setIndicator("Вкладка 2");
        tabHost.addTab(tabSpec);
    }
}
