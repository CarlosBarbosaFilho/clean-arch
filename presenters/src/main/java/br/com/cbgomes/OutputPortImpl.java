package br.com.cbgomes;

import br.com.cbgomes.domain.EntityPersistent;
import br.com.cbgomes.helper.ConverterUtils;
import br.com.cbgomes.ports.data.input.ObjectInputPort;
import br.com.cbgomes.ports.data.output.ObjectOutputPort;
import br.com.cbgomes.ports.output.InterfaceOutputPort;
import br.com.cbgomes.repository.RepositoryPresenter;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
public class OutputPortImpl implements InterfaceOutputPort {

    private final RepositoryPresenter repositoryPresenter;
    private final ConverterUtils converterUtils;

    public OutputPortImpl(RepositoryPresenter repositoryPresenter, ConverterUtils converterUtils) {
        this.repositoryPresenter = repositoryPresenter;
        this.converterUtils = converterUtils;
    }

    @Override
    public void save(ObjectInputPort objectInputPort) {
        this.repositoryPresenter.save((EntityPersistent)
                converterUtils.convertObjectInputPortToEntity(objectInputPort, EntityPersistent.class));
    }

    @Override
    public List<ObjectOutputPort> list() {
        var listEntities = this.repositoryPresenter.findAll();
        return (List<ObjectOutputPort>) converterUtils.convertToList(listEntities, ObjectOutputPort.class);
    }

    @Override
    public void delete(Long id) {
        this.repositoryPresenter.deleteById(id);
    }

    @Override
    public void update(ObjectInputPort objectInputPort, Long id) {
        var entityDatabase = this.repositoryPresenter.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        var entity =  (EntityPersistent) converterUtils.convertObjectInputPortToEntity(objectInputPort, EntityPersistent.class);
        entity.setId(id);
        this.repositoryPresenter.save(entity);
    }

}
