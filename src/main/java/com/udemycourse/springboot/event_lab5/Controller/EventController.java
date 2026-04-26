package com.udemycourse.springboot.event_lab5.Controller;


import com.udemycourse.springboot.event_lab5.Model.Event;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/events")
public class EventController {

   ArrayList<Event> events = new ArrayList<Event>();

// 1 endpoint Get
    @GetMapping("/get")
    public ArrayList<Event> getEvents() {
        return events;
    }


 // 2 endpoint post
    @PostMapping("/add")
    public String addEvent(@RequestBody Event event) {
        events.add(event);
        return "Event added successfully";
    }


 // 3 endpoint put
 @PutMapping("/update/{index}")
 public String updateEvent(@PathVariable int index, @RequestBody Event event) {
     events.set(index, event);
     return "Event updated successfully";
 }


 // 4 endpoint delete
 @DeleteMapping("/delete/{index}")
 public String deleteEvent(@PathVariable int index) {
     events.remove(index);
     return "Event deleted successfully";
 }


 // 5 endpoint change capacity
    @PutMapping("/change-capacity/{index}/{capacity}")
    public String changeCapacity(@PathVariable int index, @PathVariable int capacity) {
        events.get(index).setCapacity(capacity);
        return "Capacity updated successfully";
    }


 // 6 endpoint Search by id
 @GetMapping("/search/{id}")
 public Event searchEvent(@PathVariable int id) {
     for (Event e : events) {
         if (e.getId() == id) {
             return e;
         }
     }
     return null;
 }



 // 7 Hint
   public ArrayList<Event> getEventsByDate(@RequestParam String start, @RequestParam String end) {
       ArrayList<Event> result = new ArrayList<>();
       for (Event e : events) {
           if (e.getStartDate().compareTo(start) >= 0 &&
                   e.getEndDate().compareTo(end) <= 0) {
               result.add(e);
           }
       }
       return result;

   }



}
