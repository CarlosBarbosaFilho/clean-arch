package br.com.cbgomes.helper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public record ConverterUtils<T>(ModelMapperConfiguration modelMapperConfiguration) {

    public List<T> convertToList(List<T> responses, Class<T> type) {
        return responses
                .stream()
                .map(response -> new ModelMapper().map(response, type))
                .collect(Collectors.toList());
    }

    public T convertRequestToObjectInputPort(T request, Class<T> type) {
        return modelMapperConfiguration.modelMapper().map(request, type);
    }

    public T convertObjectInputPortToEntity(T request, Class<T> type) {
        return modelMapperConfiguration.modelMapper().map(request, type);
    }

}
