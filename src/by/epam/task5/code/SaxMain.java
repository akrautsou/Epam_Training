package by.epam.task5.code;

import by.epam.task5.code.entity.Message;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;

public class SaxMain {

    private final static String PATH = "C:\\Users\\Drico\\Documents\\IdeaProjects\\epam" +
            "\\Epam_Training\\src\\by\\epam\\task5\\code\\file\\data.xml";

    public static void main(String[] args) {
        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            Sax sh = new Sax();
            reader.setContentHandler(sh);
            reader.parse(PATH);
            ArrayList<Message> messages = sh.getMessages();
            System.out.println("\nСообщения");
            for (Message message : messages) {
                System.out.print(message);
                System.out.println("=========================");
            }
            System.out.println("Количество сообщений: " + messages.size() + "\n");
            System.out.println("Результат:\n" + sh.getResult());
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }


}
