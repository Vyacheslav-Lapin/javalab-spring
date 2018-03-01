package demo.xml;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Food {
    int id;
    String name;
    String price;
    String description;
    int calories;
}
