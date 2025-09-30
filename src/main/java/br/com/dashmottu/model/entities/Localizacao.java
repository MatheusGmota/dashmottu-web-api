package br.com.dashmottu.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "tb_localizacao")
@Getter @Setter
@NoArgsConstructor
@SequenceGenerator(name = "localizacao", sequenceName = "SQ_TB_LOCALIZACAO",allocationSize = 1)
public class Localizacao {

    @Id
    @Column(name = "id_loc")
    @GeneratedValue(generator = "localizacao", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "posicao_x", precision = 6)
    private Double posicaoX;

    @Column(name = "posicao_y", precision = 6)
    private Double posicaoY;

    @Temporal(TemporalType.TIMESTAMP)
    private Date ultimaModificacao;

    @JsonIgnore
    @OneToOne(mappedBy = "localizacao")
    private Moto moto;

    public Localizacao(Double posicaoy, Double posicaoX) {
        this.posicaoY = posicaoy;
        this.posicaoX = posicaoX;
    }
}