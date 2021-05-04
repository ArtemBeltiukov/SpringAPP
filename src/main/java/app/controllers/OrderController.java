package app.controllers;

import app.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/")
    public String getAll() throws IOException {


        String addr = "http://localhost:8090/ws/orders.wsdl";
        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "                  xmlns:gs=\"http://www.baeldung.com/springsoap/gen\">\n" +
                "    <soapenv:Header/>\n" +
                "    <soapenv:Body>\n" +
                "        <gs:getOrdersRequest>\n" +
                "            <gs:userID>1</gs:userID>\n" +
                "        </gs:getOrdersRequest>\n" +
                "    </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        URL url1 = new URL(addr);
        HttpURLConnection connection = (HttpURLConnection) url1.openConnection();

        connection.setRequestProperty("Content-Length", String.valueOf(request.length()));
        connection.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setRequestProperty("SoapAction", "http://ws.cdyne.com/VerifyEmail");
        connection.setDoOutput(true);
        PrintWriter pw = new PrintWriter(connection.getOutputStream());
        pw.write(request);
        pw.flush();

        connection.connect();

        BufferedReader rd = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));

        String line;
        String respond = "";

        respond = rd.readLine();
        while ((line = rd.readLine()) != null)
            respond = line;

        log.info("respond is "+respond);

        return respond;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable(name = "id") int id) {
        return null;
    }

    @PostMapping("/new")
    public ResponseEntity<?> create() {

        return null;
    }

}
