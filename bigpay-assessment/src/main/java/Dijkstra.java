import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import models.Edge;
import models.Node;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class Dijkstra {
    Map<Node, Integer> distances;
    Map<Node, Node> previousNodes;
    Map<Node, Edge> previousEdges;

    Dijkstra(List<Edge> edges,List<Node> nodes, Node sourceNode) {
        distances = new HashMap<>();
        previousNodes = new HashMap<>();
        previousEdges = new HashMap<>();

        for (Node node : nodes) {
            distances.put(node, node == sourceNode ? 0 : Integer.MAX_VALUE);
        }

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(distances::get));
        priorityQueue.add(sourceNode);

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            for (Edge edge : edges.stream().filter(e->e.getFirstNode().getName().equals(current.getName()) ||e.getSecondNode().getName().equals(current.getName())).collect(Collectors.toList())) {
                Node neighborNode = (edge.getFirstNode().getName().equals(current.getName())) ? edge.getSecondNode() : edge.getFirstNode();
                int alt = distances.get(current) + edge.getJourneyTime();
                if (alt < distances.get(neighborNode)) {
                    distances.put(neighborNode, alt);
                    previousNodes.put(neighborNode, current);
                    previousEdges.put(neighborNode, edge);
                    priorityQueue.remove(neighborNode);
                    priorityQueue.add(neighborNode);
                }
            }
        }
    }
}
