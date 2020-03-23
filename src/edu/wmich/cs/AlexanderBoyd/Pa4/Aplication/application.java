package edu.wmich.cs.AlexanderBoyd.Pa4.Aplication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.ArgumentElement;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.Goal;
import edu.wmich.cs.AlexanderBoyd.Pa4.visitor.Visitor;

public class application {

	public static void main(String[] args) {
		ArgumentElement root_node;
		Visitor v = new Visitor();
		String fileName = null;
		Scanner input = new Scanner(System.in);
		int selection = 0;
		HashMap<String, ArgumentElement> map = new HashMap<String, ArgumentElement>();

		do {
			System.out.println("Please select either 1 or 2");

			// check if input is an int
			if (input.hasNextInt()) {
				selection = input.nextInt();
			} else {
				// get rid of non int so no infinite loop
				String junk = input.nextLine();

			}

			if (selection == 1) {
				fileName = "CS3310_F18_GSN_Intro_TestingExample.xmi";

			} else if (selection == 2) {
				fileName = "GSNCS6600_F18_GSN_first.xmi";
			}
		} while (fileName == null);
		Parser test = new Parser();

		map = test.parse(fileName);
		root_node=findRoot(map);
		root_node.accept(v);
		input.close();
	}

	

	

	public static ArgumentElement findRoot(HashMap<String, ArgumentElement> map) {
		ArgumentElement tempVal = null;
		for (ArgumentElement value : map.values()) {
			
			if (value.getClass() == Goal.class) {
				if (value.getFrom_source().isEmpty()) {

					tempVal =value;
				}
			}

		}
		return tempVal;
	}
}
