package cl.diegomartinez.db.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "chat")
@JsonFilter("chat")

public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Long id_usr1;
    private Long id_usr2;
    private String msj;
    private Timestamp timestamp;

}
