package edu.wmich.cs.AlexanderBoyd.Pa4.Objects;

import java.util.ArrayList;
import java.util.Collection;

import edu.wmich.cs.AlexanderBoyd.Pa4.visitor.Visitor;

public class Context extends InformationElement {

	public Context(String id, String description, ArrayList<Value> content) {
		this.setContent(content);
		this.setDescription(description);
		this.setId(id);
		
		this.from_source= new ArrayList<AssertedRealationship>();
		this.from_target= new ArrayList<AssertedRealationship>();
	}

	@Override
	public
	void setDescription(String value) {
		this.description = value;

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
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<AssertedRealationship> getFrom_target() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<AssertedRealationship> getFrom_source() {
		// TODO Auto-generated method stub
		return this.from_source;
	}

	@Override
	public void setFrom_source(Collection<AssertedRealationship> from_source) {
		this.from_source = from_source;
	}

}
