package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController is a Spring MVC annotation. Anytime you are building a controller, add this annotation.
@RestController
public class HelloController {

    // Methods to map to url requests go inside here.

    /* When a certain url is accessed, we want to call this method.
       So, we use the Spring MVC annotation @RequestMapping and pass
       the url that we want it to map to (in this case ".../hello"
       where ... is the rest of the domain.

       So, in short, this annotation says to call this method when the url is accessed.

       This is an HTTP GET request.
     */
    @RequestMapping("/hello")
    public String sayHi() {
        return "Hi";
    }
}
