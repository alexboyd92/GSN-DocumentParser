package edu.wmich.cs.AlexanderBoyd.Pa4.Objects;

import java.util.ArrayList;
import java.util.Collection;

import edu.wmich.cs.AlexanderBoyd.Pa4.visitor.Visitor;


public class Goal extends Claim {

	public Goal(String id, String description, ArrayList<Value> content, boolean assumed, boolean toBeSupported) {
		this.setId(id);
		this.setDescription(description);
		this.setAssumed(assumed);
		this.setToBeSupported(toBeSupported);
		this.setContent(content);
		this.from_source= new ArrayList<AssertedRealationship>();
		this.from_target= new ArrayList<AssertedRealationship>();
	}

	public Goal() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	@Override
	public void setDescription(String value) {
		this.description = value;
	}

	@Override
	public boolean getAssumed() {
		return this.assumed;

	}

	@Override
	public void setAssumed(Boolean value) {
		this.assumed = value;
	}

	@Override
	public void setToBeSupported(Boolean value) {

	}

	@Override
	public
	void accept(Visitor v) {
		v.visit(this);

	}

	@Override
	public
	void setId(String id) {
		this.id = id;

	}

	@Override
	public
	String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public boolean getToBesupported() {
		// TODO Auto-generated method stub
		return this.toBesupported;
	}

	@Override
	void setContent(ArrayList<Value> content) {
		this.content = content;

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
		// TODO Auto-generated method stub
		
	}

}
