package hello;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// The business service is initialized just one time
@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            // Calling the constructor to create new objects
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("ionic", "Ionic Framework", "Ionic Framework Description"),
            new Topic("java", "Java Language", "Java Language Description")));

    // This method will return the above list to the TopicController every time the URI /topics is accessed.
    // This method is called inside the TopicController class inside the getAllTopics() method.
    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        // A lambda expression that iterates through the list to match the id inside the list to
        // the same ID passed in by the URI which will then be returned
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String id) {
        // For loop is the alternative to the lambda stream. It will loop through the List and for each id in the list it
        // will compare the id to the id passed and if the two ids match, that specific id will be updated with the passed
        // information then return.
        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        // Lambda expression that will remove the instance if the id is the same as the passed id
        topics.removeIf(t -> t.getId().equals(id));
    }
}
