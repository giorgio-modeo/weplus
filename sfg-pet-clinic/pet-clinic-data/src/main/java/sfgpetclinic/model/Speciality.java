package sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Speciality extends BaseEntity {

    @Column(name = "description")
    private String description;

}
