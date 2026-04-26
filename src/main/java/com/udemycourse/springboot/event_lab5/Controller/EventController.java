package com.udemycourse.springboot.event_lab5.Controller;


import com.udemycourse.springboot.event_lab5.ApiResponse.ApiResponse;
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
    public ApiResponse addEvent(@RequestBody Event event) {
        events.add(event);
        return new ApiResponse("Event added successfully");
    }


 // 3 endpoint put
 @PutMapping("/update/{index}")
 public ApiResponse updateEvent(@PathVariable int index, @RequestBody Event event) {
     events.set(index, event);
     return new ApiResponse("Event updated successfully");
 }


 // 4 endpoint delete
 @DeleteMapping("/delete/{index}")
 public ApiResponse deleteEvent(@PathVariable int index) {
     events.remove(index);
     return new ApiResponse("Event deleted successfully");
 }


 // 5 endpoint change capacity
    @PutMapping("/change-capacity/{index}/{capacity}")
    public ApiResponse changeCapacity(@PathVariable int index, @PathVariable int capacity) {
        events.get(index).setCapacity(capacity);
        return new ApiResponse("Capacity updated successfully");
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
 @GetMapping("/date")
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
