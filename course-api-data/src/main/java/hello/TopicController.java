package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

    // Private member variable from TopicService business service.
    // The Autowired annotation marks the variable as needing a dependency injection
    @Autowired
    private TopicService topicService;

    /* GET REQUEST (default) */
    // A method to return the Topic objects when the .../topics url is accessed
    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        // Returning an array of objects that Spring MVC will convert to JSON and return
        return topicService.getAllTopics();
    }

    /* GET REQUEST (default) */
    // the annotation here is mapping the URI /topics/id to the specific element by using the variable portion syntax
    // {...} after the /topics/ part of the URI. This allows you to take any parameter in and pass it as a regular
    // variable using the @PathVariable annotation instead of hardcoding the id part.
    // The @PathVariable annotation inside the parameters is how Spring will set the variable portion as the parameter you are passing.
    @RequestMapping("/topics/{id}")
    public Optional<Topic> getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    /* POST REQUEST */
    // Map the addTopic() functionality of any method that is a post to the /topics URI
    // This says the request payload is going to contain a JSON representation of the Topic instance
    // and you are asking Spring MVC to take from the @RequestBody and convert it into a Topic instance and pass it to the
    // addTopic() when the URI is mapped. This will give an instance of the topic which can be added to the list.
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    /* PUT REQUEST */
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(topic, id);
    }

    /* DELETE REQUEST */
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}
