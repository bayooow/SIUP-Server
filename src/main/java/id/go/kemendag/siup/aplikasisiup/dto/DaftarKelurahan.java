/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemendag.siup.aplikasisiup.dto;

import id.go.kemendag.siup.aplikasisiup.entity.Kelurahan;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Bayu Aji Firmansyah
 */
@Data
public class DaftarKelurahan {

    private List<Kelurahan> kelurahan = new ArrayList<>();
}
