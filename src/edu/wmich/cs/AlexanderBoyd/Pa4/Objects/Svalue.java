package edu.wmich.cs.AlexanderBoyd.Pa4.Objects;

import org.w3c.dom.Attr;

public class Svalue extends Value {
String value;
public Svalue(Attr attributeNode) {
	setValue(attributeNode.getValue());
	
}
public Svalue(String value2) {
this.setValue(value2);
}
public void setValue(String value){
this.value=value;
};
public String getValue() {
	return this.value;
}

}
