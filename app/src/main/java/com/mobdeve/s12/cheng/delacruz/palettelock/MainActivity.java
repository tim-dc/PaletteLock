package com.mobdeve.s12.cheng.delacruz.palettelock;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private CanvasReel1 mCanvasReel1;
    private CanvasReel2 mCanvasReel2;
    private CanvasReel3 mCanvasReel3;
    private CanvasReel4 mCanvasReel4;
    private CanvasReel5 mCanvasReel5;

    private ArrayList<String> pReel1 = new ArrayList<String>();
    private ArrayList<String> pReel2 = new ArrayList<String>();
    private ArrayList<String> pReel3 = new ArrayList<String>();
    private ArrayList<String> pReel4 = new ArrayList<String>();
    private ArrayList<String> pReel5 = new ArrayList<String>();

    private ArrayList<String> goal = new ArrayList<String>();
    private ArrayList<String> currColor = new ArrayList<String>();

    private int testCounter = 0;

    private int currentCount=0;

    ImageView reelLock1;
    ImageView reelLock2;
    ImageView reelLock3;
    ImageView reelLock4;
    ImageView reelLock5;

    TextView counter;

    private boolean setFirstGoal = true;
    private boolean setNewGoal = true;
    private boolean allMatching = false;

//    private TextView counterText = (TextView)findViewById(R.id.counter);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        Timer timer = new Timer();
        Metronome metronome = new Metronome();
        timer.schedule(metronome,
                2000,
                2000);

        counter = findViewById(R.id.counter);
        mCanvasReel1 = findViewById(R.id.reel1);
        mCanvasReel2 = findViewById(R.id.reel2);
        mCanvasReel3 = findViewById(R.id.reel3);
        mCanvasReel4 = findViewById(R.id.reel4);
        mCanvasReel5 = findViewById(R.id.reel5);

        reelLock1 = (ImageView)findViewById(R.id.lock1);
        reelLock2 = (ImageView)findViewById(R.id.lock2);
        reelLock3 = (ImageView)findViewById(R.id.lock3);
        reelLock4 = (ImageView)findViewById(R.id.lock4);
        reelLock5 = (ImageView)findViewById(R.id.lock5);

        // Color Palletes (Color1,2,3,4,5) --->

        // 8ecae6,219ebc,023047,ffb703,fb8500
        pReel1.add("#8ecae6"); pReel2.add("#219ebc"); pReel3.add("#023047"); pReel4.add("#ffb703"); pReel5.add("#fb8500");
        // 264653,2a9d8f,e9c46a,f4a261,e76f51
        pReel1.add("#264653"); pReel2.add("#2a9d8f"); pReel3.add("#e9c46a"); pReel4.add("#f4a261"); pReel5.add("#e76f51");
        // ccd5ae,e9edc9,fefae0,faedcd,d4a373
        pReel1.add("#ccd5ae"); pReel2.add("#e9edc9"); pReel3.add("#fefae0"); pReel4.add("#faedcd"); pReel5.add("#d4a373");
        // cdb4db,ffc8dd,ffafcc,bde0fe,a2d2ff
        pReel1.add("#cdb4db"); pReel2.add("#ffc8dd"); pReel3.add("#ffafcc"); pReel4.add("#bde0fe"); pReel5.add("#a2d2ff");
        // f4f1de,e07a5f,3d405b,81b29a,f2cc8f
        pReel1.add("#f4f1de"); pReel2.add("#e07a5f"); pReel3.add("#3d405b"); pReel4.add("#81b29a"); pReel5.add("#f2cc8f");
        // 22223b,4a4e69,9a8c98,c9ada7,f2e9e4
        pReel1.add("#22223b"); pReel2.add("#4a4e69"); pReel3.add("#9a8c98"); pReel4.add("#c9ada7"); pReel5.add("#f2e9e4");
        // 6f1d1b,bb9457,432818,99582a,ffe6a7
        pReel1.add("#6f1d1b"); pReel2.add("#bb9457"); pReel3.add("#432818"); pReel4.add("#99582a"); pReel5.add("#ffe6a7");


        // Home Button
        findViewById(R.id.homeButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showConfirmExit();
            }
        });


        // Reels
        findViewById(R.id.reel1).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCanvasReel1.lockColor(true);
                reelLock1.setVisibility(View.VISIBLE);

                if(isMatching(currColor.get(0),goal.get(0))){
//                        System.out.println("(1)CurrColor = " + currColor.get(0) + " Goal: " + goal.get(0));
                    mCanvasReel1.setMatchingStatus(true);
                }
            }
        });

        findViewById(R.id.reel2).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCanvasReel2.lockColor(true);
                reelLock2.setVisibility(View.VISIBLE);


                if(isMatching(currColor.get(1),goal.get(1))){
//                        System.out.println("(2)CurrColor = " + currColor.get(1) + " Goal: " + goal.get(1));
                    mCanvasReel2.setMatchingStatus(true);
                }

            }
        });

        findViewById(R.id.reel3).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCanvasReel3.lockColor(true);
                reelLock3.setVisibility(View.VISIBLE);

                if(isMatching(currColor.get(2),goal.get(2))){
//                        System.out.println("(3)CurrColor = " + currColor.get(2) + " Goal: " + goal.get(2));
                    mCanvasReel3.setMatchingStatus(true);
                }

            }
        });

        findViewById(R.id.reel4).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCanvasReel4.lockColor(true);
                reelLock4.setVisibility(View.VISIBLE);

                if(isMatching(currColor.get(3),goal.get(3))){
//                        System.out.println("(4)CurrColor = " + currColor.get(3) + " Goal: " + goal.get(3));
                    mCanvasReel4.setMatchingStatus(true);
                }

            }
        });

        findViewById(R.id.reel5).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                mCanvasReel5.lockColor(true);
                reelLock5.setVisibility(View.VISIBLE);

                if(isMatching(currColor.get(4),goal.get(4))){
//                        System.out.println("(5)CurrColor = " + currColor.get(4) + " Goal: " + goal.get(4));
                    mCanvasReel5.setMatchingStatus(true);
                }
            }
        });

    }

    private void setFirstGoalTrue(){
        setFirstGoal = true;
    }

    private void setFirstGoalFalse(){
        setFirstGoal = false;
    }

    private void setNewGoalTrue(){
        setNewGoal = true;
    }

    private void setNewGoalFalse(){
        setNewGoal = false;
    }

    private boolean isMatching(String hexColor, String goalHexColor){
        boolean isEqual = hexColor.equals(goalHexColor);

        return isEqual;
    }

    private void unlockReels(boolean reel1, boolean reel2, boolean reel3, boolean reel4, boolean reel5,
                             boolean match1, boolean match2, boolean match3, boolean match4, boolean match5, boolean allMatching) {

        if(allMatching){
            reelLock1.setVisibility(View.INVISIBLE);
            reelLock2.setVisibility(View.INVISIBLE);
            reelLock3.setVisibility(View.INVISIBLE);
            reelLock4.setVisibility(View.INVISIBLE);
            reelLock5.setVisibility(View.INVISIBLE);
            mCanvasReel1.setLockStatus(false);
            mCanvasReel2.setLockStatus(false);
            mCanvasReel3.setLockStatus(false);
            mCanvasReel4.setLockStatus(false);
            mCanvasReel5.setLockStatus(false);

        }else{
            System.out.println("reel1: " + reel1 + " match1: " + match1 );
            System.out.println("reel2: " + reel2 + " match2: " + match2 );
            System.out.println("reel3: " + reel3 + " match3: " + match3 );
            System.out.println("reel4: " + reel4 + " match4: " + match4 );
            System.out.println("reel5: " + reel5 + " match5: " + match5 );
            if(reel1 && !match1){
                reelLock1.setVisibility(View.INVISIBLE);
                mCanvasReel1.setLockStatus(false);
            }
            if(reel2 && !match2){
                reelLock2.setVisibility(View.INVISIBLE);
                mCanvasReel2.setLockStatus(false);
            }
            if(reel3 && !match3){
                reelLock3.setVisibility(View.INVISIBLE);
                mCanvasReel3.setLockStatus(false);
            }
            if(reel4 && !match4){
                reelLock4.setVisibility(View.INVISIBLE);
                mCanvasReel4.setLockStatus(false);
            }
            if(reel5 && !match5){
                reelLock5.setVisibility(View.INVISIBLE);
                mCanvasReel5.setLockStatus(false);
            }
        }

    }

    private void showConfirmExit(){

        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.exit_popup);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_popup);

        Button btnClose = dialog.findViewById(R.id.btn_cancel);
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
                Intent mIntent;
                mIntent = new Intent(MainActivity.this, SelectLevel.class);
                startActivity(mIntent);
                finish();
            }
        });

        dialog.show();

    }

    private class Metronome extends TimerTask {

        @Override
        public void run() {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    Random rand = new Random();

                    int upperbound = pReel1.size();
                    int randomNum = rand.nextInt(upperbound);

                    // Initialize Goal
                    if(setFirstGoal){
                        for(int i=0;i<5;i++)
                        {
                            currColor.add(" ");
                        }
                        goal.add(pReel1.get(randomNum));
                        goal.add(pReel2.get(randomNum));
                        goal.add(pReel3.get(randomNum));
                        goal.add(pReel4.get(randomNum));
                        goal.add(pReel5.get(randomNum));

                        mCanvasReel1.changeGoalColor(pReel1.get(randomNum));
                        mCanvasReel2.changeGoalColor(pReel2.get(randomNum));
                        mCanvasReel3.changeGoalColor(pReel3.get(randomNum));
                        mCanvasReel4.changeGoalColor(pReel4.get(randomNum));
                        mCanvasReel5.changeGoalColor(pReel5.get(randomNum));
                        setFirstGoalFalse();
                        setNewGoalFalse();
                    }

                    // IF ALL MATCHING
//                    System.out.println("(1)CurrColor = " + currColor.get(0) + " Goal: " + goal.get(0));
//                    System.out.println("(2)CurrColor = " + currColor.get(1) + " Goal: " + goal.get(1));
//                    System.out.println("(3)CurrColor = " + currColor.get(2) + " Goal: " + goal.get(2));
//                    System.out.println("(4)CurrColor = " + currColor.get(3) + " Goal: " + goal.get(3));
//                    System.out.println("(5)CurrColor = " + currColor.get(4) + " Goal: " + goal.get(4));

                    if(mCanvasReel1.isMatchingStatus() && mCanvasReel2.isMatchingStatus() && mCanvasReel3.isMatchingStatus() &&
                        mCanvasReel4.isMatchingStatus() && mCanvasReel5.isMatchingStatus())
                    {
                        allMatching = true;
                        // Set New Goal
                        setNewGoalTrue();
                        mCanvasReel1.setMatchingStatus(false);
                        mCanvasReel2.setMatchingStatus(false);
                        mCanvasReel3.setMatchingStatus(false);
                        mCanvasReel4.setMatchingStatus(false);
                        mCanvasReel5.setMatchingStatus(false);
                        mCanvasReel1.setLockStatus(false);
                        mCanvasReel2.setLockStatus(false);
                        mCanvasReel3.setLockStatus(false);
                        mCanvasReel4.setLockStatus(false);
                        mCanvasReel5.setLockStatus(false);
                    }

                    // Test only
                    testCounter++;
                    System.out.println("Test Counter = " + testCounter);

//                    // Test Only
//                    if(testCounter % 10 == 0){
//                        setNewGoalTrue();
//                    }

                    // Unlocking all reels
                    if(currentCount == 4) {
                        // Counting  from 1
                        currentCount = 1;
                        // Check if all matching / some are matching
                        unlockReels(mCanvasReel1.getLockStatus(),mCanvasReel2.getLockStatus(),mCanvasReel3.getLockStatus(),mCanvasReel4.getLockStatus(),mCanvasReel5.getLockStatus(),
                                    mCanvasReel1.isMatchingStatus(),mCanvasReel2.isMatchingStatus(),mCanvasReel3.isMatchingStatus(),mCanvasReel4.isMatchingStatus(),mCanvasReel5.isMatchingStatus(), allMatching);
                    }else currentCount++;

                    // If All Matching --> Set a new Goal
                    if(setNewGoal){

                        // Reset
                        reelLock1.setVisibility(View.VISIBLE);
                        reelLock2.setVisibility(View.VISIBLE);
                        reelLock3.setVisibility(View.VISIBLE);
                        reelLock4.setVisibility(View.VISIBLE);
                        reelLock5.setVisibility(View.VISIBLE);

                        goal.set(0,pReel1.get(randomNum));
                        goal.set(1,pReel2.get(randomNum));
                        goal.set(2,pReel3.get(randomNum));
                        goal.set(3,pReel4.get(randomNum));
                        goal.set(4,pReel5.get(randomNum));
                        mCanvasReel1.changeGoalColor(pReel1.get(randomNum));
                        mCanvasReel2.changeGoalColor(pReel2.get(randomNum));
                        mCanvasReel3.changeGoalColor(pReel3.get(randomNum));
                        mCanvasReel4.changeGoalColor(pReel4.get(randomNum));
                        mCanvasReel5.changeGoalColor(pReel5.get(randomNum));

                        // Swap Colors
                        // Reels 1 - 5 random num gen
                        randomNum = rand.nextInt(upperbound);
                        currColor.set(0,pReel1.get(randomNum));
                        mCanvasReel1.swapColor(pReel1.get(randomNum), mCanvasReel1.isLocked());
                        randomNum = rand.nextInt(upperbound);
                        currColor.set(1,pReel2.get(randomNum));
                        mCanvasReel2.swapColor(pReel2.get(randomNum), mCanvasReel2.isLocked());
                        randomNum = rand.nextInt(upperbound);
                        currColor.set(2,pReel3.get(randomNum));
                        mCanvasReel3.swapColor(pReel3.get(randomNum), mCanvasReel3.isLocked());
                        randomNum = rand.nextInt(upperbound);
                        currColor.set(3,pReel4.get(randomNum));
                        mCanvasReel4.swapColor(pReel4.get(randomNum), mCanvasReel4.isLocked());
                        randomNum = rand.nextInt(upperbound);
                        currColor.set(4,pReel5.get(randomNum));
                        mCanvasReel5.swapColor(pReel5.get(randomNum), mCanvasReel5.isLocked());


                        setNewGoalFalse();
                        allMatching = false;
                    }else{
                        // Swap Colors
                        // Reels 1 - 5 random num gen
                        randomNum = rand.nextInt(upperbound);
                        currColor.set(0,pReel1.get(randomNum));
                        mCanvasReel1.swapColor(pReel1.get(randomNum), mCanvasReel1.isLocked());
                        randomNum = rand.nextInt(upperbound);
                        currColor.set(1,pReel2.get(randomNum));
                        mCanvasReel2.swapColor(pReel2.get(randomNum), mCanvasReel2.isLocked());
                        randomNum = rand.nextInt(upperbound);
                        currColor.set(2,pReel3.get(randomNum));
                        mCanvasReel3.swapColor(pReel3.get(randomNum), mCanvasReel3.isLocked());
                        randomNum = rand.nextInt(upperbound);
                        currColor.set(3,pReel4.get(randomNum));
                        mCanvasReel4.swapColor(pReel4.get(randomNum), mCanvasReel4.isLocked());
                        randomNum = rand.nextInt(upperbound);
                        currColor.set(4,pReel5.get(randomNum));
                        mCanvasReel5.swapColor(pReel5.get(randomNum), mCanvasReel5.isLocked());
                    }



                    counter.setText(String.valueOf(currentCount));



                }
            });

        }
    }
}