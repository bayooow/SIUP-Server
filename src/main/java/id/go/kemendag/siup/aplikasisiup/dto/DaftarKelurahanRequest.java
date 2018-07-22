/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemendag.siup.aplikasisiup.dto;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;

/**
 *
 * @author Bayu Aji Firmansyah
 */
@Data
@XmlAccessorType
@XmlRootElement(
        name = "daftarKelurahanRequest",
        namespace = "http://kemendag.go.id/webservices/siup"
)
public class DaftarKelurahanRequest {

    private Pencarian pencarian;
}
