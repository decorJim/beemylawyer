package com.branchin.beemylawyer.controllers;

import com.branchin.beemylawyer.classes.Request;
import com.branchin.beemylawyer.dto.RequestDTO;
import com.branchin.beemylawyer.services.EmailService;
import com.branchin.beemylawyer.services.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class requestController {

    Logger logger= LoggerFactory.getLogger(requestController.class);

    @Autowired
    private RequestService requestService;

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private EmailService emailService;

    @PostMapping(value="/request/create")
    public ResponseEntity<RequestDTO> createRequest(@RequestBody RequestDTO requestDTO) {
        logger.info(requestDTO.getClientEmail());
        UUID uuid = UUID.randomUUID();
        requestDTO.setId(String.valueOf(uuid));
        Date now=new Date();
        String date=now.toString();
        requestDTO.setCreationDate(date);
        this.requestService.createRequest(this.requestService.dtoToRequest(requestDTO));
        String destination="/user/".concat(requestDTO.getLawyerId().concat("/new-request"));
        logger.info(destination);
        this.simpMessagingTemplate.convertAndSend(destination,requestDTO);
        return new ResponseEntity<>(requestDTO, HttpStatus.OK);
    }

    @GetMapping(value="/request/lawyer/{id}")
    public ResponseEntity<List<RequestDTO>> getRequestByLawyer(@PathVariable String id) {
        List<RequestDTO> requestDTOList=new ArrayList<>();
        for(Request it:this.requestService.getRequestsByLawyerId(id)) {
            logger.info(it.getId());
            requestDTOList.add(this.requestService.requestToDto(it));
        }
        return new ResponseEntity<>(requestDTOList,HttpStatus.OK);
    }

    @PostMapping(value = "/request/accept")
    public ResponseEntity<RequestDTO> acceptRequest(@RequestBody RequestDTO requestDTO) {
        this.emailService.sendConfirmationToAll(requestDTO);
        Request request=this.requestService.dtoToRequest(requestDTO);
        return new ResponseEntity<>(this.requestService.requestToDto(this.requestService.modifyRequest(request)),HttpStatus.OK);
    }
}
