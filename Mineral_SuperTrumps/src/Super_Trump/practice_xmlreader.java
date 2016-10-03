//package Super_Trump;
//
///**
// * Created by jc319816 on 3/10/16.
// */
//public class practice_xmlreader {
//
//}
//
//package Super_Trump;
//
//
//public class practice_xmlreader {
//public static void main(String[] args) throws XMLStreamException, IOException {
//
//        InputStream in = new FileInputStream("File.plist");
//        XMLInputFactory factory = XMLInputFactory.newInstance();
//        XMLEventReader parser = factory.createXMLEventReader(in);
//
//        assert parser.nextEvent().isStartDocument();
//
//        XMLEvent event = parser.nextTag();
//        //System.out.println(event.getClass());
//        assert event.isStartElement();
//final String name1 = event.asStartElement().getName().getLocalPart();
//
//        if (name1.equals("dict")) {
//        while ((event = parser.nextTag()).isStartElement()) {
//final String name2 = event.asStartElement().getName().getLocalPart();
//
//        if (name2.equals("key")) {
//        String key = parser.getElementText();
//        System.out.println("key: " + key);
//
//        } else if (name2.equals("String")) {
//        String number = parser.getElementText();
//        System.out.println("date: " + number);
//
//        } else if (name2.equals("date")) {
//        String str = parser.getElementText();
//        System.out.println("date: " + str);
//        }
//        }
//        }
//
//        assert parser.nextEvent().isEndDocument();
//        }}