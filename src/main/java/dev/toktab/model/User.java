package dev.toktab.model;

import dev.toktab.model.interfaces.IEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
public class User implements IEntity, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;
    @Column(name = "salary")
    private double salary;
    @Column(name = "budget")
    private double budget;
    @Column(name = "date")
    private Date date;
    @Column(name = "fired")
    private int fired;
    @Column(name = "type_id")
    private int type_id;
    @OneToMany(mappedBy = "user")
    private List<SalaryHistory> salaryHistoryList;
    @OneToMany(mappedBy = "user")
    private List<Budget> budgetList;
    @OneToMany(mappedBy = "toUser")
    private List<Funding> receivedFundsList;
    @OneToMany(mappedBy = "fromUser")
    private List<Funding> sendFundsList;
//    @OneToMany(mappedBy = "toUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Message> receivedMessageList;
//    @OneToMany(mappedBy = "fromUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Message> sendMessageList;

    @Override
    public void memberWiseUpdate(IEntity entity) {
        User newEntity = (User) entity;

        this.setName(newEntity.getName());
        this.setPassword(newEntity.getPassword());
        this.setBudget(newEntity.getBudget());
        this.setFired(newEntity.getFired());
        this.setSalary(newEntity.getSalary());
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_" + Global.getRoleName(type_id);
            }
        });
        return grantedAuthorityList;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}