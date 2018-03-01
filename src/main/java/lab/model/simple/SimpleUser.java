package lab.model.simple;

import lab.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static lombok.AccessLevel.PRIVATE;

@Data
@Entity
@Table(name = "user")
@Builder
//@Component
@NoArgsConstructor
@FieldDefaults(level = PRIVATE)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SimpleUser implements User {

    @Id
    @GeneratedValue
    Long id;

    String firstName;

    String lastName;
}
