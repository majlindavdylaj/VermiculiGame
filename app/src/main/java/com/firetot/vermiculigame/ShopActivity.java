package com.firetot.vermiculigame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ShopActivity extends AppCompatActivity {

    RelativeLayout shopP1, shopP2, shopP3, shopP4;
    RelativeLayout unlock2, unlock3, unlock4;

    ImageButton goHome;
    TextView tv_coins;

    boolean shop2, shop3, shop4;

    int coins, action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        shopP1 = (RelativeLayout) findViewById(R.id.shopP1);
        shopP2 = (RelativeLayout) findViewById(R.id.shopP2);
        shopP3 = (RelativeLayout) findViewById(R.id.shopP3);
        shopP4 = (RelativeLayout) findViewById(R.id.shopP4);

        unlock2 = (RelativeLayout) findViewById(R.id.unlock2);
        unlock3 = (RelativeLayout) findViewById(R.id.unlock3);
        unlock4 = (RelativeLayout) findViewById(R.id.unlock4);

        goHome = (ImageButton) findViewById(R.id.home);
        tv_coins = (TextView) findViewById(R.id.tv_coins);

        final SharedPreferences settings = getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        coins = settings.getInt("COINS", 0);
        action = settings.getInt("ACTION", 1);
        shop2 = settings.getBoolean("SHOP2", false);
        shop3 = settings.getBoolean("SHOP3", false);
        shop4 = settings.getBoolean("SHOP4", false);

        tv_coins.setText(""+coins);

        if (shop2 == true){
            unlock2.setVisibility(View.GONE);
        }
        if (shop3 == true){
            unlock3.setVisibility(View.GONE);
        }
        if (shop4 == true){
            unlock4.setVisibility(View.GONE);
        }


        shopP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action = 1;

                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("ACTION", action);
                editor.commit();
                startActivity(new Intent(ShopActivity.this, StartActivity.class));
            }
        });

        shopP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shop2 == true){
                    action = 2;

                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("ACTION", action);
                    editor.commit();
                    startActivity(new Intent(ShopActivity.this, StartActivity.class));

                } else if (coins >= 30){
                    shop2 = true;
                    action = 2;
                    coins = coins - 30;

                    tv_coins.setText(""+coins);
                    unlock2.setVisibility(View.GONE);

                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("ACTION", action);
                    editor.putInt("COINS", coins);
                    editor.putBoolean("SHOP2", shop2);
                    editor.commit();
                    startActivity(new Intent(ShopActivity.this, StartActivity.class));

                } else {
                    Toast.makeText(ShopActivity.this, "not enough coins", Toast.LENGTH_SHORT).show();
                }
            }
        });

        shopP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shop3 == true){
                    action = 3;

                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("ACTION", action);
                    editor.commit();
                    startActivity(new Intent(ShopActivity.this, StartActivity.class));

                } else if (coins >= 50){
                    shop3 = true;
                    action = 3;
                    coins = coins - 50;

                    tv_coins.setText(""+coins);
                    unlock3.setVisibility(View.GONE);

                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("ACTION", action);
                    editor.putInt("COINS", coins);
                    editor.putBoolean("SHOP3", shop3);
                    editor.commit();
                    startActivity(new Intent(ShopActivity.this, StartActivity.class));

                } else {
                    Toast.makeText(ShopActivity.this, "not enough coins", Toast.LENGTH_SHORT).show();
                }
            }
        });

        shopP4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shop4 == true){
                    action = 4;

                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("ACTION", action);
                    editor.commit();
                    startActivity(new Intent(ShopActivity.this, StartActivity.class));

                } else if (coins >= 80){
                    shop4 = true;
                    action = 4;
                    coins = coins - 80;

                    tv_coins.setText(""+coins);
                    unlock4.setVisibility(View.GONE);

                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("ACTION", action);
                    editor.putInt("COINS", coins);
                    editor.putBoolean("SHOP4", shop4);
                    editor.commit();
                    startActivity(new Intent(ShopActivity.this, StartActivity.class));

                } else {
                    Toast.makeText(ShopActivity.this, "not enough coins", Toast.LENGTH_SHORT).show();
                }
            }
        });

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShopActivity.this, StartActivity.class));
                finish();
            }
        });
    }
}
