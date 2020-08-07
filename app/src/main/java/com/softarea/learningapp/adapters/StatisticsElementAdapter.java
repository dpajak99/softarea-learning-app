package com.softarea.learningapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.StatisticsElement;

import java.util.List;

public class StatisticsElementAdapter extends RecyclerView.Adapter<StatisticsElementAdapter.ViewHolder> {

  private List<StatisticsElement> statisticsElements;

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public TextView amount;
    public ImageView image;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      title = itemView.findViewById(R.id.statistics_title);
      amount = itemView.findViewById(R.id.statistics_amount);
      image = itemView.findViewById(R.id.statistics_image);
    }
  }

  public StatisticsElementAdapter(List<StatisticsElement> statisticsElements) {
    this.statisticsElements = statisticsElements;
  }

  @NonNull
  @Override
  public StatisticsElementAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View listItem = layoutInflater.inflate(R.layout.item_statictics_element, parent, false);
    return new ViewHolder(listItem);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    StatisticsElement statisticsElement = statisticsElements.get(position);
    holder.title.setText(statisticsElement.getName());
    holder.amount.setText(String.valueOf(statisticsElement.getAmount()));
    holder.image.setImageResource(statisticsElement.getIcon());

  }

  @Override
  public int getItemCount() {
    return statisticsElements.size();
  }
}
