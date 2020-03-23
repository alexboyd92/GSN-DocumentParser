package edu.wmich.cs.AlexanderBoyd.Pa4.Objects;

import java.util.ArrayList;
import java.util.Collection;

import edu.wmich.cs.AlexanderBoyd.Pa4.visitor.Visitor;

public  abstract class   ArgumentElement {
	// Create arraylist to store content of the node
protected ArrayList<Value> content = new ArrayList<Value>();
protected Collection <AssertedRealationship> from_target;
protected Collection <AssertedRealationship> from_source;
 // arraylist to store relationships of node
protected ArrayList<AssertedRealationship> Assrt = new ArrayList<AssertedRealationship>();
 // string to hold description of the node
protected String description;
 // string to hold id of the node
protected String id;
 // set the description of the node
public abstract void setDescription(String description);
// accept the visitor method
 public abstract void accept(Visitor v);
// set id
 public abstract void setId(String id);
 // get id 
 public abstract String getId();
// set content of the node
abstract void setContent(ArrayList<Value> content);
// return content of the node
public abstract ArrayList<Value> getContent();
// get description of the node;
public  abstract String getDescription();
public abstract void setFrom_Target(Collection <AssertedRealationship> from_target);
public abstract Collection <AssertedRealationship> getFrom_target();
public  abstract Collection <AssertedRealationship> getFrom_source();
public abstract void setFrom_source(Collection <AssertedRealationship> from_source);





	
}
