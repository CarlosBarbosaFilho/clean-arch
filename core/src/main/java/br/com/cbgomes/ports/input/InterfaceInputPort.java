package br.com.cbgomes.ports.input;

import br.com.cbgomes.ports.data.input.ObjectInputPort;
import br.com.cbgomes.ports.data.output.ObjectOutputPort;

import java.util.List;


public interface InterfaceInputPort {



    void save(ObjectInputPort objectInputPort);

    List<ObjectOutputPort> list();

    void delete(Long id);

    void update(ObjectInputPort objectInputPort, Long id);

}
