package com.UserCassandra.Project.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class User {
	@Id
    @PrimaryKey
    private int id;
    @Column
    private String name;
    
    @Column
    private List<Integer> value;
    
    public User(){
        super();
    }
    public User(int id, String name, List<Integer> value) {
        super();
        this.id = id;
        this.name = name;
        this.value = value;
    }


    public void setId(int id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    public List<Integer> getValuListes() {
        return value;
    }

    public void setValuListes(List<Integer> values) {
        this.value = values;
    }

}
