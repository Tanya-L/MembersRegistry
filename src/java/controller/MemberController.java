package controller;

import entities.Member;
import dao.MemberFacade;
import java.time.LocalDate;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "memberController")
@RequestScoped
public class MemberController {

    private String firstName;
    private String surname;
    private String email;
    private String gender;
    private int birthYear;
    private Long phoneNumber;
    private LocalDate registrationDate = LocalDate.now();

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

   

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
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
        this.registrationDate = registrationDate;
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
        m.setBirthYear(birthYear);
        m.setGender(gender);
        // m.setRegistrationDate(registrationDate);
        mf.create(m);
        return "index";

    }
}
// Movie movie = new Movie(firstInput,year,service.selectGenre(genreInput));
//      /*  movie.setTitle(firstInput);
//        movie.setGenre(service.selectGenre(genreInput));
//        movie.setProductionYear(year);*/
//        mDao.createMovie(movie);
//    }