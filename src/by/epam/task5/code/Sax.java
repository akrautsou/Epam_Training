package by.epam.task5.code;

import by.epam.task5.code.entity.Message;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

enum MessageEnum {
    TO, FROM, HEADING, BODY
}

public class Sax extends DefaultHandler {
    private ArrayList<Message> messages = new ArrayList<>();
    private Message curr = null;
    private MessageEnum currentEnum = null;
    private StringBuffer result;

    public Sax() {
        result = new StringBuffer();
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    @Override
    public void startDocument() {
        System.out.println("Начало");
    }

    @Override
    public void startElement(String url, String localName, String qName, Attributes attrs) {
        //имя тега
        result.append("Имя тега = '").append(qName).append("'\n");
        //атрибуты тега
        for (int i = 0; i < attrs.getLength(); i++) {
            result.append("Имя атрибута = '").append(attrs.getQName(i))
                    .append("'; Значение атрибута = '").append(attrs.getValue(i)).append("'\n");
        }
        if (qName.equals("note")) {
            curr = new Message();
            curr.setId(Integer.valueOf(attrs.getValue(0)));
        }
        if (!qName.equals("notes") && !"note".equals(qName))
            currentEnum = MessageEnum.valueOf(qName.toUpperCase());
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        //закрытие тега
        result.append("Закрытый тег с именем = '").append(qName).append("'\n");
        if (qName.equals("note"))
            messages.add(curr);
        currentEnum = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (s.length() != 0) {
            result.append("Содержимое тега = '").append(s.trim()).append("'\n");
            if (currentEnum != null){
                switch (currentEnum) {
                    case TO:
                        curr.setTo(s);
                        System.out.println("TO " + s);
                        break;
                    case FROM:
                        curr.setFrom(s);
                        System.out.println("FROM " + s);
                        break;
                    case HEADING:
                        curr.setHeading(s);
                        System.out.println("HEADING " + s);
                        break;
                    case BODY:
                        curr.setBody(s);
                        System.out.println("BODY " + s.trim());
                        break;

                }
            }
        }
    }

    public String getResult() {
        return result.toString();
    }
}