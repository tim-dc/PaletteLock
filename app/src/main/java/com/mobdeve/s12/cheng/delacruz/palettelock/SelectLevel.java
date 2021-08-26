package com.mobdeve.s12.cheng.delacruz.palettelock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.mobdeve.s12.cheng.delacruz.palettelock.Helpers.HelperClasses.AdapterLevel;
import com.mobdeve.s12.cheng.delacruz.palettelock.Helpers.HelperClasses.Helper;

import java.util.ArrayList;

public class SelectLevel extends AppCompatActivity implements AdapterLevel.ListItemClickListener{

    RecyclerView levelRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_select_level);

        findViewById(R.id.backButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent mIntent;
                mIntent = new Intent(SelectLevel.this, StartScreen.class);
                startActivity(mIntent);
            }
        });

        findViewById(R.id.infoButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showInstructions();
            }
        });

        findViewById(R.id.btn_highscore).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showHighScore();
            }
        });

        levelRecycler = findViewById(R.id.my_recycler);
        levelRecycler();
    }

    private void showInstructions(){
        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.info_popup);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_popup);

        ImageView btnClose = dialog.findViewById(R.id.btn_close);
        Button btnOk = dialog.findViewById(R.id.btn_ok);

        dialog.setCanceledOnTouchOutside(false);
        //dialog.setCancelable(false);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void showHighScore(){
        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.highscore_popup);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_popup);

        ImageView btnClose = dialog.findViewById(R.id.btn_close);

        dialog.setCanceledOnTouchOutside(false);
        //dialog.setCancelable(false);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        dialog.show();
    }

    private void levelRecycler() {

        //All Gradients
        //GradientDrawable gradient2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffd4cbe5, 0xffd4cbe5});
        //GradientDrawable gradient1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xff7adccf, 0xff7adccf});
        //GradientDrawable gradient3 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xfff7c59f, 0xFFf7c59f});
        //GradientDrawable gradient4 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{0xffb8d7f5, 0xffb8d7f5});


        levelRecycler.setHasFixedSize(true);
        levelRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<Helper> location = new ArrayList<>();
        location.add(new Helper("Level 1"));
        location.add(new Helper("Level 2"));
        location.add(new Helper("Level 3"));
        location.add(new Helper("Level 4"));
        location.add(new Helper("Level 5"));
        location.add(new Helper("Level 6"));
        location.add(new Helper("Level 7"));

        adapter = new AdapterLevel(location,this);
        levelRecycler.setAdapter(adapter);

    }

    @Override
    public void onListClick(int clickedItemIndex) {


            Intent mIntent;
            switch (clickedItemIndex){
                case 0: //first item in Recycler view
                    mIntent  = new Intent(SelectLevel.this, MainActivity.class);
                    startActivity(mIntent);
                    break;
                case 1: //second item in Recycler view
                    mIntent = new Intent(SelectLevel.this, MainActivity.class);
                    startActivity(mIntent);
                    break;
                case 2: //third item in Recycler view
                    mIntent = new Intent(SelectLevel.this, MainActivity.class);
                    startActivity(mIntent);
                    break;
                      case 3: //third item in Recycler view
                    mIntent = new Intent(SelectLevel.this, MainActivity.class);
                    startActivity(mIntent);
                    break;
                case 4: //third item in Recycler view
                    mIntent = new Intent(SelectLevel.this, MainActivity.class);
                    startActivity(mIntent);
                    break;

        }


    }
}