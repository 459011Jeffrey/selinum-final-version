package xmlClasses;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XPathCheck {
	public static void main(String[] args) {
		run();
	}

	public static void run() {
		try { 
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true); 
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("lib/file.xml");

			XPathFactory xpathfactory = XPathFactory.newInstance();
			XPath xpath = xpathfactory.newXPath();

			System.err.println("Get names of coaches");
			XPathExpression expr = xpath.compile("/basketball/coach/name/firstname/text()");
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getNodeValue());
			}

			System.err.println("in a different way the lastnames");
			expr = xpath.compile("//coach/name/lastname/text()");
			result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getNodeValue());
			}

			System.err.println("Return the last name of the players who play for Chicago Bulls:");        
			expr = xpath.compile("/basketball/player/team_ref[@idref='CHI']/../name/firstname/text()");
			result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.println(nodes.item(i).getNodeValue());
			}

			System.err.println("Return the count of player with Wa");
			expr = xpath.compile("count(//player/name/lastname[starts-with(text(), 'Wa')])");
			result = expr.evaluate(doc, XPathConstants.NUMBER);
			System.out.println(result);

			expr = xpath.compile("//player/name/lastname[starts-with(text(), 'Wa')]/text()");
			result = expr.evaluate(doc, XPathConstants.NODESET);
			nodes = (NodeList) result;
			for (int i = 0; i < nodes.getLength(); i++) {
				System.out.print(nodes.item(i).getNodeValue() + " ");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("somehing went wrong checking xpath");
		}
	}	
}
