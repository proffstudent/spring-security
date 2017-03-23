package com.ogorodov.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User{

    @Version
    private Integer version;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    @NotNull
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", initialValue = 1, allocationSize = 1)
    private Integer id;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "lastName")
    @NotNull
    private String lastName;
    @Column(name = "email")
    @NotNull
    private String email;
    @Column(name = "login")
    @NotNull
    private String login;
    @Column(name = "password")
    @NotNull
    private String password;
    @Column(name = "createdat")
    @NotNull
    private Date createdat;
    @Column(name = "updatedat")
    @NotNull
    private Date updatedat;
    @Column(name = "enabled")
    @NotNull
    private boolean enabled;
    @Column(name = "sex")
    @NotNull
    private String sex;
    @Column(name = "birth")
    @NotNull
    private Date birth;
    @Column(name = "residence")
    @NotNull
    private String residence;
    @Column(name = "education")
    @NotNull
    private String education;
    @Column(name = "workplace")
    @NotNull
    private String workplace;
    @Column(name = "position")
    @NotNull
    private String position;
    @Column(name = "passport")
    @NotNull
    private String passport;
    @Column(name = "issuedby")
    @NotNull
    private String issuedby;
    @Column(name = "addressreg")
    @NotNull
    private String addressreg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accesslevel", referencedColumnName = "id")
    private Level accesslevel;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }



    public boolean isEnabled() {
        return enabled;
    }

    public String getSex() {
        return sex;
    }

    public Date getBirth() {
        return birth;
    }

    public String getResidence() {
        return residence;
    }

    public String getEducation() {
        return education;
    }

    public String getWorkplace() {
        return workplace;
    }

    public String getPosition() {
        return position;
    }

    public String getPassport() {
        return passport;
    }




    public void setId(Integer idUser) {
        this.id = idUser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

    public String getIssuedby() {
        return issuedby;
    }

    public void setIssuedby(String issuedby) {
        this.issuedby = issuedby;
    }

    public String getAddressreg() {
        return addressreg;
    }

    public void setAddressreg(String addressreg) {
        this.addressreg = addressreg;
    }

    public Level getAccesslevel() {
        return accesslevel;
    }

    public void setAccesslevel(Level accesslevel) {
        this.accesslevel = accesslevel;
    }

    /* public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(Integer id, String name, String lastName, String email, String workplace*//*, Integer accessLevel*//*) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.workplace = workplace;
        // this.accessLevel = accessLevel;
    }

    public User(Integer id, String name, String lastName, String email, String login,
                String password, Date createdAt, Date updatedAt, boolean enabled,
                String sex, Date birth, String residence, String education, String workplace,
                String position, String passport, String issuedBy, String addressReg*//*, Integer accessLevel*//*) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.password = password;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.enabled = enabled;
        this.sex = sex;
        this.birth = birth;
        this.residence = residence;
        this.education = education;
        this.workplace = workplace;
        this.position = position;
        this.passport = passport;
        this.issuedBy = issuedBy;
        this.addressReg = addressReg;
        //   this.accessLevel = accessLevel;
    }

    public User(Integer id, String login, String password, *//*Integer accessLevel,*//* String email) {
        this.id = id;
        this.name = null;
        this.lastName = null;
        this.email = email;
        this.login = login;
        this.password = password;
        this.createdAt = null;
        this.updatedAt = null;
        this.enabled = true;
        this.sex = null;
        this.birth = null;
        this.residence = null;
        this.education = null;
        this.workplace = null;
        this.position = null;
        this.passport = null;
        this.issuedBy = null;
        this.addressReg = null;
        //   this.accessLevel = accessLevel;
    }*/
}
