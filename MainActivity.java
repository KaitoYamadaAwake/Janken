package jp.co.abs.jankenyamada;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences Count = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor Editor = Count.edit();
        int FightCount = Count.getInt("FightCount",0);
        int WinCount = Count.getInt("WinCount",0);
        int LoseCount = Count.getInt("LoseCount",0);
        int DrawCount = Count.getInt("DrawCount",0);
        int MaxFight = Count.getInt("MaxFight",0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView Result = findViewById(R.id.Result);
        Result.setText("総合戦績:"+ FightCount + "戦\n"+ WinCount + "勝"+ LoseCount + "敗" + DrawCount + "引き分け\n" + MaxFight +"戦中");
        Editor.commit();
        }

    public void onClick(View view){
        SharedPreferences Count = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor Editor = Count.edit();

        int UserHand=0;
        switch (view.getId()){
            case R.id.gu:
                UserHand = 0;
                break;
            case R.id.ch:
                UserHand = 1;
                break;
            case R.id.pa:
                UserHand = 2;
                break;
        }


        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("UserHand",UserHand);
        Log.d(String.valueOf(UserHand),"Test");
        Editor.commit();
        startActivity(intent);
        finish();
    }
}

