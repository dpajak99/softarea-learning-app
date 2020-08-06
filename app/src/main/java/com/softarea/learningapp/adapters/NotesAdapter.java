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
    public TextView noteTitle;
    public TextView noteDate;
    public TextView noteAuthorName;
    public ImageView noteAuthorImage;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      noteTitle = itemView.findViewById(R.id.note_title);
      noteDate = itemView.findViewById(R.id.note_date);
      noteAuthorName = itemView.findViewById(R.id.note_author_name);
      noteAuthorImage = itemView.findViewById(R.id.note_author_image);
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
    holder.noteTitle.setText(note.getTitle());
    holder.noteAuthorName.setText(note.getAuthor().getFullName());
    holder.noteAuthorImage.setImageResource(note.getAuthor().getImage());

    @SuppressLint("SimpleDateFormat") SimpleDateFormat parseDate = new SimpleDateFormat("yyyy-MM-dd");
    @SuppressLint("SimpleDateFormat") SimpleDateFormat parseTime = new SimpleDateFormat("HH:mm");
    holder.noteDate.setText(StringUtils.join(parseDate.format(note.getCreated_at()), " \n", parseTime.format(note.getCreated_at())));

  }

  @Override
  public int getItemCount() {
    return notes.size();
  }
}
