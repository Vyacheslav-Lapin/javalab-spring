package demo.xml.sax;

import demo.xml.Food;
import lombok.SneakyThrows;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.xml.sax.HandlerBase;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MenuSaxHandlerTest {

    @Test
    @SneakyThrows
    @DisplayName("StartDocument method works correctly")
    void startDocument() {
        SAXParser reader = SAXParserFactory.newDefaultInstance().newSAXParser();
        MenuSaxHandler handler = new MenuSaxHandler();
        reader.parse(new InputSource("./src/test/resources/xml/menu.xml"), handler);

        List<Food> menu = handler.getFoodList();

        assertEquals(2, menu.size());
    }
}