package com.mobdeve.s12.cheng.delacruz.palettelock;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    SelectLevel selectLevel;

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

    private int timeCounter = 0;

    private int testCounter = 0;
    private int currentCount=0;
    public int level;

    ImageView reelLock1;
    ImageView reelLock2;
    ImageView reelLock3;
    ImageView reelLock4;
    ImageView reelLock5;

    TextView counter;
    TextView score;

    Timer timer;

    private int currentScore = 0;

    private boolean setFirstGoal = true;
    private boolean setNewGoal = true;
    private boolean allMatching = false;

    //public static final int GAME_LEVEL = 0;

    ScoreDatabase scoreDB;
    ScoreModel scoreModel = new ScoreModel();;

    MediaPlayer player;

    public int blackSwan1;
    public int blackSwan2;
    public int blackSwan3;

    public int blackSwanDelay;
    public int blackSwanDelay2;

    // For Chances

    public int baseChance;
    public int numReelsCorrect = 0;
    public int numPalettesComplete = 0;
    public int measureCounter = 1;
    public int additionalChance;
    public int totalChance;
    public int goalIndex;
    public int prevIndex=0;

//    private TextView counterText = (TextView)findViewById(R.id.counter);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        level = intent.getIntExtra(SelectLevel.GAME_LEVEL, 1);
        System.out.println(level);

        scoreDB = new ScoreDatabase(this);

        timer = new Timer();
        Metronome metronome = new Metronome();
        // based on BPM

        play();

        //blackSwan1 = 1200;
        //blackSwan2 = 2400;

        blackSwan1 = 937; // 64bpm
        blackSwan2 = 1874; // 32bpm
        blackSwan3 = 469; // 128 bpm

        blackSwanDelay = 3400;

        // period is key
        timer.schedule(metronome,
                blackSwanDelay,
                blackSwan1);

        counter = findViewById(R.id.counter);
        score = findViewById(R.id.score);
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

        // Color Palletes (Color 1,2,3,4,5) --->

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

                    numReelsCorrect++;
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

                    numReelsCorrect++;
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
                    numReelsCorrect++;
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
                    numReelsCorrect++;
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
                    numReelsCorrect++;
                    mCanvasReel5.setMatchingStatus(true);
                }
            }
        });

    }

    public void play(){
        if(player == null)
        {
            player = MediaPlayer.create(this, R.raw.black_swan);

            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();
                }
            });
        }

        player.start();
    }

    private void stopPlayer(){
        if (player != null)
        {
            player.release();
            player = null;
        }
    }

//    public void playCorrectLock(){
//        if(player == null)
//        {
//            player = MediaPlayer.create(this, R.raw.correctLock);
//
//            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                @Override
//                public void onCompletion(MediaPlayer mp) {
//                    stopPlayer();
//                }
//            });
//        }
//
//        player.start();
//    }

//    public void playWrongLock(){
//        if(player == null)
//        {
//            player = MediaPlayer.create(this, R.raw.wrongLock);
//
//            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                @Override
//                public void onCompletion(MediaPlayer mp) {
//                    stopPlayer();
//                }
//            });
//        }
//
//        player.start();
//    }


    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
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
//            System.out.println("reel1: " + reel1 + " match1: " + match1 );
//            System.out.println("reel2: " + reel2 + " match2: " + match2 );
//            System.out.println("reel3: " + reel3 + " match3: " + match3 );
//            System.out.println("reel4: " + reel4 + " match4: " + match4 );
//            System.out.println("reel5: " + reel5 + " match5: " + match5 );
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
                stopPlayer();
                timer.cancel();
                finish();
            }
        });

        dialog.show();

    }

    private boolean produceRightColor(int totalChance){

        Random rand = new Random();

        int number = rand.nextInt(100);



        // TEST --
        // number = 43
        // totalChance = 50/100
        // if number < total Chance --> because totalChance 50% of numbers etc etc encapsualtes 0-50

        if(number <= totalChance){
//            System.out.println("RANDOM NUMBER = " + number + " WITH A CHANCE OF = " + totalChance + "% -- SUCCESS");
            return true;
        }else {
//            System.out.println("RANDOM NUMBER = " + number + " WITH A CHANCE OF = " + totalChance + "% -- FAILED");
            return false;
        }
    }

    public void addData(int score, int level)
    {
        boolean insertData = scoreDB.addData(score, level);

        if(insertData)
        {
            System.out.println("Success");
        }
        else
        {
            System.out.println("Fail");
        }
    }

    private void showGameOver(){
        Dialog dialog = new Dialog(this, R.style.DialogStyle);
        dialog.setContentView(R.layout.game_over_popup);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_popup);
        Button btnOk = dialog.findViewById(R.id.btn_ok);
        TextView score = dialog.findViewById(R.id.txtScore);
        dialog.setCanceledOnTouchOutside(false);
        //dialog.setCancelable(false);

        score.setText(String.valueOf(currentScore));

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
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
                    int randomColor = 0;


                    /*long now = System.currentTimeMillis(); // current time in ms
                    time -= now; // adjust remaining time

                    if (time == 0) {
                        // Stop updating now.

                        timer.cancel();

                        System.out.println("END TIMER!");
                    }*/

                    timeCounter++;

                    if (timeCounter >= 60) // change the 30 to the length of music
                    {
                        System.out.println("END TIMER!");
                        scoreModel.setScore(currentScore);
                        scoreModel.setLevel(level);
                        System.out.println(level);
                        addData(currentScore, level);
                        timer.cancel();
                        showGameOver();
                    }


                    // Initialize Goal
                    if(setFirstGoal){
                        // Populate array with blank values
                        for(int i=0;i<5;i++)
                        {
                            currColor.add(" ");
                        }

                        // randomNum = index of goal colors
                        goalIndex = randomNum;
                        prevIndex = goalIndex;
                        goal.add(pReel1.get(goalIndex));
                        goal.add(pReel2.get(goalIndex));
                        goal.add(pReel3.get(goalIndex));
                        goal.add(pReel4.get(goalIndex));
                        goal.add(pReel5.get(goalIndex));

                        // Changes the goal circles to the goalIndex color
                        mCanvasReel1.changeGoalColor(pReel1.get(goalIndex));
                        mCanvasReel2.changeGoalColor(pReel2.get(goalIndex));
                        mCanvasReel3.changeGoalColor(pReel3.get(goalIndex));
                        mCanvasReel4.changeGoalColor(pReel4.get(goalIndex));
                        mCanvasReel5.changeGoalColor(pReel5.get(goalIndex));

                        // Sentinel Values
                        setFirstGoalFalse();
                        setNewGoalFalse();
                    }


                    // If all reels are correct
                    if(mCanvasReel1.isMatchingStatus() && mCanvasReel2.isMatchingStatus() && mCanvasReel3.isMatchingStatus() &&
                        mCanvasReel4.isMatchingStatus() && mCanvasReel5.isMatchingStatus())
                    {
                        allMatching = true;

//                        playCorrectLock();

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

                        numPalettesComplete++;
                        if (numPalettesComplete != 0)
                        {
                            prevIndex = goalIndex;
                        }

                        // Scoring System
                        currentScore++;
                        score.setText(String.valueOf(currentScore));
                    }

                    // Unlocking all reels
                    if(currentCount == 4) {

                        // Measure Counter
                        measureCounter++;

                        // Counting from 1 (beats in a measure)
                        currentCount = 1;

                        // Check if all matching / some are matching
                        unlockReels(mCanvasReel1.getLockStatus(),mCanvasReel2.getLockStatus(),mCanvasReel3.getLockStatus(),mCanvasReel4.getLockStatus(),mCanvasReel5.getLockStatus(),
                                    mCanvasReel1.isMatchingStatus(),mCanvasReel2.isMatchingStatus(),mCanvasReel3.isMatchingStatus(),mCanvasReel4.isMatchingStatus(),mCanvasReel5.isMatchingStatus(), allMatching);
                    }else currentCount++;



                    // Set Base Chances based on Measure Num
                    if(measureCounter == 1){
                        baseChance = 20;
                    }else if (measureCounter == 3){
                        baseChance = 21;
                    }else if (measureCounter == 5){
                        baseChance = 22;
                    }else if (measureCounter == 7){
                        baseChance = 25;
                    }else if (measureCounter == 9){
                        baseChance = 27;
                    }else if (measureCounter == 11){
                        baseChance = 31;
                    }else if (measureCounter == 13){
                        baseChance = 34;
                    }else if (measureCounter > 14){
                        baseChance = 36;
                    }

                    additionalChance =0;

                    // Additional Chances
                    switch (numReelsCorrect){
                        case 4: additionalChance += 6;
                        case 3: additionalChance += 4;
                        case 2: additionalChance += 3;
                        case 1: additionalChance += 2;
                        case 0: additionalChance += 1;
                        default: break;
                    }
                    System.out.println("Num Wheels Correct = " + numReelsCorrect + " baseChance = " + baseChance + " additionalChance = " + additionalChance);
                    // Max Chance = 47 + 18 = 65%

                    // If prompted to change goal palette
                    if(setNewGoal){
                        goalIndex = randomNum;

                        // Reset lock visibility
                        reelLock1.setVisibility(View.INVISIBLE);
                        reelLock2.setVisibility(View.INVISIBLE);
                        reelLock3.setVisibility(View.INVISIBLE);
                        reelLock4.setVisibility(View.INVISIBLE);
                        reelLock5.setVisibility(View.INVISIBLE);

                        // Get a random color palette for GOAL and STORE it
                        goal.set(0,pReel1.get(goalIndex));
                        goal.set(1,pReel2.get(goalIndex));
                        goal.set(2,pReel3.get(goalIndex));
                        goal.set(3,pReel4.get(goalIndex));
                        goal.set(4,pReel5.get(goalIndex));

                        // Change the goal circles to the given color
                        mCanvasReel1.changeGoalColor(pReel1.get(goalIndex));
                        mCanvasReel2.changeGoalColor(pReel2.get(goalIndex));
                        mCanvasReel3.changeGoalColor(pReel3.get(goalIndex));
                        mCanvasReel4.changeGoalColor(pReel4.get(goalIndex));
                        mCanvasReel5.changeGoalColor(pReel5.get(goalIndex));


                        // Swap Colors

                        // Reset Chances to base chances
                        additionalChance = 0;
                        numReelsCorrect = 0;


                        // Reels 1 - 5 random num gen

                        // Reel 1
                        // REDUCED CHANCE OF GETTING A MATCH COLOR to 10%
                        int reducedChance = 10;
                        // Random Num Gen 0-100 for chance
                        if(produceRightColor(reducedChance)){
                            currColor.set(0,pReel1.get(goalIndex));
                            mCanvasReel1.swapColor(pReel1.get(goalIndex), mCanvasReel1.isLocked());
                        }else {
                            // Any other color
                            randomColor = rand.nextInt(upperbound);
                            if(prevIndex == randomColor){
                            }else{
                                currColor.set(0,pReel1.get(randomColor));
                                mCanvasReel1.swapColor(pReel1.get(randomColor), mCanvasReel1.isLocked());
                            }
                        }

                        // Reel 2
                        if(produceRightColor(reducedChance)){
                            currColor.set(1,pReel2.get(goalIndex));
                            mCanvasReel2.swapColor(pReel2.get(goalIndex), mCanvasReel2.isLocked());
                        }else {
                            // Any other color
                            randomColor = rand.nextInt(upperbound);
                            if(prevIndex == randomColor){
                            }else {
                                currColor.set(1, pReel2.get(randomColor));
                                mCanvasReel2.swapColor(pReel2.get(randomColor), mCanvasReel2.isLocked());
                            }
                        }

                        // Reel 3
                        if(produceRightColor(reducedChance)){
                            currColor.set(2,pReel3.get(goalIndex));
                            mCanvasReel3.swapColor(pReel3.get(goalIndex), mCanvasReel3.isLocked());
                        }else {
                            // Any other color
                            randomColor = rand.nextInt(upperbound);
                            if(prevIndex == randomColor){
                            }else {
                                currColor.set(2, pReel3.get(randomColor));
                                mCanvasReel3.swapColor(pReel3.get(randomColor), mCanvasReel3.isLocked());
                            }
                        }

                        // Reel 4
                        if(produceRightColor(reducedChance)){
                            currColor.set(3,pReel4.get(goalIndex));
                            mCanvasReel4.swapColor(pReel4.get(goalIndex), mCanvasReel4.isLocked());
                        }else {
                            // Any other color
                            randomColor = rand.nextInt(upperbound);
                            if(prevIndex == randomColor){
                            }else {
                                currColor.set(3, pReel4.get(randomColor));
                                mCanvasReel4.swapColor(pReel4.get(randomColor), mCanvasReel4.isLocked());
                            }
                        }

                        // Reel 5
                        if(produceRightColor(reducedChance)){
                            currColor.set(4,pReel5.get(goalIndex));
                            mCanvasReel5.swapColor(pReel5.get(goalIndex), mCanvasReel5.isLocked());
                        }else {
                            // Any other color
                            randomColor = rand.nextInt(upperbound);
                            if(prevIndex == randomColor){
                            }else {
                                currColor.set(4, pReel5.get(randomColor));
                                mCanvasReel5.swapColor(pReel5.get(randomColor), mCanvasReel5.isLocked());
                            }
                        }

                        setNewGoalFalse();
                        allMatching = false;
                    }else{

                        // REGULAR SWAPPING

                        // Put Chances here
                        totalChance = baseChance + additionalChance;

                        // Pass totalChance to produceRightColor()

                        // Swap Colors if number ends up within 0 to totalChance range

                        // Reel 1
                        // Random Num Gen 0-100 for chance
                        if(produceRightColor(totalChance)){
                            currColor.set(0,pReel1.get(goalIndex));
                            mCanvasReel1.swapColor(pReel1.get(goalIndex), mCanvasReel1.isLocked());
                        }else {
                            // Any other color
                            randomColor = rand.nextInt(upperbound);
                            if(prevIndex == randomColor){
                            }else {
                                currColor.set(0, pReel1.get(randomColor));
                                mCanvasReel1.swapColor(pReel1.get(randomColor), mCanvasReel1.isLocked());
                            }
                        }

                        // Reel 2
                        if(produceRightColor(totalChance)){
                            currColor.set(1,pReel2.get(goalIndex));
                            mCanvasReel2.swapColor(pReel2.get(goalIndex), mCanvasReel2.isLocked());
                        }else {
                            // Any other color
                            randomColor = rand.nextInt(upperbound);
                            if(prevIndex == randomColor){
                            }else {
                                currColor.set(1, pReel2.get(randomColor));
                                mCanvasReel2.swapColor(pReel2.get(randomColor), mCanvasReel2.isLocked());
                            }
                        }

                        // Reel 3
                        if(produceRightColor(totalChance)){
                            currColor.set(2,pReel3.get(goalIndex));
                            mCanvasReel3.swapColor(pReel3.get(goalIndex), mCanvasReel3.isLocked());
                        }else {
                            // Any other color
                            randomColor = rand.nextInt(upperbound);
                            if(prevIndex == randomColor){
                            }else {
                                currColor.set(2, pReel3.get(randomColor));
                                mCanvasReel3.swapColor(pReel3.get(randomColor), mCanvasReel3.isLocked());
                            }
                        }

                        // Reel 4
                        if(produceRightColor(totalChance)){
                            currColor.set(3,pReel4.get(goalIndex));
                            mCanvasReel4.swapColor(pReel4.get(goalIndex), mCanvasReel4.isLocked());
                        }else {
                            // Any other color
                            randomColor = rand.nextInt(upperbound);
                            if(prevIndex == randomColor){
                            }else {
                                currColor.set(3, pReel4.get(randomColor));
                                mCanvasReel4.swapColor(pReel4.get(randomColor), mCanvasReel4.isLocked());
                            }
                        }

                        // Reel 5
                        if(produceRightColor(totalChance)){
                            currColor.set(4,pReel5.get(goalIndex));
                            mCanvasReel5.swapColor(pReel5.get(goalIndex), mCanvasReel5.isLocked());
                        }else {
                            // Any other color
                            randomColor = rand.nextInt(upperbound);
                            if(prevIndex == randomColor){
                            }else {
                                currColor.set(4, pReel5.get(randomColor));
                                mCanvasReel5.swapColor(pReel5.get(randomColor), mCanvasReel5.isLocked());
                            }
                        }

                    }



                    counter.setText(String.valueOf(currentCount));
                }
            });

        }
    }
}