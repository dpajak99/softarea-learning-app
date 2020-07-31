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
import com.softarea.learningapp.model.TutorialShortcut;
import com.softarea.learningapp.utils.StringUtils;

import java.util.List;

public class StatisticsElementAdapter extends RecyclerView.Adapter<StatisticsElementAdapter.ViewHolder> {

  private List<StatisticsElement> statisticsElements;

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public TextView statisticsTitle;
    public TextView statisticsAmount;
    public ImageView statisticImage;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      statisticsTitle = itemView.findViewById(R.id.statistics_title);
      statisticsAmount = itemView.findViewById(R.id.statistics_amount);
      statisticImage = itemView.findViewById(R.id.statistics_image);
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
    holder.statisticsTitle.setText(statisticsElement.getName());
    holder.statisticsAmount.setText(String.valueOf(statisticsElement.getAmount()));
    holder.statisticImage.setImageResource(statisticsElement.getIcon());

  }

  @Override
  public int getItemCount() {
    return statisticsElements.size();
  }
}
