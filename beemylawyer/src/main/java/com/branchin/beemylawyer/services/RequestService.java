package com.branchin.beemylawyer.services;

import com.branchin.beemylawyer.classes.Request;
import com.branchin.beemylawyer.dto.RequestDTO;
import com.branchin.beemylawyer.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Request createRequest(Request request) {
        return this.requestRepository.save(request);
    }
}
