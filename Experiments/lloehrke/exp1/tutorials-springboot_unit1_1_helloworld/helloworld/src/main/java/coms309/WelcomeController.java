package coms309;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@RestController
class WelcomeController {

	private HashMap<Integer, String> countryList = new HashMap<Integer, String>();
	private int id = 0;
	
    @GetMapping("/")
    public String welcome() {
        return "Hello and welcome to COMS 309";
    }

    @GetMapping("/{name}")
    public String welcome(@PathVariable String name) {
        return "Hello and welcome to COMS 309: " + name;
    }
    
    @PostMapping("/addcountry")
    public String addCountry(@RequestParam String countryName) {
    	countryList.put(id++, countryName);
    	return String.format("%s added to the list with id %s", countryName, id);
    }
    
    @GetMapping("/getList")
    public @ResponseBody HashMap<Integer, String> getList(){
    	return countryList;
    }
    
}
