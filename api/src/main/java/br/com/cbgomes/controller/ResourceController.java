package br.com.cbgomes.controller;

import br.com.cbgomes.helper.ConverterUtils;
import br.com.cbgomes.ports.data.input.ObjectInputPort;
import br.com.cbgomes.ports.input.InterfaceInputPort;
import br.com.cbgomes.request.ObjectRequest;
import br.com.cbgomes.response.ObjectResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ( "/api" )
@AllArgsConstructor
public class ResourceController {

    private final InterfaceInputPort interfaceInputPort;
    private final ConverterUtils converterUtils;

    @GetMapping
    public ResponseEntity<List<ObjectResponse>> listObjectsResponse() {
        return ResponseEntity.ok(converterUtils.convertToList(this.interfaceInputPort.list(), ObjectResponse.class));
    }

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public void create(@RequestBody ObjectRequest request) {
        var objectInputPort = (ObjectInputPort) converterUtils.convertRequestToObjectInputPort(request, ObjectInputPort.class);
        this.interfaceInputPort.save(objectInputPort);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus( HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        this.interfaceInputPort.delete(id);
    }

    @PutMapping
    @ResponseStatus( HttpStatus.NO_CONTENT)
    public void update(@RequestBody ObjectRequest request, @RequestParam Long id) {
        this.interfaceInputPort.update((ObjectInputPort) converterUtils.convertRequestToObjectInputPort(request, ObjectInputPort.class), id);
    }
}
