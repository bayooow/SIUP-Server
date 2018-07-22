package id.go.kemendag.siup.aplikasisiup.controller;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.controller;

@Controller
public class WaktuController {

    @GetMapping("/waktu")
    @ResponseBody
    public Date sekarang() {
        return new Date();
    }

    @GetMapping("/appInfo")
    @ResponseBody

    public Map<String, String> info(@RequestParam String nama) {
        Map<String, String> data = new LinkedHashMap<>();
        data.put("application.name", "Aplikasi Siup");
        data.put("application.version", "1.0.0");
        data.put("last.update", "2018");
        data.put("author", nama);
        return data;
    }

}
