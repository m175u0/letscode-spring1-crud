package br.com.bb.aula1.model;

import javax.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String Name;
    private Integer Age;
    private String VAT;
    private String Email;

    protected Cliente() { }

    public Cliente(String name, Integer age, String VAT, String email) {
        Name = name;
        Age = age;
        this.VAT = VAT;
        Email = email;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public Integer getAge() {
        return Age;
    }

    public String getVAT() {
        return VAT;
    }

    public String getEmail() {
        return Email;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(Integer age) {
        Age = age;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }

    public void setEmail(String email) {
        Email = email;
    }
}