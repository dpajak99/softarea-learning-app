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

  private List<TutorialShortcut> objects;

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public TextView tutorialTitle;
    public TextView tutorialStatusMessage;
    public TextView tutorialProgress;
    public ImageView tutorialStatusImage;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      tutorialTitle = itemView.findViewById(R.id.tutorial_title);
      tutorialStatusMessage = itemView.findViewById(R.id.tutorial_status_message);
      tutorialProgress = itemView.findViewById(R.id.tutorial_progress);
      tutorialStatusImage = itemView.findViewById(R.id.tutorial_status_icon);
    }
  }

  public TutorialShortcutAdapter(List<TutorialShortcut> objects) {
    this.objects = objects;
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
    TutorialShortcut tutorialShortcut = objects.get(position);
    holder.tutorialTitle.setText(tutorialShortcut.getTitle());
    if( tutorialShortcut.getCurrentTask() == 0 ) {
      holder.tutorialStatusMessage.setText("Nie rozpoczęto!");
      holder.tutorialStatusImage.setImageResource(R.drawable.ic_not_finished);
    } else if( tutorialShortcut.getCurrentTask() < tutorialShortcut.getMaxTasks() ) {
      holder.tutorialStatusMessage.setText("Nie ukończono!");
      holder.tutorialStatusImage.setImageResource(R.drawable.ic_not_finished);
    } else {
      holder.tutorialStatusMessage.setText("Ukończono!");
      holder.tutorialStatusImage.setImageResource(R.drawable.ic_ok);
    }

    holder.tutorialProgress.setText(StringUtils.join(String.valueOf(tutorialShortcut.getCurrentTask()), "/", String.valueOf(tutorialShortcut.getMaxTasks()) ));


  }

  @Override
  public int getItemCount() {
    return objects.size();
  }
}
