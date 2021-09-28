package com.swufestu.rate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    EditText dollar_rate;
    EditText euro_rate;
    EditText won_rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        float dollar = intent.getFloatExtra("dollar_rate_key",0.0f);
        float euro = intent.getFloatExtra("euro_rate_key",0.0f);
        float won = intent.getFloatExtra("won_rate_key",0.0f);

        Log.i(TAG,"onCreate:dollar="+dollar);
        Log.i(TAG,"onCreate:euro="+euro);
        Log.i(TAG,"onCreate:won="+won);

        dollar_rate =findViewById(R.id.dollar_rate);
        euro_rate =findViewById(R.id.euro_rate);
        won_rate =findViewById(R.id.won_rate);

        dollar_rate.setText(String.valueOf(dollar));
        euro_rate.setText(String.valueOf(euro));
        won_rate.setText((String.valueOf(won)));
    }
    public void save(View btn) {
        Log.i(TAG, "save:");
        //获取新的值
        float newdollar = Float.parseFloat(dollar_rate.getText().toString());
        float neweuro = Float.parseFloat(euro_rate.getText().toString());
        float newwon = Float.parseFloat(won_rate.getText().toString());

        Log.i(TAG, "save:获取新的值");
        Log.i(TAG, "onCreate:newdollar" + newdollar);
        Log.i(TAG, "onCreate:neweuro" + neweuro);
        Log.i(TAG, "onCreate:newwon" + newwon);

        //保存到Bundle或Extra中
        Intent intent = getIntent();
        Bundle bdl = new Bundle();
        bdl.putFloat("dollar_key", newdollar);
        bdl.putFloat("euro_key", neweuro);
        bdl.putFloat("won_key", newwon);

        intent.putExtras(bdl);
        setResult(2, intent);

        finish();
    }
}