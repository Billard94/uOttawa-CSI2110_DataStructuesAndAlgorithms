import java.util.*;
import java.io.*;

public class DecisionTree {

	private DecisionStump root;
	
	public DecisionTree(int dimension, int numberOfClasses) {
		DecisionStump.nClasses= numberOfClasses;
		DecisionStump.dim= dimension;
		root= new DecisionStump();
	}
	
	// returns the root of the decision tree
	public DecisionStump getRoot() {
	
		return root;
	}
	
	// get the class associated with this vector according to the decision tree
	public int getDecision(double[] vector) {
		return root.getDecision(vector);
	}
	
	// replace a leaf node by a DecisionStump with two leaves
	public void replace(DecisionStump leaf, int featureIndex, double threshold) {
	
		DecisionStump newNode= new DecisionStump(featureIndex, threshold);
		
		// replace the root
		if (root == leaf) {
			root= newNode;
		} else {
					
			// connect the new node to the parent of the replaced leaf
			if (leaf.getParent().getSmallerBranch() == leaf)
				leaf.getParent().setSmallerBranch(newNode);
			else
				leaf.getParent().setGreaterBranch(newNode);
		}

		// connect the two new leaves
		newNode.setSmallerBranch(new DecisionStump());
		newNode.setGreaterBranch(new DecisionStump());
	}
	
	// gets the leaf with the smallest maximal class probability
	public DecisionStump getSmallestMaxProb() {
	
		return getSmallestMaxProb(root);
	}
	
	private DecisionStump getSmallestMaxProb(DecisionStump node) {
	
		if (node.isExternal())
			return node;
		
		DecisionStump ns= getSmallestMaxProb(node.getSmallerBranch());
		DecisionStump ng= getSmallestMaxProb(node.getGreaterBranch());
		
		if (ns.getMaxProb() < ng.getMaxProb())
			return ns;
		else
			return ng;
	}
	
	public void train(double[] vector, int c) {
	
		root.updateProbCount(vector, c);
	}
	
	// reset the probability counts of all nodes
	public void resetAll() {
	
			reset(root);
	}

	private void reset(DecisionStump ds) {
	
		ds.resetProbCount();
		
		if (!ds.isExternal()) {
		
			reset(ds.getSmallerBranch());
			reset(ds.getGreaterBranch());
		}
	}

	// pre-order print of all nodes
	public void print() {
	
		print(root);
	}
	
	private void print(DecisionStump ds) {
	
		System.out.println(ds.toString());
		
		if (!ds.isExternal()) {
		
			print(ds.getSmallerBranch());
			print(ds.getGreaterBranch());
		}
	}

	public static void main(String[] args) {
	
		try {
			Scanner scanner = new Scanner(new File("iris.data.txt"));
			scanner.useDelimiter("[,\r\n]+");
			while(scanner.hasNextDouble()) {
				System.out.println("="+scanner.nextDouble());
				System.out.println("="+scanner.nextDouble());
				System.out.println("="+scanner.nextDouble());
				System.out.println("="+scanner.nextDouble());
				System.out.println("="+scanner.next());
			}		
		} catch (Exception e) {
			System.out.println("Error reading file...");
		}
		
		// Create 1-node tree
		DecisionTree dt= new DecisionTree(4, 3);
		dt.replace(dt.getRoot(), 0, 5.0);

		double features[]= new double[4];
		String className;
		int classNumber;
		
		// train with one node
		try {
			Scanner scanner = new Scanner(new File("iris.data.txt"));
			scanner.useDelimiter("[,\r\n]+");
			while(scanner.hasNextDouble()) {
				features[0]= scanner.nextDouble();
				features[1]= scanner.nextDouble();
				features[2]= scanner.nextDouble();
				features[3]= scanner.nextDouble();
				
				className= scanner.next();
				
				if (className.equals("Iris-setosa")) {
					classNumber= 0;
				} else if (className.equals("Iris-versicolor")) {	
					classNumber= 1;
				} else if (className.equals("Iris-virginica")) {				
					classNumber= 2;
				} else {
					throw new Exception("Unknown class");
				}
				
				dt.train(features, classNumber);
			}		
		} catch (Exception e) {
			System.out.println("Error reading file..."+e);
		}
		
		System.out.println("1-node Decision Tree:");
		dt.print();
		System.out.println("Most uncertain node:");
		System.out.println(dt.getSmallestMaxProb().toString()+"\n");

		// train a 2-node decision tree
		dt.replace(dt.getSmallestMaxProb(), 2, 2.5);
		dt.resetAll();
		
		try {
			Scanner scanner = new Scanner(new File("iris.data.txt"));
			scanner.useDelimiter("[,\r\n]+");
			while(scanner.hasNextDouble()) {
				features[0]= scanner.nextDouble();
				features[1]= scanner.nextDouble();
				features[2]= scanner.nextDouble();
				features[3]= scanner.nextDouble();
				
				className= scanner.next();
				
				if (className.equals("Iris-setosa")) {
					classNumber= 0;
				} else if (className.equals("Iris-versicolor")) {	
					classNumber= 1;
				} else if (className.equals("Iris-virginica")) {				
					classNumber= 2;
				} else {
					throw new Exception("Unknown class");
				}
				
				dt.train(features, classNumber);
			}		
		} catch (Exception e) {
			System.out.println("Error reading file..."+e);
		}

		System.out.println("2-node Decision Tree:");
		dt.print();
		System.out.println("Most uncertain node:");
		System.out.println(dt.getSmallestMaxProb().toString()+"\n");

		// train a 3-node decision tree
		dt.replace(dt.getSmallestMaxProb(), 1, 3.0);
		dt.resetAll();
		
		try {
			Scanner scanner = new Scanner(new File("iris.data.txt"));
			scanner.useDelimiter("[,\r\n]+");
			while(scanner.hasNextDouble()) {
				features[0]= scanner.nextDouble();
				features[1]= scanner.nextDouble();
				features[2]= scanner.nextDouble();
				features[3]= scanner.nextDouble();
				
				className= scanner.next();
				
				if (className.equals("Iris-setosa")) {
					classNumber= 0;
				} else if (className.equals("Iris-versicolor")) {	
					classNumber= 1;
				} else if (className.equals("Iris-virginica")) {				
					classNumber= 2;
				} else {
					throw new Exception("Unknown class");
				}
				
				dt.train(features, classNumber);
			}		
		} catch (Exception e) {
			System.out.println("Error reading file..."+e);
		}

		System.out.println("3-node Decision Tree:");
		dt.print();
		System.out.println("Most uncertain node:");
		System.out.println(dt.getSmallestMaxProb().toString()+"\n");		
	}
}