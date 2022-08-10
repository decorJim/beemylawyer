package com.branchin.beemylawyer.services;

import com.branchin.beemylawyer.classes.Request;
import com.branchin.beemylawyer.dto.RequestDTO;
import com.branchin.beemylawyer.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

    public Request dtoToRequest(RequestDTO requestDTO) {
       Request request=new Request(
               requestDTO.getId(),
               requestDTO.getLawyerId(),
               requestDTO.getLawyerName(),
               requestDTO.getState(),
               requestDTO.getClientName(),
               requestDTO.getPhoneNumber(),
               requestDTO.getClientEmail(),
               requestDTO.getDescription()
       );
       return request;
    }

    public RequestDTO requestToDto(Request request) {
        RequestDTO requestDTO=new RequestDTO(
                request.getId(),
                request.getLawyerId(),
                request.getLawyerName(),
                request.getClientEmail(),
                request.getState(),
                request.getClientName(),
                request.getPhoneNumber(),
                request.getClientEmail(),
                request.getDescription()
        );
        return requestDTO;
    }

    public Request createRequest(Request request) {
        return this.requestRepository.save(request);
    }

    public List<Request> getRequestByLawyerId(String id) {
        return this.requestRepository.findAllByLawyerId(id);
    }
}
