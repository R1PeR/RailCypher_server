package com.projekt10.server.Controller;
import com.projekt10.server.Main;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.projekt10.server.Service.RailFenceCipher;
import com.projekt10.server.Service.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

@Controller
@RequestMapping("/api/fence")
public class RailController {

    @RequestMapping(value = "/encode", method = RequestMethod.POST)
    @ResponseBody
    public Result encode(@RequestBody EncodeMessage encodeMessage) throws java.lang.Exception{
        return new Result(RailFenceCipher.Encode(encodeMessage.getEncodeMessage(), Main.key));
    }
    @RequestMapping(value = "/decode", method = RequestMethod.POST)
    @ResponseBody
    public Result decode(@RequestBody DecodeMessage decodeMessage) throws java.lang.Exception{
        return new Result(RailFenceCipher.Decode(decodeMessage.getDecodeMessage(), Main.key));
    }
}
