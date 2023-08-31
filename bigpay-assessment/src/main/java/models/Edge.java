package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Edge {
    private String name;
    private Node firstNode;
    private Node secondNode;
    private Integer journeyTime; // journey time is in second we need to convert minutes to second
}
