package coms309;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "Hello and welcome to COMS 309";
    }

    @GetMapping("/{name}")
    public String welcome(@PathVariable String name) {
        return "Hello and welcome to COMS 309: " + name;
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
