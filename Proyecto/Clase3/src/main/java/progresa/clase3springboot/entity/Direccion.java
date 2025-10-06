package progresa.clase3springboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "numero")
    private String numero;

    @Column(name = "calle")
    private String calle;

    @Column(name = "CPostaal")
    private String CPostaal;

    @OneToOne
    private Restaurante restaurante;
}

