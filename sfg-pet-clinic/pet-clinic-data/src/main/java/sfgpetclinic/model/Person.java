package sfgpetclinic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person extends BaseEntity {

    public Person(Long id, String name, String surname) {
        super(id);
        this.name = name;
        this.surname = surname;
    }

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String surname;

}
