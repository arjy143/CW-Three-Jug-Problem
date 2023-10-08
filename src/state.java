import java.util.ArrayList;
import java.util.Stack;

public class state {
	int a;
	int b;
	int c;
	
	public state(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public int getA() { 
		return a;
	}	
	public int getB() { 
		return b;
	}	
	public int getC() {
		return c;
	}
	
	/*the fill function checks if there is a unique state that can be reached
	 * by filling any one jug to its capacity, and then adds this state to the tree.
	 */
	public static boolean fill(String jug, state capacityState, state currentState, Stack<state> stack, ArrayList<state> tree) {
		int aCurrent = currentState.getA();
		int bCurrent = currentState.getB();
		int cCurrent = currentState.getC();
		int aCapacity = capacityState.getA();
		int bCapacity = capacityState.getB();
		int cCapacity = capacityState.getC();
		
		if (jug =="A") {
			state stateToAdd = new state(aCapacity, bCurrent, cCurrent);
			if(addToTree(stateToAdd, stack, tree)) {
				return true;
			}
		}
		else if (jug == "B") {
			state stateToAdd = new state(aCurrent, bCapacity, cCurrent);
			if(addToTree(stateToAdd, stack, tree)) {
				return true;
			}
		}
		else if (jug == "C") {
			state stateToAdd = new state(aCurrent, bCurrent, cCapacity);
			if(addToTree(stateToAdd, stack, tree)) {
				return true;
			}
		}
		return false;
	}
	
	/*the pour function checks if any unique state can be reached by pouring the contents
	 * of one jug into another, then adds it to the tree.
	 */
	public static boolean pour(String jug1, String jug2, state capacityState, state currentState, Stack<state> stack, ArrayList<state> tree) {
		int aCurrent = currentState.getA();
		int bCurrent = currentState.getB();
		int cCurrent = currentState.getC();
		int bCapacity = capacityState.getB();
		int cCapacity = capacityState.getC();
		
		if (jug1 == "A") {
			if (jug2 == "B") {
				if (bCapacity>=aCurrent+bCurrent) {
					state stateToAdd = new state(0, aCurrent+bCurrent, cCurrent);
					if(addToTree(stateToAdd, stack, tree)) {
						return true;
					}
				}
				else if (bCapacity<aCurrent+bCurrent) {
					state stateToAdd = new state((aCurrent+bCurrent)-bCapacity, bCapacity, cCurrent);
					if(addToTree(stateToAdd, stack, tree)) {
						return true;
					}				
				}
			}
			else if (jug2 == "C") {
				if (cCapacity>=aCurrent+cCurrent) {
					state stateToAdd = new state(0, bCurrent, aCurrent+cCurrent);
					if(addToTree(stateToAdd, stack, tree)) {
						return true;
					}
				}
				else if (cCapacity<aCurrent+cCurrent) {
					state stateToAdd = new state((aCurrent+cCurrent)-cCapacity, bCurrent, cCapacity);
					if(addToTree(stateToAdd, stack, tree)) {
						return true;
					}				
				}
			}
		}
		return false;
		
	}
	/*the empty function checks if there is a unique state that can be reached by 
	 * emptying a jug, and then adds it to the tree.
	 */
	public static boolean empty(String jug, state currentState, Stack<state> stack, ArrayList<state> tree) {
		int aCurrent = currentState.getA();
		int bCurrent = currentState.getB();
		int cCurrent = currentState.getC();
		
		if (jug =="A") {
			state stateToAdd = new state(0, bCurrent, cCurrent);
			if(addToTree(stateToAdd, stack, tree)) {
				return true;
			}
		}
		else if (jug == "B") {
			state stateToAdd = new state(aCurrent, 0, cCurrent);
			if(addToTree(stateToAdd, stack, tree)) {
				return true;
			}
		}
		else if (jug == "C") {
			state stateToAdd = new state(aCurrent, bCurrent, 0);
			if(addToTree(stateToAdd, stack, tree)) {
				return true;
			}
		}
		return false;
	}
		
	//checks if the given state is unique, and if it is then it is added to the tree.
	public static boolean addToTree(state stateToAdd, Stack<state> stack, ArrayList<state> tree) {

		for (state node: tree) {

			if (state.bothSame(stateToAdd, node)) {
				return false;
			}
		}
		tree.add(stateToAdd);
		stack.push(stateToAdd);
		return true;
	}
	
	//this function checks if 2 states are the same by comparing their respective A's, B's and C's
	private static boolean bothSame(state stateToAdd, state node) {
		int aStateToAdd = stateToAdd.getA();
		int bStateToAdd = stateToAdd.getB();
		int cStateToAdd = stateToAdd.getC();
		int aNode = node.getA();
		int bNode = node.getB();
		int cNode = node.getC();

		if (aStateToAdd == aNode && bStateToAdd == bNode && cStateToAdd == cNode) {
		return true;
		}
	return false;
	}
//	@Override
//	public boolean equals(Object object) {
//		state stateToAdd = (state) object;
//		state node = this;
//		int aStateToAdd = stateToAdd.getA();
//		int bStateToAdd = stateToAdd.getB();
//		int cStateToAdd = stateToAdd.getC();
//		int aNode = node.getA();
//		int bNode = node.getB();
//		int cNode = node.getC();
//
//		if (aStateToAdd == aNode && bStateToAdd == bNode && cStateToAdd == cNode) {
//		return true;
//		}
//	return false;
//	}
	
	@Override
	public String toString() { 
		return ("("+this.getA()+", "+this.getB()+", "+this.getC()+")");
	}

	
		
}
