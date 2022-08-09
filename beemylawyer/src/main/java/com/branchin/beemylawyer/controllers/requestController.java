package com.branchin.beemylawyer.controllers;

import com.branchin.beemylawyer.dto.RequestDTO;
import com.branchin.beemylawyer.services.RequestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
public class requestController {

    Logger logger= LoggerFactory.getLogger(requestController.class);

    @Autowired
    RequestService requestService;

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping(value="/request/create")
    public ResponseEntity<RequestDTO> createRequest(@RequestBody RequestDTO requestDTO) {
        logger.info(requestDTO.getClientEmail());
        UUID uuid = UUID.randomUUID();
        requestDTO.setId(String.valueOf(uuid));
        Date now=new Date();
        String date=now.toString();
        requestDTO.setCreationDate(date);
        this.requestService.createRequest(this.requestService.dtoToRequest(requestDTO));
        //this.simpMessagingTemplate.convertAndSend();
        return new ResponseEntity<>(requestDTO, HttpStatus.OK);
    }
}
