package controller;

import entities.Members;
import dao.MemberFacade;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    private String phoneNumber;
    private Long id;
    private List memList;
    private Members mem;
    
    private List<Members> fullList;
     
    @Inject
    MemberFacade mf;

    public MemberController() {
    }

    public List<Integer> getMemList() {

        memList = new ArrayList<>();
        for (Members m : mf.findAll()) {
            memList.add(m.getId());
        }
        return memList;
    }

    public void setMemList(List memList) {
        this.memList = memList;
    }

    public List<Members> getFullList() {
        fullList = mf.findAll();
        return fullList;
    }
    

    public void setFullList(List<Members> fullList) {
        this.fullList = fullList;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Members getMem() {
        return mem;
    }

    public void setMem(Members mem) {
        this.mem = mem;
    }

    public MemberFacade getMf() {
        return mf;
    }

    public void setMf(MemberFacade mf) {
        this.mf = mf;
    }

    public String createNewMember() {
        Members m = new Members();
        m.setFirstName(firstName);
        m.setSurname(surname);
        m.setPhoneNumber(phoneNumber);
        m.setEmail(email);
        m.setBirthDate(birthDate);
        m.setGender(gender);
        mf.create(m);
        clearForm();
        info("New member created and saved");
        return "form";

    }
    
    private void clearForm (){
        firstName=null;
        surname=null;
        phoneNumber=null;
        email=null;
        birthDate=null;
        gender=null;
    }
    
    public void info(String s) {
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", s));
    }

    public void error(String s) {
        FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", s));
    }
    
    public void deleteMember() {
        if (id == -1) {
            this.error("You can not delete now, select an id first");
            return;
        }
        mf.remove(mf.find(id));
        info("Member information deleted");
        
    }

    public String updateMember() {
        if (id == -1) {
            this.error("You can not update now, select an id first");
            return "form";
        }
        
        Members m = new Members();
        
        m.setId(id);
        m.setFirstName(firstName);
        m.setSurname(surname);
        m.setPhoneNumber(phoneNumber);
        m.setEmail(email);
        m.setBirthDate(birthDate);
        m.setGender(gender);
        mf.edit(m);
        clearForm();
        info("Member information update");
        return "form";

    }

    public void loadMembers() {
        if (id == -1) {
            clearForm();
            return;
        }
        
        mem = mf.find(id);
        this.firstName = mem.getFirstName();
        this.surname = mem.getSurname();
        this.birthDate = mem.getBirthDate();
        this.gender = mem.getGender();
        this.phoneNumber = mem.getPhoneNumber();
        this.email = mem.getEmail();
    }

}