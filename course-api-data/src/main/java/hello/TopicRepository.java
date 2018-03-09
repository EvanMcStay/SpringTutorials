package hello;

import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, String> {

    // Implement custom operations such as searching for a specific word inside text

}
