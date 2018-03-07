package com.pyco.coreapplication.dto;

import javax.validation.constraints.NotNull;

public class TaskDto extends BaseDto {

    @NotNull
    private String content;
    private boolean done;

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
}
