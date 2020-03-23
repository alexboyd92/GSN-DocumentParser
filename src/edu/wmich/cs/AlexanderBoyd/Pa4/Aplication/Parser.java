package edu.wmich.cs.AlexanderBoyd.Pa4.Aplication;

import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.ArgumentElement;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.Assumption;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.Context;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.Goal;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.InContextOf;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.Justification;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.Solution;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.Strategy;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.SupportedBy;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.Svalue;
import edu.wmich.cs.AlexanderBoyd.Pa4.Objects.Value;

public class Parser {

	public HashMap<String, ArgumentElement> map = new HashMap<String, ArgumentElement>();

	public HashMap<String, ArgumentElement> parse(String fileName) {
		initialParse(fileName);
		parseForRelations(fileName);
		parseForStrategy(fileName);
		return map;
	}

	private void initialParse(String fileName) {
		ArgumentElement source;
		ArgumentElement target;
		Element node;

		String xmi_id;
		String id;
		String description;
		ArrayList<Value> content;
		

		String xsi_type;
		try {
			// get the instance of the document builder factory.
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();

			// get the document builder from the factory
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			// read the file to the parser
			Document doc = docBuilder.parse(new File(fileName));

			// get the elements by tag name
			NodeList nL = doc.getElementsByTagName("argumentElement");

			// first pass to create objects
			for (int i = 0; i < nL.getLength(); i++) {
				content = new ArrayList<Value>();
				node = (Element) nL.item(i);

				xmi_id = node.getAttribute("xmi:id");
				id = node.getAttribute("id");
				description = node.getAttribute("description");
				content.add(new Svalue(node.getAttributeNode("content").getValue()));

				xsi_type = node.getAttribute("xsi:type");

//        	System.out.println(i + ","+ node.getAttribute("xsi:type") + ","+ node.getAttribute("id") +","+ node.getAttribute("description")+","+ 
//            		node.getAttribute("content") +","+ node.getAttribute("assumed")+","+ node.getAttribute("toBeSupported"));

				switch (xsi_type) {

				case "ARM:Claim":
					boolean assumed = node.getAttribute("assummed").equals("true");
					boolean toBeSupported = node.getAttribute("toBeSupported").equals("true");

					if (id.startsWith("G")) {
						map.put(xmi_id, new Goal(id, description, content, assumed, toBeSupported));
					}

					else if (id.startsWith("A")) {
						map.put(xmi_id, new Assumption(id, description, content, assumed, toBeSupported));
					}

					else if (id.startsWith("J")) {
						map.put(xmi_id, new Justification(id, description, content, assumed, toBeSupported));
					}

					break;

				case "ARM:ArgumentReasoning":
					// create strategy node

					map.put(xmi_id, new Strategy(id, description, content));

					break;

				case "ARM:InformationElement":
					if (id.startsWith("Sn")) {
						map.put(xmi_id, new Solution(id, description, content));
					} else if (id.startsWith("C")) {
						map.put(xmi_id, new Context(id, description, content));
					}

					break;

				case "ARM:AssertedInference":

					source = map.get(node.getAttribute("source"));
					target = map.get(node.getAttribute("target"));

					map.put(xmi_id, new SupportedBy(id, description, target, source));

					break;

				case "ARM:AssertedEvidence":
					source = map.get(node.getAttribute("source"));
					target = map.get(node.getAttribute("target"));
					map.put(xmi_id, new SupportedBy(id, description, target, source));

					break;

				case "ARM:AssertedContext":
					Object source2 = map.get(node.getAttribute("source"));
					Object target2 = map.get(node.getAttribute("target"));
					map.put(xmi_id, new InContextOf(id, description, target2, source2));

					break;

				}
			}

			// Error Handling
		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line " + err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(" " + err.getMessage());

		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	private void parseForRelations(String fileName) {
		ArgumentElement source;
		ArgumentElement target;
		Element node;

		String xmi_id;

		String xsi_type;
		try {// get the instance of the document builder factory.
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();

			// get the document builder from the factory
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			// read the file to the parser
			Document doc = docBuilder.parse(new File(fileName));

			// get the elements by tag name
			NodeList nL = doc.getElementsByTagName("argumentElement");
			// Parse for linking
			for (int i = 0; i < nL.getLength(); i++) {
				node = (Element) nL.item(i);

				xmi_id = node.getAttribute("xmi:id");

				xsi_type = node.getAttribute("xsi:type");
				
				switch (xsi_type) {

				case "ARM:AssertedInference":
					// get the object pointed to by the string souce
					source = map.get(node.getAttribute("source"));
					// get the object that relates to the string stored as target
					target = map.get(node.getAttribute("target"));
					// create a temporary refrence variable to the object that xmi_id refers to
					SupportedBy temp = (SupportedBy) map.get(xmi_id);
					// set temps target to the target object
					temp.setTarget(target);
					// get the object temp is pointing to then get its arraylist of From_target and
					// add temp to it
					
					temp.getTarget().getFrom_target().add(temp);
					
					// set the objects source to the object in source
					temp.setSource(source);
					// get the object that is temps source and add temp to its arraylist of
					// From_source
					temp.getSource().getFrom_source().add(temp);
					break;
				// If case is asserted evidence create links for Supported by
				case "ARM:AssertedEvidence":
					SupportedBy tempJust = (SupportedBy) map.get(xmi_id);
					source = map.get(node.getAttribute("source"));
					target = map.get(node.getAttribute("target"));

					tempJust.setTarget(target);
					tempJust.getTarget().getFrom_target().add(tempJust);
					tempJust.setSource(source);
					tempJust.getSource().getFrom_source().add(tempJust);
					break;

				case "ARM:AssertedContext":
					InContextOf tempCont = (InContextOf) map.get(xmi_id);
					source = map.get(node.getAttribute("source"));
					target = map.get(node.getAttribute("target"));
					tempCont.setSource(source);
					tempCont.getSource().getFrom_source().add(tempCont);
					tempCont.setTarget(target);
					tempCont.getTarget().getFrom_target().add(tempCont);

					break;
				default:
					break;

				}
			}

		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line " + err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(" " + err.getMessage());

		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	private void parseForStrategy(String fileName) {
		
		ArgumentElement source;
		ArgumentElement target;
		SupportedBy sb2;
		SupportedBy sb1;

		Element node;

		String xmi_id;

		String xsi_type;
		try {// get the instance of the document builder factory.
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();

			// get the document builder from the factory
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			// read the file to the parser
			Document doc = docBuilder.parse(new File(fileName));

			// get the elements by tag name
			NodeList nL = doc.getElementsByTagName("argumentElement");
			// Parse for linking
			for (int i = 0; i < nL.getLength(); i++) {
				
				node = (Element) nL.item(i);
				// get xmi_id for this node
				xmi_id = node.getAttribute("xmi:id");
				// get xsi_type for this node
				xsi_type = node.getAttribute("xsi:type");

				switch (xsi_type) {
				// if xsi_type is ArgumentReasoning link insert the strategy node
				case "ARM:ArgumentReasoning":
					Strategy tempStrat = (Strategy) map.get(xmi_id);

					List<String> describedInferences = Arrays
							.asList(node.getAttribute("describedInference").split(" "));
					for (int j = 0; j < describedInferences.size(); j++) {
						
						// get described inference object
						sb1 = (SupportedBy) map.get(describedInferences.get(j));
						// get sb1s target
						target = sb1.getTarget();
						// get sb1s source
						source = sb1.getSource();
						// add source to temp strat
						tempStrat.getFrom_source().add(sb1);
						// change source of sb1 to tempstrat
						sb1.setSource(tempStrat);
						sb2 = new SupportedBy();
						// set the target of sb2 to tempSource
						sb2.setTarget(tempStrat);
						tempStrat.getFrom_target().add(sb2);
						// set the source of s2 to sb1s old source
						sb2.setSource(source);
						// remove old link from source and sb1
						source.getFrom_source().remove(sb1);
						//replace it with a link to sb2
						source.getFrom_source().add(sb2);
						
					}

					source = map.get(node.getAttribute("source"));
					target = map.get(node.getAttribute("target"));

					break;

				}
			}

		} catch (SAXParseException err) {
			System.out.println("** Parsing error" + ", line " + err.getLineNumber() + ", uri " + err.getSystemId());
			System.out.println(" " + err.getMessage());

		} catch (SAXException e) {
			Exception x = e.getException();
			((x == null) ? e : x).printStackTrace();

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

}
