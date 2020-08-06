package com.softarea.learningapp.adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.Note;
import com.softarea.learningapp.utils.DateUtils;
import com.softarea.learningapp.utils.StringUtils;

import java.util.List;

import static com.softarea.learningapp.activities.MainActivity.navController;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

  private List<Note> notes;

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public CardView contentHolder;
    public TextView title;
    public TextView date;
    public TextView authorName;
    public ImageView authorImage;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      contentHolder = itemView.findViewById(R.id.content_holder);
      title = itemView.findViewById(R.id.note_title);
      date = itemView.findViewById(R.id.note_date);
      authorName = itemView.findViewById(R.id.note_author_name);
      authorImage = itemView.findViewById(R.id.note_author_image);
    }
  }

  public NotesAdapter(List<Note> notes) {
    this.notes = notes;
  }

  @NonNull
  @Override
  public NotesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View listItem = layoutInflater.inflate(R.layout.item_note, parent, false);
    return new ViewHolder(listItem);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    Note note = notes.get(position);
    holder.title.setText(note.getTitle());
    holder.authorName.setText(note.getAuthor().getFullName());
    holder.authorImage.setImageResource(note.getAuthor().getImage());
    holder.date.setText(StringUtils.join(DateUtils.parseDate(note.getCreatedAt()), " \n",DateUtils.parseTime(note.getCreatedAt())));

    holder.contentHolder.setOnClickListener(view -> {
      Bundle result = new Bundle();
      result.putSerializable("note", note);

      navController.navigate(R.id.navigation_show_note, result);
    });

  }

  @Override
  public int getItemCount() {
    return notes.size();
  }
}
