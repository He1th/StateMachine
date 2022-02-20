package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class StateMachine {
    private final List<State> states = new ArrayList<>();
    public final Map<String, Integer> integers = new HashMap<>();
    public String currentTransition = null;
    public State initial;
    public State currentState;
    public Machine machine;
   
    public Machine build() {
    	return new Machine(states, initial, integers);
    }
   
    public StateMachine state(String string) {
    	
    	boolean contains = false;
	    State startState = null;
	    
	    for (State state : states) {
	    	if (state.getName().equals(string)) {
	    		contains = true;
	    		startState = state;
	    		break;
	    	}
	    }
	   
	    if (contains == true) {
	    	this.currentState = startState;
	    } else {
	    	State newState = new State(string);
	    	states.add(this.currentState = newState);
	    };
	   
	    return this;
    }
   
    public StateMachine initial() {
    	int index = states.size() - 1;
    	initial = states.get(index);
    	return this;    
    }
   
    public StateMachine when(String string) {
	    currentTransition = string;
	    return this;
    }
   
    public StateMachine to(String string) {
	    boolean contains = false;
	    State startState = null;
	    
	    for (State state : states) {
	    	if (state.getName().equals(string)) {
	    		contains = true;
	    		startState = state;
	    		break;
	    	}
	    }
	   
	    if (contains) {
	    	Transition transition = new Transition(currentTransition, startState);
	    	currentState.getTransitions().add(transition);
	    } else {
	    	State newState = new State(string);
	    	states.add(newState);
	    	currentState.getTransitions().add(new Transition(currentTransition, newState));
	    }
   
	    return this;
    }
   
    public StateMachine integer(String string) {
	    integers.put(string, 0);
	    return this;
    }
    
    private Transition getCurrentState() {
    	return this.currentState.getTransitions().get(this.currentState.getTransitions().size() - 1);
    }
   
    public StateMachine set(String string, int i) {
	    Transition currentState = this.getCurrentState();
	    currentState.setSetOperation(true);
	    currentState.setSetValue(i);
	    currentState.setOperationVariableName(string);
	    return this;
    }
   
    public StateMachine increment(String string) {
	    Transition currentState = this.getCurrentState();
	    currentState.setIncrementOperation(true);
	    currentState.setOperationVariableName(string);
	    return this;
    }
   
    public StateMachine decrement(String string) {
	    Transition currentState = this.getCurrentState();
	    currentState.setDecrementOperation(true);
	    currentState.setOperationVariableName(string);
	    return this;
    }
   
    public StateMachine ifEquals(String string, int i) {
	    Transition currentState = this.getCurrentState();
	    currentState.setConditionVariableName(string);
	    currentState.setConditionEqual(true);
	    currentState.setConditionComparedValue(i);
	    return this;
    }
   
    public StateMachine ifGreaterThan(String string, int i) {
    	Transition currentState = this.getCurrentState();
    	currentState.setConditionVariableName(string);
    	currentState.setConditionGreaterThan(true);
    	currentState.setConditionComparedValue(i);
	    return this;
    }
   
    public StateMachine ifLessThan(String string, int i) {
    	Transition currentState = this.getCurrentState();
    	currentState.setConditionVariableName(string);
    	currentState.setConditionLessThan(true);
    	currentState.setConditionComparedValue(i);
	    return this;
    }
    /*
    private Map<String, Object> findStateByName(String string) {
    	Map<String, Object> output = new HashMap<>();
	    boolean contains = false;
	    State state = null;
    	for (State s : states) {
	    	if (s.getName() == string) {
	    		contains = true;
	    		state = s;
	    		output.put("contains", contains);
	    		output.put("state", state);
	    		
	    	}
	    }
    	System.out.println(output);
    	return output;
    }
    */
    
	/*
    Map<String, Object> output = this.findStateByName(string);
    boolean contains = (boolean) output.get("contains");
    State startState = (State) output.get("state");
  	*/
	
    
}






