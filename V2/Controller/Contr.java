package com.MaksDenysov.V2.Controller;

import com.MaksDenysov.V2.Service.RequestDTO;
import com.MaksDenysov.V2.Service.Serv;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/Data")

public class Contr {

    public Contr(Serv serv) {
        this.serv = serv;
    }

    private Serv serv;

    @PostMapping(value = "/a", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO addData(@RequestBody RequestDTO requestDTO){

        return serv.create(requestDTO);

    }

    @GetMapping(value = "/g",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO findData(@RequestParam Integer id){

        return serv.find(id);
    }
    @PutMapping(value = "/u" , produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseDTO updateData(@RequestParam Integer id, @RequestBody RequestDTO requestDTO){

        return serv.update(id, requestDTO);

    }
    @DeleteMapping(value = "/d", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String deleteData(@RequestParam Integer id){

        return serv.printMessage("Was deleted № - ") + serv.delete(id);

    }



}
