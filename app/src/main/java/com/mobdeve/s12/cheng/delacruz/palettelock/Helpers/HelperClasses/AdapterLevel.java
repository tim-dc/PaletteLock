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

public class AdapterLevel extends RecyclerView.Adapter<AdapterLevel.LevelViewHolder>  {

    ArrayList<Helper> location;
    final private ListItemClickListener mOnClickListener;

    public AdapterLevel(ArrayList<Helper> location, ListItemClickListener listener) {
        this.location = location;
        mOnClickListener = listener;
    }

    @NonNull

    @Override
    public LevelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card_view, parent, false);
        return new LevelViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull LevelViewHolder holder, int position) {


        Helper helper = location.get(position);
        holder.level.setText(helper.getTitle());
    }

    @Override
    public int getItemCount() {
        return location.size();

    }

    public interface ListItemClickListener {
        void onListClick(int clickedItemIndex);
    }

    public class LevelViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView level;
        RelativeLayout relativeLayout;


        public LevelViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            //hooks

            level = itemView.findViewById(R.id.levels);
            relativeLayout = itemView.findViewById(R.id.background);

        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListClick(clickedPosition);
        }
    }

}
