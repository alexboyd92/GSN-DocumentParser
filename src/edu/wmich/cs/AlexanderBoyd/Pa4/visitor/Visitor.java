package edu.wmich.cs.AlexanderBoyd.Pa4.visitor;

import java.util.List;

import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.ArgumentElement;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.AssertedRealationship;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.Assumption;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.Context;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.Goal;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.InContextOf;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.InformationElement;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.Justification;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.Solution;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.Strategy;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.SupportedBy;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.Value;

public class Visitor {

	public void visit(Goal goal) {
		Visitor v = new Visitor();
		System.out.printf("Id: %s\nContent: %s\nAssummed: %s\nTo Be Suported: %s\n", goal.getId(),
				goal.getContent().get(0).getValue(), goal.getAssumed() ? "true" : "false",
				goal.getToBesupported() ? "true" : "false");
		System.out.println("Source:");

		for (int i = 0; i < goal.getFrom_source().size(); i++) {
			ArgumentElement temp = ((List<AssertedRealationship>) goal.getFrom_source()).get(i).getTarget();

			if (temp.getClass() == SupportedBy.class) {

				System.out.println("Is source of:" + temp.getId());
			}
		}
		System.out.println("Target: ");

		for (int i = 0; i < goal.getFrom_target().size(); i++) {
			ArgumentElement temp = ((List<AssertedRealationship>) goal.getFrom_target()).get(i).getSource();
			if (temp.getClass() == Context.class) {

				System.out.println("Is in context of:" + temp.getId());
			}
			if (temp.getClass() == Strategy.class) {
				System.out.println("Is SupportedBy:" + temp.getId());
			}

		}
		for (int i = 0; i < goal.getFrom_target().size(); i++) {
			((List<AssertedRealationship>) goal.getFrom_target()).get(i).accept(v);
			;
		}

	}

	public void visit(Assumption assumption) {
		Visitor v = new Visitor();
		System.out.printf("Id: %s\nContent: %s\nAssummed: %s\nTo Be Suported: %s\n", assumption.getId(),
				assumption.getContent().get(0).getValue(), assumption.getAssumed() ? "true" : "false",
				assumption.getToBesupported() ? "true" : "false");
		System.out.println("Source:");

		for (int i = 0; i < assumption.getFrom_source().size(); i++) {
			ArgumentElement temp = ((List<AssertedRealationship>) assumption.getFrom_source()).get(i).getTarget();

			

				System.out.println("Is source of:" + temp.getId());
			
		}
		System.out.println("Target: ");

		for (int i = 0; i < assumption.getFrom_target().size(); i++) {
			ArgumentElement temp = ((List<AssertedRealationship>) assumption.getFrom_target()).get(i).getSource();
			if (temp.getClass() == Context.class) {

				System.out.println("Is in context of:" + temp.getId());
			}
			if (temp.getClass() == Strategy.class) {
				System.out.println("Is SupportedBy:" + temp.getId());
			}

		}
		for (int i = 0; i < assumption.getFrom_target().size(); i++) {
			((List<AssertedRealationship>) assumption.getFrom_target()).get(i).accept(v);
			;
		}
		
	}

	public void visit(Justification justification) {
		Visitor v = new Visitor();
		System.out.printf("Id: %s\nContent: %s\nAssummed: %s\nTo Be Suported: %s\n", justification.getId(),
				justification.getContent().get(0).getValue(), justification.getAssumed() ? "true" : "false",
				justification.getToBesupported() ? "true" : "false");
		System.out.println("Source:");

		for (int i = 0; i < justification.getFrom_source().size(); i++) {
			ArgumentElement temp = ((List<AssertedRealationship>) justification.getFrom_source()).get(i).getTarget();

			

				System.out.println("Is source of:" + temp.getId());
			
		}
		System.out.println("Target: ");

		for (int i = 0; i < justification.getFrom_target().size(); i++) {
			ArgumentElement temp = ((List<AssertedRealationship>) justification.getFrom_target()).get(i).getSource();
			if (temp.getClass() == Context.class) {

				System.out.println("Is in context of:" + temp.getId());
			}
			if (temp.getClass() == Strategy.class) {
				System.out.println("Is SupportedBy:" + temp.getId());
			}

		}
		for (int i = 0; i < justification.getFrom_target().size(); i++) {
			((List<AssertedRealationship>) justification.getFrom_target()).get(i).accept(v);
			;
		}
		
	}

	public void visit(Context context) {
		Visitor v = new Visitor();
		System.out.printf("Id: %s\nContent: %s", context.getId(), context.getContent().get(0).getValue());
		System.out.println("Source:");

		for (int i = 0; i < context.getFrom_source().size(); i++) {
			ArgumentElement temp = ((List<AssertedRealationship>) context.getFrom_source()).get(i).getTarget();

			

				System.out.println("Is source of:" + temp.getId());
			
		}
		System.out.println("Target: ");

		
		
		
	}

	public void visit(Strategy Strategy) {
		Visitor v = new Visitor();
		System.out.printf("ID: %s\nContent: %s\nDescription: %s\n", Strategy.getId(),
				Strategy.getContent().get(0).getValue(), Strategy.getDescription());
		System.out.println("Source: ");
		for (int i = 0; i < Strategy.getFrom_source().size(); i++) {

			ArgumentElement temp = ((List<AssertedRealationship>) Strategy.getFrom_source()).get(i).getTarget();

		
			System.out.println("Is Source of:" + temp.getId());
			
		}
		System.out.println("Target: ");

		for (int i = 0; i < Strategy.getFrom_target().size(); i++) {
			ArgumentElement temp = ((List<AssertedRealationship>) Strategy.getFrom_target()).get(i).getSource();

			if (temp.getClass() == Context.class) {

				System.out.println("Is in context of:" + temp.getId());
			} else if (temp.getClass() == Strategy.class) {
				System.out.println("Is SupportedBy:" + temp.getId());
			}

		}
		for (int i = 0; i < Strategy.getFrom_target().size(); i++) {
			((List<AssertedRealationship>) Strategy.getFrom_target()).get(i).accept(v);
			;
		}

	}

	public void visit(InContextOf InContextOf) {
		Visitor v = new Visitor();
		InContextOf.getSource().accept(v);
	}

	public void visit(SupportedBy SupportedBy) {
		Visitor v = new Visitor();
		SupportedBy.getSource().accept(v);

	}

	public void visit(Solution solution) {
		Visitor v = new Visitor();
		System.out.printf("ID: %s\nContent: %s\nDescription: %s", solution.getId(),
				solution.getContent().get(0).getValue(), solution.getDescription());
		System.out.println("Source:");

		for (int i = 0; i < solution.getFrom_source().size(); i++) {
			ArgumentElement temp = ((List<AssertedRealationship>) solution.getFrom_source()).get(i).getTarget();

			

				System.out.println("Is source of:" + temp.getId());
			
		}
		System.out.println("Target: ");

		for (int i = 0; i < solution.getFrom_target().size(); i++) {
			ArgumentElement temp = ((List<AssertedRealationship>) solution.getFrom_target()).get(i).getSource();
			if (temp.getClass() == Context.class) {

				System.out.println("Is in context of:" + temp.getId());
			}
			if (temp.getClass() == Strategy.class) {
				System.out.println("Is SupportedBy:" + temp.getId());
			}

		}
		for (int i = 0; i < solution.getFrom_target().size(); i++) {
			((List<AssertedRealationship>) solution.getFrom_target()).get(i).accept(v);
			;
		}
	}

}
