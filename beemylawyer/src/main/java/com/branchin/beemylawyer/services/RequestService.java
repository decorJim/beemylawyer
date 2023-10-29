package com.branchin.beemylawyer.services;

import com.branchin.beemylawyer.classes.Request;
import com.branchin.beemylawyer.dto.RequestDTO;
/**
import com.branchin.beemylawyer.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
 */
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    /**
    @Autowired
    RequestRepository requestRepository;
    */

    public Request dtoToRequest(RequestDTO requestDTO) {
       Request request=new Request(
               requestDTO.getId(),
               requestDTO.getLawyerId(),
               requestDTO.getLawyerName(),
               requestDTO.getCreationDate(),
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
                request.getCreationDate(),
                request.getState(),
                request.getClientName(),
                request.getPhoneNumber(),
                request.getClientEmail(),
                request.getDescription()
        );
        return requestDTO;
    }

    public Request createRequest(Request request) {
        /**
        return this.requestRepository.save(request);
         */
        return new Request("1","123","Volach","23/04/2023","connected","Sifro","5142730985","cidt@hotmail.ca","need to reclaim money from BDC company");
    }

    public List<Request> getRequestsByLawyerId(String id) {
        /**
        return this.requestRepository.findAllByLawyerId(id);
         */
        Request request=new Request("1","123","Volach","23/04/2023","connected","Sifro","5142730985","cidt@hotmail.ca","need to reclaim money from BDC company");
        List<Request> list=new ArrayList<>();
        list.add(request);
        return list;
    }

    public Request modifyRequest(Request request) {
        /**
        return this.requestRepository.save(request);
         */
        return new Request("1","123","Volach","23/04/2023","connected","Sifro","5142730985","cidt@hotmail.ca","need to reclaim money from BDC company");
    }

    public Optional<Request> getRequestById(String id) {
        /**
        return this.requestRepository.findById(id);
         */
        Request request=new Request("1","123","Volach","23/04/2023","connected","Sifro","5142730985","cidt@hotmail.ca","need to reclaim money from BDC company");
        return Optional.of(request);
    }
}
