package mx.com.geekflu.design.pattern.builder;


import java.util.ArrayList;
import java.util.List;


public class Builder {

	public static void main(String[] args) {
		
		String hello = "hello";
		System.out.println("<p>" + hello + "</p>");

		String[] words = { "hello", "world" };
		StringBuilder sb1 = new StringBuilder();
		// sb.append("bla").append("bla"); <--- Fluent interface allow to write long changes to build something
		sb1.append("<ul>\n");
		for (String w : words) {
			sb1.append(String.format("  <li>%s</li>\n", w));
		}
		sb1.append("</ul>");

		System.out.println(sb1.toString());

		HtmlBuilder builder = new HtmlBuilder("ul");
		builder
			.addChild("li", "hello")
			.addChild("li", "world")
			.addChild("li", "fuckers");
		System.out.println(builder);
	}

}

class HtmlElment {
	private String name;
	private String text;
	private List<HtmlElment> elements = new ArrayList<>();
	private int indentSize = 2;
	private final String newline = System.lineSeparator();

	public HtmlElment() {
	}

	public HtmlElment(String name, String text) {
		this.name = name;
		this.text = text;
	}

	private String toStringImpl(int indet) {
		StringBuilder sb1 = new StringBuilder();
		String i = String.join("", java.util.Collections.nCopies(indet * indentSize, " "));
		sb1.append(String.format("%s<%s>%s", i, name, newline));
		if (text != null && !text.isEmpty()) {
			sb1.append(String.join("", java.util.Collections.nCopies(indentSize * (indet + 1), " "))).append(text)
					.append(newline);
		}

		for (HtmlElment ele : this.elements) {
			sb1.append(ele.toStringImpl(indet + 1));
		}

		sb1.append(String.format("%s</%s>%s", i, name, newline));

		return sb1.toString();
	}

	@Override
	public String toString() {
		return toStringImpl(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<HtmlElment> getElements() {
		return elements;
	}

	public void setElements(List<HtmlElment> elements) {
		this.elements = elements;
	}

}

class HtmlBuilder {
	private String rootName;
	private HtmlElment root = new HtmlElment();

	public HtmlBuilder(String root) {
		this.rootName = root;
		this.root.setName(root);
	}

	public HtmlBuilder addChild(String childName, String childText) {
		HtmlElment e = new HtmlElment(childName, childText);
		this.root.getElements().add(e);
		return this; // <-- fluent interface for calling multiple changes
	}

	public void clear() {
		this.root = new HtmlElment();
		root.setName(this.rootName);
	}

	@Override
	public String toString() {
		return this.root.toString();
	}
}
