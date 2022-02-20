package main;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class MachineInterpreter {

	private Machine machine;
    private State currentState;
   
    public void run(Machine m) {
    	currentState = m.getInitialState();
    	this.machine = m;
    }
   
    public State getCurrentState() {
    return currentState;
    }
   
    public void processEvent(String string) {
    	for (Transition trans : currentState.getTransitions()) {
    		if (trans.getEvent().equals(string)) {
   
		    Integer val = trans.isConditional() ? this.getInteger(trans.getConditionVariableName()) : null;
		    
		    if (isValid(trans, val)) {
   
		    	
				    if (trans.hasSetOperation())
				    	machine.getIntegers().put(trans.getOperationVariableName().toString(), trans.getSetValue());
				    
				    if (trans.hasIncrementOperation()) 
				    	machine.getIntegers().put(trans.getOperationVariableName().toString(),machine.getIntegers().get(trans.getOperationVariableName()) + 1);
				    
				    if (trans.hasDecrementOperation())
				    	machine.getIntegers().put(trans.getOperationVariableName().toString(),machine.getIntegers().get(trans.getOperationVariableName()) - 1);
				    
				   
				    currentState = trans.getTarget();
				    break;
    			}
    		}
    	}
    }
    
    
    public boolean isValid(Transition trans, Integer val) {
    	 return (!trans.isConditional()
 			    || (trans.isConditionEqual() &&
 			    	val.equals(trans.getConditionComparedValue()))
 			    || (trans.isConditionGreaterThan() && val >
 			    	trans.getConditionComparedValue())
 			    || (trans.isConditionLessThan() && val <
 			    	trans.getConditionComparedValue()));
    }
   
    public int getInteger(String string) {
    	return machine.getIntegers().get(string);
    }
   
}
