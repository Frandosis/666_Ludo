/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ludo.funktion;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Valdemar Landberg
 */
public class Braet1 {

   public class Vertex {

        Felt felt;

        Vertex(Felt nyfelt) {
            this.felt = nyfelt;
        }
        
        public int getFeltnr(){
            return this.felt.getFeltnr();
        }
        
        public Felt getFelt(){
            return this.felt;
        }
        @Override
        public boolean equals(Object o){
            
		// null check
		if (o == null) {
			return false;
		}
 
		// this instance check
		if (this == o) {
			return true;
		}
 
		// instanceof Check and actual value check
		if ((o instanceof Vertex) && (((Vertex) o).getFelt() == this.felt)) {
			return true;
		} else {
			return false;
		}
        }
        @Override
        public int hashCode() {
		int result = 0;
		result = (int) (this.getFeltnr() / 11);
		return result;
	}
        
    }

    public class Graph {

        public Map<Vertex, List<Vertex>> adjVertices;
        Graph(){
            adjVertices = new LinkedHashMap();
            
        }

        // standard constructor, getters, setters
        public void addVertex(Felt felt) {
            
            adjVertices.put(new Vertex(felt), new ArrayList<>());
        }

        public void removeVertex(Felt felt) {
            Vertex v = new Vertex(felt);
            adjVertices.values()
                    .stream()
                    .map(e -> e.remove(v))
                    .collect(Collectors.toList());
            adjVertices.remove(new Vertex(felt));
        }

        public void addDirectedEdge(Felt felt1, Felt felt2) {
            Vertex v1 = new Vertex(felt1);
            Vertex v2 = new Vertex(felt2);
            boolean containskey = adjVertices.containsKey(v1);
            var list = adjVertices.get(v1);
            list.add(v2);
        }

        public void addUndirectedEdge(Felt felt1, Felt felt2) {
            Vertex v1 = new Vertex(felt1);
            Vertex v2 = new Vertex(felt2);
            adjVertices.get(v1).add(v2);
            adjVertices.get(v2).add(v1);
        }

        public void removeEdge(Felt felt1, Felt felt2) {
            Vertex v1 = new Vertex(felt1);
            Vertex v2 = new Vertex(felt2);
            List<Vertex> eV1 = adjVertices.get(v1);
            List<Vertex> eV2 = adjVertices.get(v2);
            if (eV1 != null) {
                eV1.remove(v2);
            }
            if (eV2 != null) {
                eV2.remove(v1);
            }
        }
        
        public Felt getFelt(int index){
            for(Map.Entry<Vertex, List<Vertex>> entry : adjVertices.entrySet()){
                Vertex key = entry.getKey();
                if(key.getFeltnr() == index){
                    return key.getFelt();
                }
            } 
            
            return null;
        }

        public List<Vertex> getAdjVertices(Felt felt) {
            return adjVertices.get(new Vertex(felt));
        }

        public int size() {
            return adjVertices.size();
        }

        Graph createGraph() {
            Graph graph = new Graph();
            int i = 0;
            //indsaet blaa hjemfelter
            while (i < 4) {
                graph.addVertex(new Hjemfelt("blue", i));
                i++;
            }
            int tmp = i;

            //indsaet roede hjemfelter
            while (tmp < i + 4) {
                graph.addVertex(new Hjemfelt("red", tmp));
                tmp++;
            }
            i = tmp;

            //indsaet gule hjemfelter
            while (tmp < i + 4) {
                graph.addVertex(new Hjemfelt("yellow", tmp));
                tmp++;
            }
            i = tmp;

            //indsaet groenne hjemfelter
            while (tmp < i + 4) {
                graph.addVertex(new Hjemfelt("green", tmp));
                tmp++;
            }
            i = tmp;

            System.out.println("Size after hjemfelt: " + graph.size());

            //skal taelle hvert op til
            int counter = 0;
            Felt lastfelt = null;
            Felt firstbane = null;
            Felt baneToRedEnd = null;
            Felt baneToYellowEnd = null;
            Felt baneToGreenEnd = null;
            Felt baneToBlueEnd = null;
            //tilføj banefelter og startfelter
            while (tmp < i + 56) {

                if (counter == 0) {
                    lastfelt = new Startfelt("blue", tmp);
                    firstbane = lastfelt;
                    graph.addVertex(lastfelt);
                } else if (counter == 14) {
                    Felt newfelt = new Startfelt("red", tmp);
                    graph.addVertex(newfelt);
                    graph.addDirectedEdge(lastfelt, newfelt);
                    lastfelt = newfelt;

                } else if (counter == 28) {
                    Felt newfelt = new Startfelt("yellow", tmp);
                    graph.addVertex(newfelt);
                    graph.addDirectedEdge(lastfelt, newfelt);
                    lastfelt = newfelt;

                } else if (counter == 42) {

                    Felt newfelt = new Startfelt("green", tmp);
                    graph.addVertex(newfelt);
                    graph.addDirectedEdge(lastfelt, newfelt);
                    lastfelt = newfelt;

                } else {
                    if (counter == 12) {
                        Felt newfelt = new Banefelt(tmp);
                        baneToRedEnd = newfelt;
                        graph.addVertex(newfelt);
                        graph.addDirectedEdge(lastfelt, newfelt);
                        lastfelt = newfelt;
                    } else if (counter == 26) {
                        Felt newfelt = new Banefelt(tmp);
                        baneToYellowEnd = newfelt;
                        graph.addVertex(newfelt);
                        graph.addDirectedEdge(lastfelt, newfelt);
                        lastfelt = newfelt;
                    } else if (counter == 40) {
                        Felt newfelt = new Banefelt(tmp);
                        baneToGreenEnd = newfelt;
                        graph.addVertex(newfelt);
                        graph.addDirectedEdge(lastfelt, newfelt);
                        lastfelt = newfelt;
                    } else if (counter == 54) {
                        Felt newfelt = new Banefelt(tmp);
                        baneToBlueEnd = newfelt;
                        graph.addVertex(newfelt);
                        graph.addDirectedEdge(lastfelt, newfelt);
                        lastfelt = newfelt;
                    } else if (counter == 55) {
                        Felt newfelt = new Banefelt(tmp);
                        graph.addVertex(newfelt);
                        graph.addDirectedEdge(lastfelt, newfelt);
                        graph.addDirectedEdge(newfelt, firstbane);
                        lastfelt = newfelt;

                    } else {
                        Felt newfelt = new Banefelt(tmp);
                        graph.addVertex(newfelt);
                        graph.addDirectedEdge(lastfelt, newfelt);
                        lastfelt = newfelt;
                    }

                }
                tmp++;
                counter++;
            }
            i = tmp;
            counter = 0;
            System.out.println("Size after Bane and Start: " + graph.size());

            //indsaet Endefelter
            while (tmp < i + 6) {
                if (tmp == i) {
                    Felt newfelt = new Endefelt("blue", tmp);
                    graph.addVertex(newfelt);
                    graph.addDirectedEdge(baneToBlueEnd, newfelt);
                    lastfelt = newfelt;
                } else {
                    Felt newfelt = new Endefelt("blue", tmp);
                    graph.addVertex(newfelt);
                    graph.addUndirectedEdge(lastfelt, newfelt);
                    lastfelt = newfelt;
                }
                
                tmp++;
            }

            i = tmp;

            while (tmp < i + 6) {
                if (tmp == i) {
                    Felt newfelt = new Endefelt("red", tmp);
                    graph.addVertex(newfelt);
                    graph.addDirectedEdge(baneToRedEnd, newfelt);
                    lastfelt = newfelt;
                } else {
                    Felt newfelt = new Endefelt("red", tmp);
                    graph.addVertex(newfelt);
                    graph.addUndirectedEdge(lastfelt, newfelt);
                    lastfelt = newfelt;
                }
                tmp++;
            }

            i = tmp;

            while (tmp < i + 6) {
                if (tmp == i) {
                    Felt newfelt = new Endefelt("yellow", tmp);
                    graph.addVertex(newfelt);
                    graph.addDirectedEdge(baneToYellowEnd, newfelt);
                    lastfelt = newfelt;
                } else {
                    Felt newfelt = new Endefelt("yellow", tmp);
                    graph.addVertex(newfelt);
                    graph.addUndirectedEdge(lastfelt, newfelt);
                    lastfelt = newfelt;
                }
                tmp++;
            }

            i = tmp;

            while (tmp < i + 6) {
                if (tmp == i) {
                    Felt newfelt = new Endefelt("green", tmp);
                    graph.addVertex(newfelt);
                    graph.addDirectedEdge(baneToGreenEnd, newfelt);
                    lastfelt = newfelt;
                } else {
                    Felt newfelt = new Endefelt("green", tmp);
                    graph.addVertex(newfelt);
                    graph.addUndirectedEdge(lastfelt, newfelt);
                    lastfelt = newfelt;
                }
                tmp++;
            }
            i = tmp;
            
            System.out.println("Size after Endefelt: " + graph.size());
            
             graph.addVertex(new Bufferfelt("blue", i));
        i++;
        graph.addVertex(new Bufferfelt("red", i));
        i++;
        graph.addVertex(new Bufferfelt("yellow", i));
        i++;
        graph.addVertex(new Bufferfelt("green", i));
        
        System.out.println("Size after Bufferfelt: "+ graph.size());
        
            return graph;
        }
    }
    
    Graph graph;
    
    public Braet1() {
        graph = new Graph();
        graph = graph.createGraph();
        
    }

    public Graph getGraph(){
        return this.graph;
    }
    
}
