package com.branchin.beemylawyer.services;

import com.branchin.beemylawyer.classes.Account;
import com.branchin.beemylawyer.dto.RequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    Logger logger= LoggerFactory.getLogger(EmailService.class);
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private AccountService accountService;

    public RequestDTO sendConfirmationToAll(RequestDTO requestDTO) {
        String clientMsg="Congratulation ! a new request was accepted !";
        String lawyerMsg="Congratulation ! you just accepted a new request !";
        Account account=this.accountService.getAccountById(requestDTO.getLawyerId()).get();
        this.sendEmail(requestDTO,clientMsg,requestDTO.getClientEmail());
        this.sendEmail(requestDTO,lawyerMsg,account.getUseremail());
        return requestDTO;
    }

    public void sendEmail(RequestDTO requestDTO,String msgDescription,String toEmail) {
        Account account=this.accountService.getAccountById(requestDTO.getLawyerId()).get();

        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("beemylawyer@gmail.com");
        message.setTo(toEmail);
        message.setSubject("new request accepted");
        message.setText(
                msgDescription+"\n\n\n"+
                "request id: "+requestDTO.getId()+"\n"+
                        "lawyer name :"+requestDTO.getLawyerName()+"\n"+
                        "lawyer email :"+account.getUseremail()+"\n"+
                        "creation date :"+requestDTO.getCreationDate()+"\n"+
                        "state :"+requestDTO.getState()+"\n"+
                        "client name :"+requestDTO.getClientName()+"\n"+
                        "client email :"+requestDTO.getClientEmail()+"\n"+
                        "phone number :"+requestDTO.getPhoneNumber()+"\n"+
                        "request description :"+requestDTO.getDescription()+"\n"
        );
        this.mailSender.send(message);
        logger.info("mail sent to "+message.getTo().toString());
    }
}
