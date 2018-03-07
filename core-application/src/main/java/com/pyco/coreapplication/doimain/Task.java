package com.pyco.coreapplication.doimain;

import com.querydsl.core.annotations.QueryEntity;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@QueryEntity
@Document
public class Task extends BaseEntity {

    @NotNull
    private String content;
    private boolean done;
    @NotNull
    private String personId;

    public Task() {
    }

    public Task(String content) {
        this.content = content;
    }

    public Task(String content, boolean done, String personId) {
        this.content = content;
        this.done = done;
        this.personId = personId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
