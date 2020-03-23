package edu.wmich.cs.AlexanderBoyd.Pa4.Objects;

public abstract class Claim extends ArgumentElement {
	boolean assumed;
	boolean toBesupported;

	public abstract boolean getAssumed();

	public abstract boolean getToBesupported();

	public abstract void setAssumed(Boolean value);

	public abstract void setToBeSupported(Boolean value);

}
