/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemendag.siup.aplikasisiup.controller;

import id.go.kemendag.siup.aplikasisiup.dao.KelurahanDao;
import id.go.kemendag.siup.aplikasisiup.entity.Kelurahan;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Bayu Aji Firmansyah
 */
@Controller
public class KelurahanApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(KelurahanApiController.class);

    @Autowired
    private KelurahanDao kelurahanDao;

    @GetMapping("/api/kelurahan")
    @ResponseBody
    public List<Kelurahan> dataKelurahan(Pageable pgbl) {
        return kelurahanDao.findAll(pgbl).getContent();
    }
    // ini diganti karena di client gabisa getcontent jadi page, jadi harus list returnnya
//    public Page<Kelurahan> dataKelurahan(Pageable pgbl) {
//        return kelurahanDao.findAll(pgbl);
//    }

    @GetMapping("/api/kelurahan/{id}")
    @ResponseBody
    public Kelurahan cariKelurahanById(@PathVariable(name = "id") Kelurahan id) {
        return id;
    }
    //bisa juga kaya begini
//    public Kelurahan cariKelurahanById(@PathVariable(name = "id") Integer id) {
//        Optional<Kelurahan> data = kelurahanDao.findById(id);
//        if (data.isPresent()) {
//            return data.get();
//        } else {
//            return null;
//        }
//    }

    @PostMapping("/api/kelurahan")
    @ResponseStatus(HttpStatus.CREATED)
    public void simpan(@RequestBody @Valid Kelurahan k) {
        kelurahanDao.save(k);
    }

    // put itu dipake buat sesuatu yang idempotent: sesuatu yang kalo dilakukan berulang ulang ga ada efek samping. contoh idempotent lainnya adalah method delete
    //getter setter disebut sebagai boillercode
    @PutMapping("/api/kelurahan/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable(name = "id") Integer id, @RequestBody @Valid Kelurahan input) {
        Kelurahan dariDatabase = kelurahanDao.findById(id).get();

        if (dariDatabase == null) {
            LOGGER.warn("Kelurahan dengan id {} tidak ada di database", id);
            return;
        }
        BeanUtils.copyProperties(input, dariDatabase);
        dariDatabase.setId(id);
        kelurahanDao.save(dariDatabase);
//        save ini kalo idnya nul di abakalan insert, kalo idnya ada di abakalan update
    }

    @DeleteMapping("/api/kelurahan/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void hapus(@PathVariable(name = "id") Kelurahan k) {
        if (k != null) {
            kelurahanDao.delete(k);
        }
    }
}
