package xmlClasses;

import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class CreateHTMLTable {

	public static void main(String[] args) throws Exception {

		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Source xslDoc = new StreamSource("/Users/jeffreydeleeuw/eclipse-workspace/finalVersion/lib/stylesheet.xsl");
			Source xmlDoc = new StreamSource("/Users/jeffreydeleeuw/eclipse-workspace/finalVersion/lib/file.xml");
			String outputFileName = "/Users/jeffreydeleeuw/eclipse-workspace/finalVersion/lib/report.html";
			OutputStream htmlFile = new FileOutputStream(outputFileName);
			Transformer trasform = tFactory.newTransformer(xslDoc);
			trasform.transform(xmlDoc, new StreamResult(htmlFile));

		} catch (Exception e)

		{
			e.printStackTrace();
		}

	}

}