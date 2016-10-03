package Super_Trump;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;
/**
 * Created by jc319816 on 3/10/16.
 */

public class testing_html_again {

    public static void main(String[] args) throws Exception {
        //Get the DOM Builder Factory
        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();

        //Get the DOM Builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        //Load and Parse the XML document
        //document contains the complete XML as a Tree.
        Document document =
                builder.parse(
                        ClassLoader.getSystemResourceAsStream("Assignment_1_Jacob_Negri/Mineral_SuperTrumps/src/Super_Trump/MstCards_151021.plist"));

        List<Employee> cardInfo = new ArrayList<>();

        //Iterating through the nodes and extracting the data.
        NodeList nodeList = document.getDocumentElement().getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {

            //We have encountered an <employee> tag.
            Node node = nodeList.item(i);
            if (node instanceof Element) {
                Employee emp = new Employee();
                emp.id = node.getAttributes().
                        getNamedItem("id").getNodeValue();

                NodeList childNodes = node.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node cNode = childNodes.item(j);

                    //Identifying the child tag of employee encountered.
                    if (cNode instanceof Element) {
                        String content = cNode.getLastChild().
                                getTextContent().trim();
                        switch (cNode.getNodeName()) {
                            case "firstName":
                                emp.firstName = content;
                                break;
                            case "lastName":
                                emp.lastName = content;
                                break;
                            case "location":
                                emp.location = content;
                                break;
                        }
                    }
                }
                cardInfo.add(emp);
            }

        }

        //Printing the Employee list populated.
        for (Employee emp : cardInfo) {
            System.out.println(emp);
        }

    }
}

class Employee{
    String id;
    String firstName;
    String lastName;
    String location;

    @Override
    public String toString() {
        return firstName+" "+lastName+"("+id+")"+location;
    }
}