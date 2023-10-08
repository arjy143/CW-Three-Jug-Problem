import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class F121572Source {
	static state currentState; //the state that the function will be examining
	static ArrayList<state> tree = new ArrayList<state>(); //the list containing all of the states
	static Stack<state> stack = new Stack<state>(); //this stack will be used to go up and down the tree

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	//takes A,B,C as input
		System.out.println("Capacity of A: ");
		int aCapacity = input.nextInt();		
		System.out.println("Capacity of B: ");
		int bCapacity = input.nextInt();	
		System.out.println("Capacity of C: ");
		int cCapacity = input.nextInt();
		input.close();
		long startTime = System.currentTimeMillis();
		state capacityState = new state(aCapacity, bCapacity, cCapacity);
		tree = treeGeneration.generateTree(capacityState, currentState, stack, tree);
		System.out.println("The nodes of the tree are as follows:");
		for(state node: tree) {
            System.out.println(node);
		}
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Tree has "+tree.size()+" nodes.");//prints number of nodes in tree
		System.out.println("Total execution time in millis: "+ elapsedTime);
	}


}
