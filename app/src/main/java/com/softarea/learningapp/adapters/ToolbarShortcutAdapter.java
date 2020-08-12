package com.softarea.learningapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.ToolbarShortcut;

import java.util.List;


public class ToolbarShortcutAdapter extends RecyclerView.Adapter<ToolbarShortcutAdapter.ViewHolder> {

  private final FragmentActivity activity;
  private List<ToolbarShortcut> toolbarShortcuts;

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

  public ToolbarShortcutAdapter(FragmentActivity activity, List<ToolbarShortcut> objects) {
    this.activity = activity;
    this.toolbarShortcuts = objects;
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
    ToolbarShortcut object = toolbarShortcuts.get(position);
    NavController navController = Navigation.findNavController(activity, R.id.fragment_main);
    holder.contentHolder.setOnClickListener(v -> navController.navigate(object.getHref()));
    holder.title.setText(object.getTitle());
    holder.icon.setBackgroundResource(object.getImage());

  }

  @Override
  public int getItemCount() {
    return toolbarShortcuts.size();
  }
}
