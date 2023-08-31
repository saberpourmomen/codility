package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Move {
    private Integer movingTime; //this time is in second
    private Train train;
    private Node startingNode;
    private Node destinationNode;
    private Package pickedUpPackage;
    private Package droppedOffPackage;
}
