package com.softarea.learningapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.PanelAddItem;

import java.util.List;

public class PanelAddAdapter extends RecyclerView.Adapter<PanelAddAdapter.ViewHolder> {

  private List<PanelAddItem> panelAddItems;
  private FragmentActivity activity;

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public LinearLayout content;
    public TextView name;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      name = itemView.findViewById(R.id.tv_panel_add_title);
      content = itemView.findViewById(R.id.ll_item_add);
    }
  }

  public PanelAddAdapter(FragmentActivity activity, List<PanelAddItem> panelAddItems) {
    this.activity = activity;
    this.panelAddItems = panelAddItems;
  }

  @NonNull
  @Override
  public PanelAddAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
    Context context = parent.getContext();
    LayoutInflater layoutInflater = LayoutInflater.from(context);
    View listItem = layoutInflater.inflate(R.layout.item_panel_add, parent, false);
    return new ViewHolder(listItem);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    PanelAddItem panelAddItem = panelAddItems.get(position);

    holder.name.setText(panelAddItem.getName());

    holder.content.setOnClickListener(view -> {
      if (panelAddItem.getHref() != 0) {
        NavController navController = Navigation.findNavController(activity, R.id.fragment_main);
        navController.navigate(panelAddItem.getHref());
      } else {
        Toast.makeText(activity, "Opcja jeszcze nie dostępna", Toast.LENGTH_SHORT).show();
      }
    });

  }

  @Override
  public int getItemCount() {
    return panelAddItems.size();
  }
}
