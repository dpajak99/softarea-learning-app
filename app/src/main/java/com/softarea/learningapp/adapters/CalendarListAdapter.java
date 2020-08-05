package com.softarea.learningapp.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.CalendarEvent;
import com.softarea.learningapp.utils.CalendarUtils;
import com.softarea.learningapp.utils.StringUtils;

import java.util.List;

public class CalendarListAdapter extends RecyclerView.Adapter<CalendarListAdapter.ViewHolder> {

  private List<CalendarEvent> calendarEvents;

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

  public CalendarListAdapter(List<CalendarEvent> tutorialShortcuts) {
    this.calendarEvents = tutorialShortcuts;
  }

  @NonNull
  @Override
  public CalendarListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                               int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View listItem = layoutInflater.inflate(R.layout.item_calendar_event, parent, false);
    return new ViewHolder(listItem);
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    CalendarEvent calendarEvent = calendarEvents.get(position);

    holder.calendarEventDay.setText(String.format("%02d", calendarEvent.getDay()));
    holder.calendarEventMonth.setText(CalendarUtils.transformMonth(calendarEvent.getMonth()));
    holder.calendarEventTime.setText(StringUtils.join(calendarEvent.getEventStartTime(), " - ", calendarEvent.getEventEndTime() ));
    holder.calendarEventTitle.setText(StringUtils.join(calendarEvent.getAuthor().getFirstName(), " ", calendarEvent.getAuthor().getSurname()));
    holder.calendarEventTitle.setText(calendarEvent.getTitle());

  }

  @Override
  public int getItemCount() {
    return calendarEvents.size();
  }
}
