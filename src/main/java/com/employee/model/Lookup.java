package com.employee.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Lookup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="group_name")
    private String group;

    private String description;

    private Date created_date;

    private String created_by;

    private Date modified_date;

    private String modified_by;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroup_name() {
        return group;
    }

    public void setGroup_name(String group_name) {
        this.group = group_name;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getModified_date() {
        return modified_date;
    }

    public void setModified_date(Date modified_date) {
        this.modified_date = modified_date;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    @Override
    public String toString() {
        return "Lookup{" +
                "id=" + id +
                ", group_name='" + group + '\'' +
                ", description='" + description + '\'' +
                ", created_date='" + created_date + '\'' +
                ", created_by='" + created_by + '\'' +
                ", modified_date='" + modified_date + '\'' +
                ", modified_by='" + modified_by + '\'' +
                '}';

    }
}
