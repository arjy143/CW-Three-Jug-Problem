import java.util.ArrayList;
import java.util.Stack;

public class treeGeneration extends state {

	public treeGeneration(int a, int b, int c) {
		super(a, b, c);
		// TODO Auto-generated constructor stub
	}

	public static ArrayList<state> generateTree(state capacityState, state currentState, Stack<state> stack, ArrayList<state> tree) {		
		state root = new state(0,0,0); 		
		tree.add(root); 
		stack.push(root); 	
		
		while(stack.empty()==false){			
			currentState = (state) stack.peek(); //gets the state at the top of the stack
			/*if any of the following return true, then it means that the program has 
			 * succeeded in finding a new unique state, and has added it to the
			 *  tree and stack. The while loop then goes to the next loop and
			 *  repeats the process.
			*/
			if(state.fill("A", capacityState, currentState, stack, tree)==true) {
				continue;
			}
			if(state.fill("B", capacityState, currentState, stack, tree)==true) {
				continue;
			}			
			if(state.fill("C", capacityState, currentState, stack, tree)==true) {
				continue;
			}
			if(state.empty("A", currentState, stack, tree)==true) {
				continue;
			}
			if(state.empty("B", currentState, stack, tree)==true) {
				continue;
			}
			if(state.empty("C", currentState, stack, tree)==true) {
				continue;
			}
			//checks if any of the jugs can be poured into each other to get a new state
			if(state.pour("A","B",capacityState, currentState, stack, tree)==true) {
				continue;
			}	
			if(state.pour("A","C",capacityState,currentState, stack, tree)==true) {
				continue;
			}
			/*if none of the above functions return true, then it means there are no more
			 * possible unique states that can be reached from the state at the top of 
			 * the stack, hence the state at the top is deleted and the previous state
			 * is examined.
			 */
			stack.pop();		
		}	
		return tree;	
	}
}
