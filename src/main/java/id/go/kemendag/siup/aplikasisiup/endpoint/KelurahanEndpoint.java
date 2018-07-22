/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.go.kemendag.siup.aplikasisiup.endpoint;

import id.go.kemendag.siup.aplikasisiup.dao.KelurahanDao;
import id.go.kemendag.siup.aplikasisiup.dto.DaftarKelurahan;
import id.go.kemendag.siup.aplikasisiup.dto.DaftarKelurahanRequest;
import id.go.kemendag.siup.aplikasisiup.dto.DaftarKelurahanResponse;
import id.go.kemendag.siup.aplikasisiup.entity.Kelurahan;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author Bayu Aji Firmansyah
 */
@Endpoint
public class KelurahanEndpoint {

    @Autowired
    private KelurahanDao kelurahanDao;

    public List<Kelurahan> cari(String nama) {
        Iterable<Kelurahan> dataKelurahan = kelurahanDao.findAll();
        List<Kelurahan> hasil = new ArrayList<Kelurahan>();
        for (Kelurahan x : dataKelurahan) {
            hasil.add(x);
        }

        return hasil;
    }

    @PayloadRoot(localPart = "daftarKelurahanRequest", namespace = "http://kemendag.go.id/webservices/siup")
    @ResponsePayload
    public DaftarKelurahanResponse cariKelurahan(@RequestPayload DaftarKelurahanRequest request) {
        String cariNama = request.getPencarian().getNama();
        System.out.println("Mencari kelurahan dengan nama " + cariNama);

        DaftarKelurahanResponse resp = new DaftarKelurahanResponse();
        DaftarKelurahan soapBody = new DaftarKelurahan();
        soapBody.setKelurahan(cari(cariNama));
        resp.setDaftarKelurahan(soapBody);

        return resp;
    }
}
