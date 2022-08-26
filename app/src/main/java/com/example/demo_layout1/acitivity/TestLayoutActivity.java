package com.example.demo_layout1.acitivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.demo_layout1.R;

import net.cachapa.expandablelayout.ExpandableLayout;

public class TestLayoutActivity extends AppCompatActivity {

    private ExpandableLayout expandableLayout0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_layout);
        expandableLayout0 = findViewById(R.id.expandable_layout_0);

        expandableLayout0.setOnExpansionUpdateListener(new ExpandableLayout.OnExpansionUpdateListener() {
            @Override
            public void onExpansionUpdate(float expansionFraction, int state) {
                Log.d("ExpandableLayout0", "State: " + state);
            }
        });

//        expandableLayout1.setOnExpansionUpdateListener(new ExpandableLayout.OnExpansionUpdateListener() {
//            @Override
//            public void onExpansionUpdate(float expansionFraction, int state) {
//                Log.d("ExpandableLayout1", "State: " + state);
//            }
//        });

        TextView textView = findViewById(R.id.expand_button);
        textView.setOnClickListener(v -> {
            if (expandableLayout0.isExpanded()) {
                expandableLayout0.collapse();
            } else {
                expandableLayout0.expand();

            }
        });

    }
}