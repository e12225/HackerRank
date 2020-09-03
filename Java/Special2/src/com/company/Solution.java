//https://www.hackerrank.com/challenges/java-vistor-pattern/problem

package com.company;

import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    int result=0;
    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
        //implement this
    }

    public void visitLeaf(TreeLeaf leaf) {
        result+=leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {

    private long result = 1;
    private final int M = 1000000007;

    public int getResult() {
        return (int) result;
    }

    public void visitNode(TreeNode node) {
        if (node.getColor() == Color.RED) {
            result = (result * node.getValue()) % M;
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.RED) {
            result = (result * leaf.getValue()) % M;
        }
    }
}

class FancyVisitor extends TreeVis {
    private int nonLeafNodesEvenDepth = 0;

    private int greenLeafNodes = 0;

    public int getResult() {
        return Math.abs(nonLeafNodesEvenDepth - greenLeafNodes);
    }

    public void visitNode(TreeNode node) {
        if(node.getDepth() %2 == 0){
            nonLeafNodesEvenDepth+=node.getValue();
        }
    }
    public void visitLeaf(TreeLeaf leaf) {
        if(leaf.getColor() == Color.GREEN) {
            greenLeafNodes+=leaf.getValue();
        }
    }
}

public class Eight {

    private static int inputValues[];
    private static Color colors[];
    private static Map<Integer, Set<Integer>> nodes = new HashMap<>();

    public static Tree solve(){
        Scanner in=new Scanner(System.in);

        int readNodes=in.nextInt();

        inputValues= new int[readNodes];

        for(int i=0;i<readNodes;i++) {
            inputValues[i]=in.nextInt();
        }

        colors = new Color[readNodes];

        for(int i=0;i<readNodes;i++) {
            colors[i]=(in.nextInt()==0)?Color.RED:Color.GREEN;
        }

        Tree rootNode;

        if(readNodes==1){
            rootNode=new TreeLeaf(inputValues[0],colors[0],0);
        }else{
            rootNode=new TreeNode(inputValues[0],colors[0],0);

            for(int i=0;i<(readNodes-1);i++) {

                int u = in.nextInt();

                int v = in.nextInt();

                Set<Integer> uEdges = nodes.get(u);

                if(uEdges==null)uEdges = new HashSet<>();

                uEdges.add(v);

                nodes.put(u, uEdges);

                Set<Integer> vEdges = nodes.get(v);

                if(vEdges==null)vEdges = new HashSet<>();
                vEdges.add(u);
                nodes.put(v, vEdges);
            }
            for(int nodeid:nodes.get(1)){
                nodes.get(nodeid).remove(1);
                createEdge(rootNode, nodeid);
            }
        }
        return rootNode;
    }

    private static void createEdge(Tree parent,int nodeid){

        Set<Integer> nodeEdges = nodes.get(nodeid);

        boolean hasChild = nodeEdges!=null && !nodeEdges.isEmpty();

        if(hasChild){
            TreeNode node = new TreeNode(inputValues[nodeid-1],colors[nodeid-1],parent.getDepth()+1);
            ((TreeNode)parent).addChild(node);

            for(int neighborid:nodeEdges){
                nodes.get(neighborid).remove(nodeid);
                createEdge(node, neighborid);
            }
        }else{
            TreeLeaf leaf = new TreeLeaf(inputValues[nodeid-1],colors[nodeid-1],parent.getDepth()+1);
            ((TreeNode)parent).addChild(leaf);
        }
    }


    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}