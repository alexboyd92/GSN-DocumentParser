package edu.wmich.cs.AlexanderBoyd.Pa4.Objects;

import java.util.ArrayList;
import java.util.Collection;

import edu.wmich.cs.AlexanderBoyd.Pa4.visitor.Visitor;

public class SupportedBy extends AssertedRealationship {

	public SupportedBy(String id, String description, Object target, Object source) {
		this.setId(id);
		this.setDescription(description);
		
		this.setFrom_source( new ArrayList<AssertedRealationship>());
		this.setFrom_Target(new ArrayList<AssertedRealationship>());
	
	}

	public SupportedBy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public
	void setDescription(String description) {
		this.description=description;
		
	}

	@Override
	public void accept(Visitor v) {
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
		
		return this.id;
	}

	@Override
	void setContent(ArrayList<Value> content) {
		this.content=content;;
		
	}

	@Override
	public
	ArrayList<Value> getContent() {
		
		return this.content;
	}

	@Override
	public
	String getDescription() {
		
		return this.description;
	}

	@Override
	public ArgumentElement getTarget() {
		
		return this.target;
	}

	@Override
	public void setSource(ArgumentElement Source) {
		this.source = Source;
		
	}

	@Override
	public void setTarget(ArgumentElement target) {
		this.target=target;
		
	}

	@Override
	public ArgumentElement getSource() {
		
		return this.source;
	}

	@Override
	public Collection<AssertedRealationship> getFrom_source() {
		
		return this.from_source;
	}

	@Override
	public void setFrom_source(Collection<AssertedRealationship> from_source) {
	this.from_source=from_source;
		
	}

	@Override
	public
	void setFrom_Target(Collection<AssertedRealationship> from_target) {
		this.from_target = from_target;

	}

	@Override
	public
	Collection<AssertedRealationship> getFrom_target() {
		// TODO Auto-generated method stub
		return this.from_target;
	}

}
