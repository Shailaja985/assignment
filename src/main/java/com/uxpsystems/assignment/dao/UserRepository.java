package com.uxpsystems.assignment.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.uxpsystems.assignment.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
