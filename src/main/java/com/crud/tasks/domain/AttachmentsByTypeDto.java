package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Getter
public class AttachmentsByTypeDto {

    @JsonProperty("trello")
    private TrelloTrelloDto trello;
}
