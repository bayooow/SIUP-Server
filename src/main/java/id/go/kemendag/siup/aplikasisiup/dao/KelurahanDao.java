/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemendag.siup.aplikasisiup.dao;

import id.go.kemendag.siup.aplikasisiup.entity.Kelurahan;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Bayu Aji Firmansyah
 */
public interface KelurahanDao extends PagingAndSortingRepository<Kelurahan, Integer> {

}
