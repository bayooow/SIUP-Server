package id.go.kemendag.siup.aplikasisiup.entity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author Bayu Aji Firmansyah
 */
@Data
@Entity
@Table(name = "kelurahan")
public class Kelurahan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NotEmpty
    private String kode;
    @NotNull
    @NotEmpty
    private String nama;
    @NotNull
    @NotEmpty
    private String kodepos;
}
