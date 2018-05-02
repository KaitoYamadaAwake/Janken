package jp.co.abs.jankenyamada;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class MainForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_form);
        SharedPreferences TotalCount = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor TotalEditor = TotalCount.edit();
        int TotalFightCount = TotalCount.getInt("TotalFightCount",0);
        int TotalWinCount = TotalCount.getInt("TotalWinCount",0);
        int TotalLoseCount = TotalCount.getInt("TotalLoseCount",0);
        int TotalDrawCount = TotalCount.getInt("TotalDrawCount",0);

    }

    public void onClick(View view) {

        SharedPreferences TotalCount = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor TotalEditor = TotalCount.edit();
        int TotalFightCount = TotalCount.getInt("TotalFightCount",0);
        int TotalWinCount = TotalCount.getInt("TotalWinCount",0);
        int TotalLoseCount = TotalCount.getInt("TotalLoseCount",0);
        int TotalDrawCount = TotalCount.getInt("TotalDrawCount",0);
        SharedPreferences Count = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor Editor = Count.edit();
        Editor.clear();
        Editor.commit();
        TotalEditor.putInt("TotalFightCount",TotalFightCount);
        TotalEditor.putInt("TotalWinCount",TotalWinCount);
        TotalEditor.putInt("TotalLoseCount",TotalLoseCount);
        TotalEditor.putInt("TotalDrawCount",TotalDrawCount);
        TotalEditor.commit();


        Spinner FightCount = (Spinner) this.findViewById(R.id.FightCount);
                int idx3 = FightCount.getSelectedItemPosition();
                String FightCS = (String) FightCount.getSelectedItem();
                int FightInt = Integer.parseInt(FightCS);
                Editor.putInt("MaxFight", FightInt);
                Editor.commit();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

