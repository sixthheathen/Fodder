/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sixth.fodder.core;

import com.sixth.fodder.core.cell.*;
import java.util.ArrayList;

/**
 *
 * @author sixth
 * oh my god how long has it been since I last visited this place
 */
public class GraphAnalyser
{
    private static int[][] connectMatrix;
    private static final int numOfConnections = count();
    private static ArrayList<ArrayList<Integer>> components;
    
    public GraphAnalyser()
    {
        components = new ArrayList<ArrayList<Integer>>();
    }
            
    // the most outstanding and remarkable algorithm for counting the number of connections
    private static int count()
    {
        int num = 0;
        
        for (int i = 1; i < RoadGenerator.getNumOfCells(); ++i)
            num += i;
        
        num *= 2;
        num += RoadGenerator.getNumOfCells() - 1;
        
        return num;
    }
    
//    public static void genFullMatrix()
//    {
//        connectMatrix = new int[numOfConnections][3];
//        
//        for (int i = 0; i < numOfConnections; ++i)
//        {
//            connectMatrix[i][0] = i;
//            if ((i / RoadGenerator.getNumOfCells()) < (RoadGenerator.getNumOfCells() - 1))
//                connectMatrix[i][1] = i + RoadGenerator.getNumOfCells(); // a cell down
//            if ((i % RoadGenerator.getNumOfCells()) < (RoadGenerator.getNumOfCells() - 1))
//                if (connectMatrix[i][1] == 0)
//                    connectMatrix[i][1] = i + 1; // a cell right
//                else
//                    connectMatrix[i][2] = i + 1; // a cell right 
//        }
//    }
    
    public void printM()
    {
        for (int i = 0; i < numOfConnections; i++)   
            System.out.println(connectMatrix[i][0] + " " + connectMatrix[i][1] + " " + connectMatrix[i][2]);
    }
    
    public static void genConnectMatrix(Cell[][] cells)
    {
        connectMatrix = new int[numOfConnections][3];
        
        int nextLine = 0;
        
        for (int i = 0; i < RoadGenerator.getNumOfCells(); ++i)
            for (int j = 0; j < RoadGenerator.getNumOfCells(); ++j)
            {
                Boolean changed = false;
                connectMatrix[nextLine][0] = i * RoadGenerator.getNumOfCells() + j;
                if (i < (RoadGenerator.getNumOfCells() - 1) &&
                   ((RoadCell)cells[i][j]).hasDownRoad())
                {
                    connectMatrix[nextLine][1] = connectMatrix[nextLine][0] + RoadGenerator.getNumOfCells(); // a cell down
                    changed = true;
                }
                if (j < (RoadGenerator.getNumOfCells() - 1) &&
                        ((RoadCell)cells[i][j]).hasRightRoad())
                    if (changed)
                        connectMatrix[nextLine][2] = connectMatrix[nextLine][0] + 1; // a cell right
                    else
                    {
                        connectMatrix[nextLine][1] = connectMatrix[nextLine][0] + 1; // a cell right 
                        changed = true;
                    }
                if (changed)
                    nextLine++;
            }
        for (int i = 0; i < numOfConnections; ++i)
        {
            if (connectMatrix[i][0] == ((RoadGenerator.getNumOfCells() - 1) * (RoadGenerator.getNumOfCells()) + (RoadGenerator.getNumOfCells() - 1)))
                connectMatrix[i][0] = 0;
        }
    }
    
    public static void findComponents()
    {
        int first = -1;
        
        do
        {
            first = -1;
            for (int i = 0; i < numOfConnections; ++i)
                if (connectMatrix[i][0] != 0)
                {
                    first = i;
                    components.add(getComponent(i));
                }
        } while (first != -1);
        
        System.out.println(components.size());
    }
    
    private static ArrayList<Integer> getComponent(int first)
    {
        ArrayList<Integer> component = new ArrayList<Integer>();
        ArrayList<Integer> queue = new ArrayList<Integer>();

        component.add(connectMatrix[first][0]);
        queue.add(connectMatrix[first][0]);
        
        while (!queue.isEmpty())
        {
            int i = queue.remove(0);
            for (int j = 0; j < numOfConnections; ++j)
                for (int k = 0; k < 3; ++k)
                    if (connectMatrix[j][k] == i)
                    {
                        if (k == 0)
                        {
                            if (!component.contains(connectMatrix[j][1]))
                            {
                                component.add(connectMatrix[j][1]);
                                queue.add(connectMatrix[j][1]);
                            }
                            
                            if (connectMatrix[j][2] != 0 && !component.contains(connectMatrix[j][2]))
                            {
                                component.add(connectMatrix[j][2]);
                                queue.add(connectMatrix[j][2]);
                            }
                        }
                        else if (k == 1)
                        {
                            if (!component.contains(connectMatrix[j][0]))
                            {
                                component.add(connectMatrix[j][0]);
                                queue.add(connectMatrix[j][0]);
                            }
                            
                            if (connectMatrix[j][2] != 0 && !component.contains(connectMatrix[j][2]))
                            {
                                component.add(connectMatrix[j][2]);
                                queue.add(connectMatrix[j][2]);
                            }
                        }
                        else
                        {
                            if (!component.contains(connectMatrix[j][0]))
                            {
                                component.add(connectMatrix[j][0]);
                                queue.add(connectMatrix[j][0]);
                            }
                            
                            if (!component.contains(connectMatrix[j][1]))
                            {
                                component.add(connectMatrix[j][1]);
                                queue.add(connectMatrix[j][1]);
                            }
                        }
                        connectMatrix[j][0] = connectMatrix[j][1] = connectMatrix[j][2] = 0;
                    }
        }
        
        return component;
    }
    
    public static void printComp(ArrayList<Integer> comp)
    {
        while (!comp.isEmpty())
        {
            System.out.println(comp.remove(0));
        }
    }

    public static ArrayList<ArrayList<Integer>> getComponents()
    {
        return components;
    }
}
