package demo.xml.sax;

import demo.xml.Food;
import demo.xml.MenuTagName;
import lombok.Data;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.extern.log4j.Log4j2;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static lombok.AccessLevel.PRIVATE;

@Data
@Log4j2
@FieldDefaults(level = PRIVATE)
public class MenuSaxHandler extends DefaultHandler {

    List<Food> foodList = new ArrayList<>();
    Food.FoodBuilder foodBuilder;
    StringBuilder text;

    @Override
    public void startDocument() throws SAXException {
        log.info("Parsing started.");
    }

    @Override
    public void endDocument() throws SAXException {
        log.info("Parsing ended.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        System.out.printf("startElement -> uri: %s, localName: %s, qName: %s%n", uri, localName, qName);

        text = new StringBuilder();

        if (qName.equals("food")) {
            foodBuilder = Food.builder();
            foodBuilder.id((parseInt(atts.getValue("id"))));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        MenuTagName tagName =
                MenuTagName.valueOf(qName.toUpperCase().replace("-", "_"));
        switch (tagName) {
            case NAME:
                foodBuilder.name(text.toString());
                break;
            case PRICE:
                foodBuilder.price(text.toString());
                break;
            case DESCRIPTION:
                foodBuilder.description(text.toString());
                break;
            case CALORIES:
                foodBuilder.calories(Integer.parseInt(text.toString()));
                break;
            case FOOD:
                foodList.add(foodBuilder.build());
                foodBuilder = null;
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);
    }


    @Override
    public void warning(SAXParseException exception) throws SAXException {
        log.warn("WARNING: line {}: {}", exception.getLineNumber(), exception.getMessage());
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        log.error("ERROR: line {}: {}", exception.getLineNumber(), exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        log.fatal("FATAL: line {}: {}", exception.getLineNumber(), exception.getMessage());
    }
}
