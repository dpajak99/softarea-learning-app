package com.softarea.learningapp.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.Note;
import com.softarea.learningapp.utils.StringUtils;

import java.text.SimpleDateFormat;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

  private List<Note> notes;

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public TextView title;
    public TextView date;
    public TextView authorName;
    public ImageView authorImage;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
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

    @SuppressLint("SimpleDateFormat") SimpleDateFormat parseDate = new SimpleDateFormat("yyyy-MM-dd");
    @SuppressLint("SimpleDateFormat") SimpleDateFormat parseTime = new SimpleDateFormat("HH:mm");
    holder.date.setText(StringUtils.join(parseDate.format(note.getCreatedAt()), " \n", parseTime.format(note.getCreatedAt())));

  }

  @Override
  public int getItemCount() {
    return notes.size();
  }
}
