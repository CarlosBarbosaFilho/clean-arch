package br.com.cbgomes.ports.output;

import br.com.cbgomes.ports.data.input.ObjectInputPort;
import br.com.cbgomes.ports.data.output.ObjectOutputPort;

import java.util.List;


public interface InterfaceOutputPort {

    void save(ObjectInputPort objectInputPort);

    List<ObjectOutputPort> list();

    void delete(Long id);

    void update(ObjectInputPort objectInputPort, Long id);
}
