package com.mobdeve.s12.cheng.delacruz.palettelock.Helpers.HelperClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mobdeve.s12.cheng.delacruz.palettelock.R;

import java.util.ArrayList;

public class AdapterScore extends RecyclerView.Adapter<AdapterScore.ScoreViewHolder>  {

    ArrayList<HelperScore> location;

    public AdapterScore(ArrayList<HelperScore> location) {
        this.location = location;
    }

    @NonNull

    @Override
    public ScoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card_view_score, parent, false);
        return new ScoreViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ScoreViewHolder holder, int position) {


        HelperScore helper = location.get(position);
        holder.score_level.setText(String.valueOf(helper.getScore()));
        holder.level.setText(helper.getLevel());
    }

    @Override
    public int getItemCount() {
        return location.size();

    }

    public class ScoreViewHolder extends RecyclerView.ViewHolder{

        TextView score_level;
        TextView level;
        RelativeLayout relativeLayout;


        public ScoreViewHolder(@NonNull View itemView) {
            super(itemView);
            //hooks

            score_level = itemView.findViewById(R.id.score_level);
            level = itemView.findViewById(R.id.levelText);
            relativeLayout = itemView.findViewById(R.id.background);

        }

    }

}
