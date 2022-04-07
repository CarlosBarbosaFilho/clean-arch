package br.com.cbgomes.usecase;

import br.com.cbgomes.helper.ConverterUtils;
import br.com.cbgomes.ports.data.input.ObjectInputPort;
import br.com.cbgomes.ports.data.output.ObjectOutputPort;
import br.com.cbgomes.ports.input.InterfaceInputPort;
import br.com.cbgomes.ports.output.InterfaceOutputPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InputPortImpl implements InterfaceInputPort {

    private final InterfaceOutputPort interfaceOutputPort;
    private final ConverterUtils converterUtils;

    public InputPortImpl(InterfaceOutputPort interfaceOutputPort, ConverterUtils converterUtils) {
        this.interfaceOutputPort = interfaceOutputPort;
        this.converterUtils = converterUtils;
    }

    @Override
    public void save(ObjectInputPort objectInputPort) {
         this.interfaceOutputPort.save(objectInputPort);
    }

    @Override
    public List<ObjectOutputPort> list() {
        return (List<ObjectOutputPort>) converterUtils.convertToList(this.interfaceOutputPort.list(), ObjectOutputPort.class);
    }

    @Override
    public void delete(Long id) {
        this.interfaceOutputPort.delete(id);
    }

    @Override
    public void update(ObjectInputPort objectInputPort, Long id) {
        this.interfaceOutputPort.update(objectInputPort, id);
    }

}
