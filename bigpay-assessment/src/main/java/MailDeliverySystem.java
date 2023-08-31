import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import models.Package;
import models.*;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
@AllArgsConstructor
public class MailDeliverySystem {
    private List<Node> nodes;
    private List<Edge> edges;
    private List<Train> trains;
    private List<Package> packages;

    List<Move> goToPath(Train train,Package pickedUPPackage,Package dropOffPackage,Node startingNode,Node destinationNode){
        List<Move> moves=new ArrayList<>();
        Node currentNode = destinationNode;
        Dijkstra dijkstra=new Dijkstra(edges,nodes,startingNode);
        while (currentNode != startingNode) {
            Edge currentEdge = dijkstra.getPreviousEdges().get(currentNode);;
            moves.add(new Move(
                    currentEdge.getJourneyTime(),
                    train,
                    currentEdge.getFirstNode().getName().equals(currentNode.getName())?currentEdge.getSecondNode():currentEdge.getFirstNode(),
                    currentNode,
                    pickedUPPackage,
                    dropOffPackage
            ));
            currentNode = dijkstra.getPreviousNodes().get(currentNode);
        }
        Collections.reverse(moves);
        return moves;
    }
    public List<Move> mailDelivery() {
        Map<Package, List<Move>> movesMap=new HashMap<>();
        List<Move> moves = new ArrayList<>();
        Map<Package,Integer> distanceToPackage=new HashMap<>();
        for (Train train : trains) {
            int availableCapacity = train.getCapacityInKG();
            Node startingNode =train.getStartingNode();
            Dijkstra trainDijkstra=new Dijkstra(edges,nodes,train.getStartingNode());
            Map<Node, Integer> distances = trainDijkstra.getDistances();
            List<Package> loadablePackages = packages.stream().filter(pkg -> pkg.getWeightInKG() <= train.getCapacityInKG() && distances.get(pkg.getStartnigNode())<Integer.MAX_VALUE&& distances.get(pkg.getDestinationNode())<Integer.MAX_VALUE).collect(Collectors.toList());
            for (Package pkg:loadablePackages){
                if (distanceToPackage.get(pkg)!=null && distanceToPackage.get(pkg).compareTo(distances.get(pkg.getStartnigNode()))<=0){
                    continue;
                }else{
                    if (availableCapacity>=pkg.getWeightInKG()){
                        distanceToPackage.put(pkg,distances.get(pkg.getStartnigNode()));
                        availableCapacity -= pkg.getWeightInKG();
                        List<Move> toPackageStartingPosition=goToPath(train,pkg,null,startingNode,pkg.getStartnigNode());
                        startingNode=pkg.getStartnigNode();
                        List<Move> toPackageDeliveryPosition=goToPath(train,null,pkg,startingNode,pkg.getDestinationNode());
                        startingNode=pkg.getDestinationNode();
                        movesMap.put(pkg, Stream.concat(toPackageStartingPosition.stream(), toPackageDeliveryPosition.stream()).collect(Collectors.toList()));
                    }
                }
            }
        }
        for (Map.Entry<Package, List<Move>> entry : movesMap.entrySet()) {
            moves.addAll(entry.getValue());
        }
        return moves;
    }
}
