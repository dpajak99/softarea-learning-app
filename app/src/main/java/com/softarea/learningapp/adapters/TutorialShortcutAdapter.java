package com.softarea.learningapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.TutorialShortcut;
import com.softarea.learningapp.utils.StringUtils;

import java.util.List;

public class TutorialShortcutAdapter extends RecyclerView.Adapter<TutorialShortcutAdapter.ViewHolder> {

  private List<TutorialShortcut> tutorialShortcuts;

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public TextView statusMessage;
    public TextView progress;
    public ImageView statusImage;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      title = itemView.findViewById(R.id.tutorial_title);
      statusMessage = itemView.findViewById(R.id.tutorial_status_message);
      progress = itemView.findViewById(R.id.tutorial_progress);
      statusImage = itemView.findViewById(R.id.tutorial_status_icon);
    }
  }

  public TutorialShortcutAdapter(List<TutorialShortcut> objects) {
    this.tutorialShortcuts = objects;
  }

  @NonNull
  @Override
  public TutorialShortcutAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View listItem = layoutInflater.inflate(R.layout.item_shortcut_tutorial, parent, false);
    return new ViewHolder(listItem);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    TutorialShortcut tutorialShortcut = tutorialShortcuts.get(position);
    holder.title.setText(tutorialShortcut.getTitle());
    if( tutorialShortcut.getCurrentTask() == 0 ) {
      holder.statusMessage.setText(R.string.tutorial_not_started);
      holder.statusImage.setImageResource(R.drawable.ic_not_finished);
    } else if( tutorialShortcut.getCurrentTask() < tutorialShortcut.getMaxTasks() ) {
      holder.statusMessage.setText(R.string.tutorial_not_finished);
      holder.statusImage.setImageResource(R.drawable.ic_not_finished);
    } else {
      holder.statusMessage.setText(R.string.tutorial_finished);
      holder.statusImage.setImageResource(R.drawable.ic_ok);
    }

    holder.progress.setText(StringUtils.join(String.valueOf(tutorialShortcut.getCurrentTask()), "/", String.valueOf(tutorialShortcut.getMaxTasks()) ));


  }

  @Override
  public int getItemCount() {
    return tutorialShortcuts.size();
  }
}
