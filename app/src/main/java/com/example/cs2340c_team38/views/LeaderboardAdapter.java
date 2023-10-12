package com.example.cs2340c_team38.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.cs2340c_team38.model.Leaderboard;

import com.example.cs2340c_team38.R;

import java.text.SimpleDateFormat;
import java.util.List;

public class LeaderboardAdapter extends BaseAdapter {
    private List<Leaderboard.ScoreEntry> scores;
    private LayoutInflater inflater;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    public LeaderboardAdapter(Context context, List<Leaderboard.ScoreEntry> scores) {
        this.scores = scores;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return scores.size();
    }

    @Override
    public Object getItem(int position) {
        return scores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.leaderboard_entry, parent, false);
        }

        TextView playerNameTextView = view.findViewById(R.id.playerNameTextView);
        TextView scoreTextView = view.findViewById(R.id.scoreTextView);
        TextView dateTextView = view.findViewById(R.id.dateTextView);

        Leaderboard.ScoreEntry entry = scores.get(position);
        playerNameTextView.setText(entry.getPlayerName());
        scoreTextView.setText(String.valueOf(entry.getScore()));
        dateTextView.setText(dateFormat.format(entry.getDateTime()));

        return view;
    }
}

