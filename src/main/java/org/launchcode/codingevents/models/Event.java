package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

/**
 * Created by Chris Bay
 */
public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    @NotNull(message = "Location is required.")
    @NotBlank(message = "Location is required.")
    private String location;

    @AssertTrue(message = "This event must have attendees register.")
    private boolean shouldRegister = true;

    @NotNull(message = "At least one attendee is required.")
    @Min(value = 1, message = "At least one attendee is required.")
    private Integer numOfAttendees;

    @NotNull(message = "must have # of drinks between 1 and 3.")
    @Min(value = 1, message = "must have # of drinks between 1 and 3.")
    @Max(value = 3, message = "must have # of drinks between 1 and 3.")
    private Integer openBar;

    public Event(String name, String description, String contactEmail, String location, Boolean shouldRegister, Integer numOfAttendees) {
        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.location = location;
        this.shouldRegister = shouldRegister;
        this.numOfAttendees = numOfAttendees;
    }

    public Event() {
        this.id = nextId;
        nextId++;
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

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isShouldRegister() {
        return shouldRegister;
    }

    public void setShouldRegister(boolean shouldRegister) {
        this.shouldRegister = shouldRegister;
    }

    public Integer getNumOfAttendees() {
        return numOfAttendees;
    }

    public void setNumOfAttendees(Integer numOfAttendees) {
        this.numOfAttendees = numOfAttendees;
    }

    public Integer getOpenBar() {
        return openBar;
    }

    public void setOpenBar(Integer openBar) {
        this.openBar = openBar;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
