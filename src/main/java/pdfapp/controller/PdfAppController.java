package pdfapp.controller;

import org.aspectj.util.FileUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class PdfAppController {

    @RequestMapping(method = RequestMethod.GET, value="/view", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> viewPdf() throws IOException {
        File file = new File("Justin_Allen_Resume.pdf");
        byte[] content = FileUtil.readAsByteArray(file);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return new ResponseEntity<>(content, headers, HttpStatus.OK);
    }
}
