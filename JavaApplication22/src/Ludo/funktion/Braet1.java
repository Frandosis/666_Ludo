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

    class Vertex {

        Felt felt;

        Vertex(Felt nyfelt) {
            this.felt = nyfelt;
        }

    }

    class Graph {

        private Map<Vertex, List<Vertex>> adjVertices;

        // standard constructor, getters, setters
        void addVertex(Felt felt) {
            adjVertices.putIfAbsent(new Vertex(felt), new ArrayList<>());
        }

        void removeVertex(Felt felt) {
            Vertex v = new Vertex(felt);
            adjVertices.values()
                    .stream()
                    .map(e -> e.remove(v))
                    .collect(Collectors.toList());
            adjVertices.remove(new Vertex(felt));
        }

        void addSingleEdge(Felt felt1, Felt felt2) {
            Vertex v1 = new Vertex(felt1);
            Vertex v2 = new Vertex(felt2);
            adjVertices.get(v1).add(v2);
        }

        void addDoubleEdge(Felt felt1, Felt felt2) {
            Vertex v1 = new Vertex(felt1);
            Vertex v2 = new Vertex(felt2);
            adjVertices.get(v1).add(v2);
            adjVertices.get(v2).add(v1);
        }

        void removeEdge(Felt felt1, Felt felt2) {
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

        List<Vertex> getAdjVertices(Felt felt) {
            return adjVertices.get(new Vertex(felt));
        }

        int size() {
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
            Felt lastfelt;
            Felt firstbane;
            Felt baneToRedEnd;
            Felt baneToYellowEnd;
            Felt baneToGreenEnd;
            Felt baneToBlueEnd;
            //tilføj banefelter og startfelter
            while (tmp < i + 56) {

                if (counter == 0) {
                    lastfelt = new Startfelt("blue", tmp);
                    firstbane = lastfelt;
                    graph.addVertex(lastfelt);
                } else if (counter == 14) {
                    Felt newfelt = new Startfelt("red", tmp);
                    graph.addVertex(newfelt);
                    graph.addSingleEdge(lastfelt, newfelt);
                    lastfelt = newfelt;

                } else if (counter == 28) {
                    Felt newfelt = new Startfelt("yellow", tmp);
                    graph.addVertex(newfelt);
                    graph.addSingleEdge(lastfelt, newfelt);
                    lastfelt = newfelt;

                } else if (counter == 42) {

                    Felt newfelt = new Startfelt("green", tmp);
                    graph.addVertex(newfelt);
                    graph.addSingleEdge(lastfelt, newfelt);
                    lastfelt = newfelt;

                } else {
                    if(counter == 12){
                        Felt newfelt = new Banefelt(tmp);
                        baneToRedEnd = newfelt;
                        graph.addVertex(newfelt);
                        graph.addSingleEdge(lastfelt, newfelt);
                        lastfelt = newfelt;
                    }
                    else
                    if(counter == 26){
                        Felt newfelt = new Banefelt(tmp);
                        baneToYellowEnd = newfelt;
                        graph.addVertex(newfelt);
                        graph.addSingleEdge(lastfelt, newfelt);
                        lastfelt = newfelt;
                    }
                    else
                    if(counter == 40){
                        Felt newfelt = new Banefelt(tmp);
                        baneToGreenEnd = newfelt;
                        graph.addVertex(newfelt);
                        graph.addSingleEdge(lastfelt, newfelt);
                        lastfelt = newfelt;
                    }
                    else
                    if(counter == 54){
                        Felt newfelt = new Banefelt(tmp);
                        baneToBlueEnd = newfelt;
                        graph.addVertex(newfelt);
                        graph.addSingleEdge(lastfelt, newfelt);
                        lastfelt = newfelt;
                    }

                    else
                    
                    if (counter == 55) {
                        Felt newfelt = new Banefelt(tmp);
                        graph.addVertex(newfelt);
                        graph.addSingleEdge(lastfelt, newfelt);
                        graph.addSingleEdge(newfelt, firstbane);
                        lastfelt = newfelt;
                        
                        
                    } else {
                        Felt newfelt = new Banefelt(tmp);
                        graph.addVertex(newfelt);
                        graph.addSingleEdge(lastfelt, newfelt);
                        lastfelt = newfelt;
                    }

                }
                tmp++;
                counter++;
            }
            i = tmp;
            counter = 0;
            System.out.println("Size after Bane and Start: " + braet.size());

            return graph;
        }
    }
    private int V;
    private LinkedList<Felt> adj[];
    private int lag = 1;

    public Braet1(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<Felt>();
        }
        setUpBraet();
    }

    public void setUpBraet() {

        //Lav blaa hjemfelter
        int i = 0;
        //indsaet blaa hjemfelter
        while (i < 4) {
            adj[i].add(new Hjemfelt("blue", i));
            i++;
        }
        int tmp = i;

    }

    public void addEdge(int v, Felt W) {
        adj[v].add(W);
    }
}
