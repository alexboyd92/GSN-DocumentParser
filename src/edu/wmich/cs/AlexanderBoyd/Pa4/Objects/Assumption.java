package edu.wmich.cs.AlexanderBoyd.Pa4.Objects;

import java.util.ArrayList;
import java.util.Collection;

import edu.wmich.cs.AlexanderBoyd.Pa4.visitor.Visitor;

public class Assumption extends Claim {

	public Assumption(String id, String description, ArrayList<Value> content, boolean assumed, boolean toBeSupported) {
	 this.setId(id);
	 this.setDescription(description);
	 this.setContent(content);
	 this.setAssumed(assumed);
	 this.setToBeSupported(toBeSupported);
	 this.from_source= new ArrayList<AssertedRealationship>();
		this.from_target= new ArrayList<AssertedRealationship>();
	}

	@Override
	public boolean getAssumed() {
		// TODO Auto-generated method stub
		return this.assumed;
	}

	@Override
	public boolean getToBesupported() {
		// TODO Auto-generated method stub
		return this.assumed;
	}

	@Override
	public void setAssumed(Boolean value) {
		// TODO Auto-generated method stub
		this.assumed=value;
	}

	@Override
	public void setToBeSupported(Boolean value) {
		this.toBesupported=value;
		
	}

	@Override
	public
	void setDescription(String value) {
		this.description=value;
		
	}

	@Override
	public
	void accept(Visitor v) {
		v.visit(this);
		
	}

	@Override
	public
	void setId(String id) {
		this.id=id;
	}

	@Override
	public
	String getId() {
		// return the id of the object
		return this.id;
	}

	@Override
	public
	String getDescription() {
		//return the description of the object
		return this.description;
	}


	@Override
	void setContent(ArrayList<Value> content) {
		this.content=content;
		
	}

	@Override
	public
	ArrayList<Value> getContent() {
		// TODO Auto-generated method stub
		return this.content;
	}

	@Override
	public
	void setFrom_Target(Collection<AssertedRealationship> from_target) {
		this.from_target=from_target;
		
	}

	@Override
	public
	Collection<AssertedRealationship> getFrom_target() {
		// TODO Auto-generated method stub
		return this.from_target;
	}

	@Override
	public Collection<AssertedRealationship> getFrom_source() {
		// TODO Auto-generated method stub
		return this.from_source;
	}

	@Override
	public void setFrom_source(Collection<AssertedRealationship> from_source) {
	this.from_source=from_source;
		
	}



}
