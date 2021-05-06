package app.controllers;

import com.baeldung.springsoap.gen.GetOrdersRequest;
import com.baeldung.springsoap.gen.GetOrdersResponse;
import com.baeldung.springsoap.gen.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigInteger;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

    @GetMapping("/")
    public String getAll() throws Exception {
        if (marshaller.getPackagesToScan() == null) {
            marshaller.setPackagesToScan(ClassUtils.getPackageName(GetOrdersRequest.class));
            marshaller.afterPropertiesSet();
        }
        WebServiceTemplate ws = new WebServiceTemplate(marshaller);
        GetOrdersRequest request = new GetOrdersRequest();
        request.setUserID(BigInteger.valueOf(1));
        String addr = "http://localhost:8090/ws";
        GetOrdersResponse response = (GetOrdersResponse) ws.marshalSendAndReceive(addr, request);
        Order result = response.getOrder();
        return "found order with id: " + result.getId() + " userID: " + result.getUserID() + " counteragent: " + result.getCounteragent();
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
