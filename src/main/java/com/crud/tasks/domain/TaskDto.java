package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
@Getter
@AllArgsConstructor
public class TaskDto{
    private Long id;
    private String title;
    private String content;
}


