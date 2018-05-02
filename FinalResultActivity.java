package jp.co.abs.jankenyamada;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FinalResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);
        SharedPreferences Count = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor Editor = Count.edit();
        int FightCount = Count.getInt("FightCount",0);
        int WinCount = Count.getInt("WinCount",0);
        int LoseCount = Count.getInt("LoseCount",0);
        int DrawCount = Count.getInt("DrawCount",0);
        ImageView ResultFinalView = findViewById(R.id.ResultFinalView);
        TextView Result = findViewById(R.id.ResultNumber);
        TextView ResultText = findViewById(R.id.ResultText);
        Result.setText("総合戦績:"+ FightCount + "戦\n"+ WinCount + "勝"+ LoseCount + "敗" + DrawCount + "引き分け");

        if (WinCount > LoseCount){
            ResultText.setText("あなたの勝ち!!");
            ResultFinalView.setImageResource(R.drawable.win);
        }else if (WinCount < LoseCount){
            ResultText.setText("あなたの負け...");
            ResultFinalView.setImageResource(R.drawable.lose);
        }else {
            ResultText.setText("引き分け");
            ResultFinalView.setImageResource(R.drawable.draw);
        }
        Editor.commit();
        SharedPreferences TotalCount = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor TotalEditor = TotalCount.edit();
        int TotalFightCount = TotalCount.getInt("TotalFightCount",0);
        int TotalWinCount = TotalCount.getInt("TotalWinCount",0);
        int TotalLoseCount = TotalCount.getInt("TotalLoseCount",0);
        int TotalDrawCount = TotalCount.getInt("TotalDrawCount",0);
        TotalEditor.putInt("TotalFightCount",TotalFightCount + FightCount);
        TotalEditor.putInt("TotalWinCount",TotalWinCount + WinCount);
        TotalEditor.putInt("TotalLoseCount",TotalLoseCount + LoseCount);
        TotalEditor.putInt("TotalDrawCount",TotalDrawCount + DrawCount);
        TotalEditor.commit();
    }
    public void onClick(View view){
        Intent intent = new Intent(this,MainForm.class);
        startActivity(intent);
        finish();
    }
    }
