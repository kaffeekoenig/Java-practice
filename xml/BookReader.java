package xml;

import annotations.SaveData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class BookReader {
    private static final Logger logger = Logger.getLogger(SaveData.class.getName());

    static {
        try {
            FileHandler fh = new FileHandler("xml-log.log", true);
            logger.addHandler(fh);
            fh.setFormatter(new SimpleFormatter());
            logger.setUseParentHandlers(false);
        } catch (IOException e) {
            logger.severe(e.toString());
        }
    }

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("xml\\books.xml"));
            document.getDocumentElement().normalize();
            logger.info("created xml successfully");

            StringBuilder jsonBuilder = new StringBuilder();
            jsonBuilder.append("{\n  \"books\": [\n");

            NodeList bookList = document.getElementsByTagName("book");

            for (int i = 0; i < bookList.getLength(); i++) {
                Element bookElement = (Element) bookList.item(i);

                jsonBuilder.append("\t{\n");
                jsonBuilder.append("\t\t\"book\": {\n");
                String id = bookElement.getAttribute("id");
                jsonBuilder.append("\t\t\t\"id\": ").append(id).append(",\n");

                jsonBuilder.append("\t\t\t\"author\": \"").append(getTextContent(bookElement, "author")).append("\",\n");
                jsonBuilder.append("\t\t\t\"name\": \"").append(getTextContent(bookElement, "name")).append("\",\n");
                jsonBuilder.append("\t\t\t\"year\": \"").append(getTextContent(bookElement, "year")).append("\"\n");


                jsonBuilder.append("\t\t}\n");
                jsonBuilder.append("\t}");
                if (i < bookList.getLength() - 1) {
                    jsonBuilder.append(",");
                }
                jsonBuilder.append("\n");
            }

            jsonBuilder.append("  ]\n}");
            logger.info("converted xml to json successfully");

            try (FileWriter file = new FileWriter("books.json")) {
                file.write(jsonBuilder.toString());
                logger.info("created json successfully");
            } catch (IOException e) {
                logger.log(Level.SEVERE, "conversion error", e);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.severe("parsing error");
        }
    }
    private static String getTextContent(Element parentElement, String tagName) {
        NodeList nodeList = parentElement.getElementsByTagName(tagName);
        return nodeList.item(0).getTextContent();
    }
}
