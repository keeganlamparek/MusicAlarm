package com.example.keegan.musicalarm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ChooseSong extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_song);

        ListView listOfSongs = (ListView) findViewById(R.id.songsList);

        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.music_list));

        listOfSongs.setAdapter(mAdapter);

        listOfSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences sharedPreferences = getSharedPreferences("songChoice", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                switch (i){
                    case 0:
                        editor.putString("alarmSound", "spotify:track:6Vecwo7AHst9V2CE3kmwr0");
                        editor.apply();
                        break;
                    case 1:
                        editor.putString("alarmSound", "spotify:track:4vp2J1l5RD4gMZwGFLfRAu");
                        editor.apply();
                        break;
                    case 2:
                        editor.putString("alarmSound", "spotify:track:3cfOd4CMv2snFaKAnMdnvK");
                        editor.apply();
                        break;
                }
                startActivity(new Intent(ChooseSong.this, MainActivity.class));
            }
        });
    }
}
