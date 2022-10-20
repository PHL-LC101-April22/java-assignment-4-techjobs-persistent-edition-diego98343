package org.launchcode.techjobs.persistent.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class Skill extends AbstractEntity {

    @NotEmpty(message = "field is empty")
    @Size(min = 3,max = 20)
    @Length(min = 3,max = 20)
    public String description;

    @ManyToMany(mappedBy = "skills")
    private final List<Job> jobs= new ArrayList<>();
    public Skill() {
    }

    public Skill(int id, String name, String description ) {
        super(id, name);
        this.description = description;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}