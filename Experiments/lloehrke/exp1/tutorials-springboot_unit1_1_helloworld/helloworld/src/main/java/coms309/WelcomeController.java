package coms309;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;

@RestController
class WelcomeController {

	private HashMap<Integer, String> countryList = new HashMap<Integer, String>();
	private int idx = 1;
	
    @GetMapping("/")
    public String welcome() {
        return "Hello and welcome to COMS 309";
    }

    @GetMapping("/{name}")
    public String welcome(@PathVariable String name) {
        return "Hello and welcome to COMS 309: " + name;
    }
    
    @PostMapping("/addCountry/{countryName}")
    public String addCountry(@PathVariable String countryName) {
    	countryList.put(idx++, countryName);
    	return String.format("%s added to index %s in the list", countryName, idx-1);
    }
    
    @GetMapping("/getList")
    public @ResponseBody HashMap<Integer, String> getList(){
    	return countryList;
    }
    
}
