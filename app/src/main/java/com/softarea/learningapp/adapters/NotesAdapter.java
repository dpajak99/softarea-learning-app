package com.softarea.learningapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.Note;
import com.softarea.learningapp.model.User;
import com.softarea.learningapp.utils.BundleUtils;
import com.softarea.learningapp.utils.DatabaseUtils;
import com.softarea.learningapp.utils.StringUtils;

import java.util.List;


public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

  private final FragmentActivity activity;
  private List<Note> notes;
  private Context context;

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

  public NotesAdapter(Context context, FragmentActivity activity, List<Note> notes) {
    this.context = context;
    this.activity = activity;
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
    User author = DatabaseUtils.getDatabase(context).userDAO().getAuthor(note.getAuthor());
    holder.authorName.setText(author.getFullName());
    holder.authorImage.setImageResource(author.getImage());
    holder.date.setText(StringUtils.join(note.getDate(), " \n",note.getTime()));

    holder.contentHolder.setOnClickListener(view -> {
      NavController navController = Navigation.findNavController(activity, R.id.fragment_main);
      navController.navigate(R.id.navigation_show_note, BundleUtils.createSerializableBundle("note", note));
    });
  }

  @Override
  public int getItemCount() {
    return notes.size();
  }
}
