package main.metamodel;

import java.util.ArrayList;
import java.util.List;

public class State {
	private String name;
	private List<Transition> trans = new ArrayList<>();
	
	public State(String name) {
		this.name = name;
	}
	
	public Object getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public List<Transition> getTransitions() {
		// TODO Auto-generated method stub
		return trans;
	}

	public Transition getTransitionByEvent(String string) {
		// TODO Auto-generated method stub
		String event = string;
	    for (Transition transition : trans) {
	    	if (transition.getEvent().equals(event)) {
	    		return transition;
	    	};
	    };
	    return null;
	}

}