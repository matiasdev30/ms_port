package com.ms_user.users.dtos;


public class EmailDTO {
    
    private Long id;
    private String emailTo;
    private String subject;
    private String text;
    
    public Long getId() {
        return id;
    }
  
    public String getEmailTo() {
        return emailTo;
    }
    
    public String getSubject() {
        return subject;
    }
    

    public String getText() {
        return text;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setEmailTo(String email) {
        this.emailTo = email;
    }
    public void setText(String text) {
        this.text = text;
    }

}
