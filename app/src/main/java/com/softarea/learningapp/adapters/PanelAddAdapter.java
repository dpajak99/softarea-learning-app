package com.softarea.learningapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.PanelAddItem;

import java.util.List;

public class PanelAddAdapter extends RecyclerView.Adapter<PanelAddAdapter.ViewHolder> {

  private List<PanelAddItem> panelAddItems;
  private Context context;

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public TextView name;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      name = itemView.findViewById(R.id.tv_panel_add_title);
    }
  }

  public PanelAddAdapter(List<PanelAddItem> panelAddItems) {
    this.panelAddItems = panelAddItems;
  }

  @NonNull
  @Override
  public PanelAddAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
    context = parent.getContext();
    LayoutInflater layoutInflater = LayoutInflater.from(context);
    View listItem = layoutInflater.inflate(R.layout.item_panel_add, parent, false);
    return new ViewHolder(listItem);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    PanelAddItem panelAddItem = panelAddItems.get(position);

    holder.name.setText(panelAddItem.getName());
  }

  @Override
  public int getItemCount() {
    return panelAddItems.size();
  }
}