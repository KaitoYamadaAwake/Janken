package jp.co.abs.jankenyamada;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences Count = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor Editor = Count.edit();
        int FightCount = Count.getInt("FightCount",0);
        int WinCount = Count.getInt("WinCount",0);
        int LoseCount = Count.getInt("LoseCount",0);
        int DrawCount = Count.getInt("DrawCount",0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        int UserHand = intent.getIntExtra("UserHand",0);
        Log.d(String.valueOf(UserHand),"A");
        long seed = System.currentTimeMillis();
        Random rnd = new Random(seed);
        int ComHand = rnd.nextInt(3);
        int MaxFight = Count.getInt("MaxFight",0);
        Button Return =findViewById(R.id.Return);
        Editor.putInt("FightCount",FightCount+1);
        Editor.commit();
        ImageView UserHandView = findViewById(R.id.UserHand);
        switch (UserHand){
            case 0:
                UserHandView.setImageResource(R.drawable.j_gu02);
                break;
            case 1:
                UserHandView.setImageResource(R.drawable.j_ch02);
                break;
            case 2:
                UserHandView.setImageResource(R.drawable.j_pa02);
                break;
        }
        ImageView ComHandView = findViewById(R.id.ComHand);
        switch (ComHand){
            case 0:
                ComHandView.setImageResource(R.drawable.j_gu02);
                break;
            case 1:
                ComHandView.setImageResource(R.drawable.j_ch02);
                break;
            case 2:
                ComHandView.setImageResource(R.drawable.j_pa02);
                break;
        }


        TextView Result = findViewById(R.id.NowResult);
        TextView ResultText = findViewById(R.id.Result);
        ImageView ResultImage = findViewById(R.id.Resultview);
        FightCount = Count.getInt("FightCount",0);
        if (UserHand==ComHand){
            Editor.putInt("DrawCount",DrawCount+1);
            Editor.commit();
            DrawCount = Count.getInt("DrawCount",0);
            Result.setText("総合戦績:"+ FightCount + "戦\n"+ WinCount + "勝"+ LoseCount + "敗" + DrawCount + "引き分け" );
            ResultImage.setImageResource(R.drawable.draw);
            ResultText.setText("引き分け");
        }else{
            switch (UserHand){
                case 0:
                    if (ComHand == 1){
                        Editor.putInt("WinCount",WinCount+1);
                        Editor.commit();
                        WinCount = Count.getInt("WinCount",0);
                        Result.setText("総合戦績:"+ FightCount + "戦\n"+ WinCount + "勝"+ LoseCount + "敗" + DrawCount + "引き分け" );
                        ResultImage.setImageResource(R.drawable.win);
                        ResultText.setText("あなたの勝ち!!");

                    }else {
                        Editor.putInt("LoseCount",LoseCount+1);
                        Editor.commit();
                        LoseCount = Count.getInt("LoseCount",0);
                        Result.setText("総合戦績:"+ FightCount + "戦\n"+ WinCount + "勝"+ LoseCount + "敗" + DrawCount + "引き分け" );
                        ResultImage.setImageResource(R.drawable.lose);
                        ResultText.setText("あなたの負け...");
                    }
                    break;
                case 1:
                    if (ComHand == 2){
                        Editor.putInt("WinCount",WinCount+1);
                        Editor.commit();
                        WinCount = Count.getInt("WinCount",0);
                        Result.setText("総合戦績:"+ FightCount + "戦\n"+ WinCount + "勝"+ LoseCount + "敗" + DrawCount + "引き分け" );
                        ResultImage.setImageResource(R.drawable.win);
                        ResultText.setText("あなたの勝ち!!");
                    }else {
                        Editor.putInt("LoseCount",LoseCount+1);
                        Editor.commit();
                        LoseCount = Count.getInt("LoseCount",0);
                        Result.setText("総合戦績:"+ FightCount + "戦\n"+ WinCount + "勝"+ LoseCount + "敗" + DrawCount + "引き分け" );
                        ResultImage.setImageResource(R.drawable.lose);
                        ResultText.setText("あなたの負け...");
                    }
                    break;
                case 2:
                    if(ComHand == 0){
                        Editor.putInt("WinCount",WinCount+1);
                        Editor.commit();
                        WinCount = Count.getInt("WinCount",0);
                        Result.setText("総合戦績:"+ FightCount + "戦\n"+ WinCount + "勝"+ LoseCount + "敗" + DrawCount + "引き分け" );
                        ResultImage.setImageResource(R.drawable.win);
                        ResultText.setText("あなたの勝ち!!");
                    }else {
                        Editor.putInt("LoseCount", LoseCount + 1);
                        Editor.commit();
                        LoseCount = Count.getInt("LoseCount", 0);
                        Result.setText("総合戦績:" + FightCount + "戦\n" + WinCount + "勝" + LoseCount + "敗" + DrawCount + "引き分け");
                        ResultImage.setImageResource(R.drawable.lose);
                        ResultText.setText("あなたの負け...");
                    }
            }
            Editor.commit();
            }
        if (MaxFight > FightCount) {
            Return.setText("次の対戦へ");
        }else {
            Return.setText("結果へ");
        }

        }

        public void onClick(View view) {
            SharedPreferences Count = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor Editor = Count.edit();
            int FightCount = Count.getInt("FightCount",0);
            int MaxFight = Count.getInt("MaxFight",0);
                    if (MaxFight == FightCount){
                        Intent intent = new Intent(this,FinalResultActivity.class);
                        startActivity(intent);

                    }else {
                        Intent intent = new Intent(this,MainActivity.class);
                        startActivity(intent);
                    }
                    Editor.commit();
                    finish();

            }

            }




