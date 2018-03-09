package hello;

import javax.persistence.Entity;
import javax.persistence.Id;

// The @Entity annotation tells JPA to create a table with the three String variables as columns
@Entity
public class Topic {

    @Id
    private String id;
    private String name;
    private String description;

    // No argument constructor
    public Topic() {

    }

    // Constructor
    public Topic(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    // Get and Set methods for variables
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
