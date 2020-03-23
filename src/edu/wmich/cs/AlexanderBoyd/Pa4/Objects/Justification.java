package edu.wmich.cs.AlexanderBoyd.Pa4.Objects;

import java.util.ArrayList;
import java.util.Collection;

import edu.wmich.cs.AlexanderBoyd.Pa4.visitor.Visitor;

public class Justification extends Claim {

	public Justification(String id, String description, ArrayList<Value> content, boolean assumed,
			boolean toBeSupported) {
		this.setId(id);
		this.setDescription(description);
		this.setAssumed(assumed);
		this.setToBeSupported(toBeSupported);
		this.setContent(content);
		this.from_source= new ArrayList<AssertedRealationship>();
		this.from_target= new ArrayList<AssertedRealationship>();
	}

	@Override
	public boolean getAssumed() {
		// return the value of assumed
		return this.assumed;
	}

	@Override
	public boolean getToBesupported() {
		// return value of toBeSupported
		return this.toBesupported;
	}

	@Override
	public void setAssumed(Boolean value) {
		this.assumed = value;
	}

	@Override
	public void setToBeSupported(Boolean value) {
		this.toBesupported = value;

	}

	@Override
	public
	void setDescription(String value) {
		this.description = value;

	}

	@Override
	 public void accept(Visitor v) {
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
		return this.id;
	}

	@Override
	public
	String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	@Override
	void setContent(ArrayList<Value> content) {
		this.content = content;

	}

	@Override
	public
	ArrayList<Value> getContent() {

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
