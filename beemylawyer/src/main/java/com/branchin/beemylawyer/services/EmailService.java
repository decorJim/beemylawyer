package com.branchin.beemylawyer.services;

import com.branchin.beemylawyer.classes.Account;
import com.branchin.beemylawyer.classes.Request;
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

    @Autowired
    private RequestService requestService;

    public RequestDTO sendConfirmationToAll(RequestDTO requestDTO) {
        Request request=this.requestService.getRequestById(requestDTO.getId()).get();
        String clientMsg="Congratulation ! a new request was accepted !";
        String lawyerMsg="Congratulation ! you just accepted a new request !";
        Account account=this.accountService.getAccountById(request.getLawyerId()).get();
        this.sendEmail(request,clientMsg, request.getClientEmail());
        this.sendEmail(request,lawyerMsg, account.getUseremail());
        return requestDTO;
    }

    public void sendEmail(Request request,String msgDescription,String toEmail) {
        Account account=this.accountService.getAccountById(request.getLawyerId()).get();

        SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("beemylawyer@gmail.com");
        message.setTo(toEmail);
        message.setSubject("new request accepted");
        message.setText(
                msgDescription+"\n\n\n"+
                "request id: "+request.getId()+"\n"+
                        "lawyer name :"+request.getLawyerName()+"\n"+
                        "lawyer email :"+account.getUseremail()+"\n"+
                        "creation date :"+request.getCreationDate()+"\n"+
                        "client name :"+request.getClientName()+"\n"+
                        "client email :"+request.getClientEmail()+"\n"+
                        "phone number :"+request.getPhoneNumber()+"\n"+
                        "request description :"+request.getDescription()+"\n"
        );
        this.mailSender.send(message);
        logger.info("mail sent to "+message.getTo().toString());
    }
}
