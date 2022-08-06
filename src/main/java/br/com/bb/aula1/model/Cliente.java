package br.com.bb.aula1.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NotBlank
    @Pattern(regexp = "[\\w]{5,100}")
    private String Name;

    @NotNull
    @Min(18)
    private Integer Age;

    @NotBlank
    @Pattern(regexp = "[\\p{Upper}]{2}[\\d]{9}")
    private String VAT;

    @NotBlank
    // https://www.oreilly.com/library/view/regular-expressions-cookbook/9781449327453/ch04s01.html
    @Pattern(regexp = "^\\S+@\\S+$")
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