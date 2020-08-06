package com.softarea.learningapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.ToolbarShortcut;

import java.util.List;

import static com.softarea.learningapp.activities.MainActivity.navController;

public class ToolbarShortcutAdapter extends RecyclerView.Adapter<ToolbarShortcutAdapter.ViewHolder> {

  private List<ToolbarShortcut> objects;

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public LinearLayout contentHolder;
    public ImageView icon;
    public TextView title;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      contentHolder = itemView.findViewById(R.id.toolbar_shortcut_card);
      icon = itemView.findViewById(R.id.toolbar_shortcut_image);
      title = itemView.findViewById(R.id.toolbar_shortcut_title);
    }
  }

  public ToolbarShortcutAdapter(List<ToolbarShortcut> objects) {
    this.objects = objects;
  }

  @NonNull
  @Override
  public ToolbarShortcutAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View listItem = layoutInflater.inflate(R.layout.item_shortcut_toolbar, parent, false);
    return new ViewHolder(listItem);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    ToolbarShortcut object = objects.get(position);
    holder.contentHolder.setOnClickListener(v -> navController.navigate(object.getHref()));
    holder.title.setText(object.getTitle());
    holder.icon.setBackgroundResource(object.getImage());

  }

  @Override
  public int getItemCount() {
    return objects.size();
  }
}
