package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Package {
    private String packageName;
    private Integer weightInKG;
    private Node startnigNode;
    private Node destinationNode;

}
