package com.softarea.learningapp.dao;

import com.softarea.learningapp.R;
import com.softarea.learningapp.model.Event;
import com.softarea.learningapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class EventsDAO {
  public static List<Event> getData() {
    List<Event> events = new ArrayList<>();
    User author = new User( 0, "Łukasz Usarz", "SOFTAREA - SEO", R.drawable.demo_profile);

//    events.add(new Event(31, 7, 2020, "14:00", "14:30", "Podsumowanie pierwszego miesiąca praktyk", author ));
//    events.add(new Event(4, 8, 2020, "11:00", "11:20", "Poznaj obuwie - checkpoint meeting", author ));
//    events.add(new Event(11, 8, 2020, "11:00", "11:20", "Poznaj obuwie - checkpoint meeting", author ));

    events.add(new Event(31, 7, 2020, "14:00", "14:30", "Summary of the first month", author ));
    events.add(new Event(4, 8, 2020, "11:00", "11:20", "Introduce to Vue.js", author ));
    events.add(new Event(11, 8, 2020, "11:00", "11:20", "UI gradiends - meeting", author ));

    return events;
  }
}
