package controller;

import entities.Member;
import dao.MemberFacade;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "memberController")
@RequestScoped
public class MemberController {

    private String firstName;
    private String surname;
    private String email;
    private String gender;
    private Date birthDate;
    private Long phoneNumber;
    private LocalDate registrationDate;
//  private String keyword;
// 
//    public String getKeyword() {
//        return keyword;
//    }
// 
//    public void setKeyword(String keyword) {
//        this.keyword = keyword;
//    }
//     
//    public void search() {
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"No results found with ", "'" + keyword + "'"));
//    }
    
    @Inject
    MemberFacade mf;
    
    public MemberController() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

   

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = LocalDate.now();
    }

    

    public MemberFacade getMf() {
        return mf;
    }

    public void setMf(MemberFacade mf) {
        this.mf = mf;
    }

    public String createNewMember() {
        Member m = new Member();
        m.setFirstName(firstName);
        m.setSurname(surname);
        m.setPhoneNumber(phoneNumber);
        m.setEmail(email);
        m.setBirthDate(birthDate);
        m.setGender(gender);
        m.setRegistrationDate(registrationDate);
        mf.create(m);
        return "form";

    }
}
// Movie movie = new Movie(firstInput,year,service.selectGenre(genreInput));
//      /*  movie.setTitle(firstInput);
//        movie.setGenre(service.selectGenre(genreInput));
//        movie.setProductionYear(year);*/
//        mDao.createMovie(movie);
//    }