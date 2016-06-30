package com.elyeproj.javadaggeruitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    InjectedData iData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MainApplication)getApplicationContext()).getComponent().inject(this);

        TextView textView = (TextView)findViewById(R.id.txt_myview);

        if (iData.getStatus()) {
            textView.setText("True");
        } else {
            textView.setText("False");
        }
    }
}
