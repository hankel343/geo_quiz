package coms309;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
class WelcomeController {

    private HashMap<Integer, String> logInList = new HashMap<Integer, String>();
    private int id = 0;

    @GetMapping("/")
    public String welcome() {
        return "Hello and welcome to COMS 309";
    }

    @GetMapping("/{name}")
    public String welcome(@PathVariable String name) {
        return "Hello and welcome to COMS 309: " + name;
    }

    @PostMapping("/addPerson")
    public String addPerson(@RequestParam String name) {
        logInList.put(id++, name);
        return String.format("%s added to the list with id %s", name, id);
    }

    @GetMapping("/test")
    public String sayHello() {
        return "You navigated to the test endpoint";
    }

    @GetMapping("/schedule")
    public String getSchedule() {
        return "Our group meets Mondays and Wednesdays at 1:00pm";
    }
}
