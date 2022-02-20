package main.metamodel;

public class Transition {

	private Object event;
	    private State targetState;
	    private boolean setOperation;
	    private boolean incrementOperation;
	    private boolean decrementOperation;
	    private String operationVariableName;
	    private String conditionVariableName;
	    private Integer conditionComparedValue;
	    private boolean conditionEqual;
	    private boolean conditionGreaterThan;
	    private boolean conditionLessThan;
	    private Integer SetValue;
	   
	    public Transition(Object event, State targetState) {
	    	this.event = event;
	    	this.targetState = targetState;
	    }
	   
	    public Transition(String event) {
	    	this.event = event;
	    }
	   
	    public Object getEvent() {
	    	return event;
	    }
	   
	    public State getTarget() {
	    	return targetState;
	    }
	   
	    public boolean hasSetOperation() {
	    	return setOperation;
	    }
	   
	    public boolean hasIncrementOperation() {
	    	return incrementOperation;
	    }
	   
	    public boolean hasDecrementOperation() {
	    	return decrementOperation;
	    }
	   
	    public String getOperationVariableName() {
	    	return operationVariableName;
	    }
	   
	    public boolean isConditional() {
	    	return (conditionEqual || conditionGreaterThan || conditionLessThan);
	    }
	   
	    public String getConditionVariableName() {
	    	return conditionVariableName;
	    }
	   
	    public Integer getConditionComparedValue() {
	    	return conditionComparedValue;
	    }
	   
	    public boolean isConditionEqual() {
	    	return conditionEqual;
	    }
	   
	    public boolean isConditionGreaterThan() {
	    	return conditionGreaterThan;
	    }
	   
	    public boolean isConditionLessThan() {
	    	return conditionLessThan;
	    }
	   
	    public boolean hasOperation() {
	    	return (setOperation || incrementOperation || decrementOperation);
	    }
	   
	    public Integer getSetValue() {
	    	return SetValue;
	    }
	   
	    // Generated setters and getters
	   
	    public void setEvent(Object event) {
	    	this.event = event;
	    }
	   
	    public void setTargetState(State targetState) {
	    	this.targetState = targetState;
	    }
	   
	    public void setSetOperation(boolean setOperation) {
	    	this.setOperation = setOperation;
	    }
	   
	    public void setIncrementOperation(boolean incrementOperation) {
	    	this.incrementOperation = incrementOperation;
	    }
	   
	    public void setDecrementOperation(boolean decrementOperation) {
	    	this.decrementOperation = decrementOperation;
	    }
	   
	    public void setOperationVariableName(String operationVariableName) {
	    	this.operationVariableName = operationVariableName;
	    }
	   
	    public void setConditionVariableName(String conditionVariableName) {
	    	this.conditionVariableName = conditionVariableName;
	    }
	   
	    public void setConditionComparedValue(Integer conditionComparedValue) {
	    	this.conditionComparedValue = conditionComparedValue;
	    }
	   
	    public void setConditionEqual(boolean conditionEqual) {
	    	this.conditionEqual = conditionEqual;
	    }
	   
	    public void setConditionGreaterThan(boolean conditionGreaterThan) {
	    	this.conditionGreaterThan = conditionGreaterThan;
	    }
	   
	    public void setConditionLessThan(boolean conditionLessThan) {
	    	this.conditionLessThan = conditionLessThan;
	    }
	   
	    public void setSetValue(Integer setValue) {
	    	SetValue = setValue;
	    }
	   
	
	

}
