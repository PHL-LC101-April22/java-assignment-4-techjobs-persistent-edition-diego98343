package org.launchcode.techjobs.persistent.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employer extends AbstractEntity {

@NotEmpty
@Size(min = 3,max = 20)
@Length(min = 3,max = 20)
@NotNull
private String location;



    @JoinColumn(name = "employer")
    @OneToMany
    private final  List<Job> jobs= new ArrayList<>();

    public Employer(String location) {
        this.location = location;
    }

    public Employer() {
    }

    public Employer(int id, String name, String location) {
        super(id, name);
        this.location = location;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
