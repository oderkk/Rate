package com.swufestu.rate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BbActivity extends AppCompatActivity {


    private  final String TAG = "BbActivity";

    private float dollarRate = 0.1f;
    private float euroRate = 0.2f;
    private float wonRate = 0.3f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bb);

    }public void toRMB(View btn){
        EditText rmb = findViewById(R.id.rmb);
        TextView rmbshow = findViewById(R.id.rmbshow);
        String inp =rmb.getText().toString();
        Log.i(TAG,"toRMB:inp="+inp);
        Log.i("BbActivity","toRMB:inp"+inp);

        float r = 0;
        if(inp.length()>0) {
            r = Float.parseFloat(inp);
        }else{
            Toast.makeText(this,"请输入正确金额",Toast.LENGTH_LONG).show();
        }
        if (btn.getId() == R.id.dollar) {
            rmbshow.setText(String.format("%.2f",r*dollarRate));
        } else if (btn.getId() == R.id.euro) {
            rmbshow.setText(String.format("%.2f",r*euroRate));
        } else if (btn.getId() == R.id.won) {
            rmbshow.setText(String.format("%.2f",r*wonRate));
        }

        Log.i(TAG,"toRMB:r="+r);


    }
    public void open(View btn){


        openConfig();

    }

    private void openConfig() {
        Intent main = new Intent(this, MainActivity.class);
        main.putExtra("dollar_rate_key", dollarRate);
        main.putExtra("euro_rate_key", euroRate);
        main.putExtra("won_rate_key", wonRate);

        Log.i(TAG, "open:dollarRate=" + dollarRate);
        Log.i(TAG, "open:euroRate=" + euroRate);
        Log.i(TAG, "open:wonRate=" + wonRate);

        startActivityForResult(main, 1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.menu_set){
            openConfig();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 2) {
            Bundle bundle = data.getExtras();
            dollarRate = bundle.getFloat("dollar_key",0.1f);
            euroRate = bundle.getFloat("euro_key",0.1f);
            wonRate = bundle.getFloat("won_key",0.1f);

            Log.i(TAG,"onActivityResult:dollarRate="+dollarRate);
            Log.i(TAG,"onActivityResult:euroRate="+euroRate);
            Log.i(TAG,"onActivityResult:wonRate="+wonRate);

        }

    }
}