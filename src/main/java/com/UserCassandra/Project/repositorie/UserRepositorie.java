package com.UserCassandra.Project.repositorie;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import com.UserCassandra.Project.model.User;

@Repository
public interface UserRepositorie extends CassandraRepository<User, Integer>{

}
