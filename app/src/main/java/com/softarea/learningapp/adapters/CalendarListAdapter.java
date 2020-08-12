package com.softarea.learningapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.Event;
import com.softarea.learningapp.utils.CalendarUtils;
import com.softarea.learningapp.utils.StringUtils;

import java.util.List;

public class CalendarListAdapter extends RecyclerView.Adapter<CalendarListAdapter.ViewHolder> {

  private List<Event> events;
  private Context context;

  public static class ViewHolder extends RecyclerView.ViewHolder {
    public TextView calendarEventDay;
    public TextView calendarEventMonth;
    public TextView calendarEventTime;
    public TextView calendarEventAuthor;
    public TextView calendarEventTitle;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);
      calendarEventDay = itemView.findViewById(R.id.calendar_day);
      calendarEventMonth = itemView.findViewById(R.id.calendar_month);
      calendarEventTime = itemView.findViewById(R.id.calendar_time);
      calendarEventAuthor = itemView.findViewById(R.id.calendar_author);
      calendarEventTitle = itemView.findViewById(R.id.calendar_title);
    }
  }

  public CalendarListAdapter(List<Event> events) {
    this.events = events;
  }

  @NonNull
  @Override
  public CalendarListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
    context = parent.getContext();
    LayoutInflater layoutInflater = LayoutInflater.from(context);
    View listItem = layoutInflater.inflate(R.layout.item_calendar_event, parent, false);
    return new ViewHolder(listItem);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    Event event = events.get(position);

    holder.calendarEventDay.setText(String.format("%02d", event.getDay()));
    holder.calendarEventMonth.setText(CalendarUtils.transformMonth(context, event.getMonth()));
    holder.calendarEventTime.setText(StringUtils.join(event.getStartTime(), " - ", event.getEndTime() ));
    holder.calendarEventAuthor.setText(StringUtils.join(event.getAuthor().getFullName()));
    holder.calendarEventTitle.setText(event.getTitle());

  }

  @Override
  public int getItemCount() {
    return events.size();
  }
}
