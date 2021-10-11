package com.shabloel.recipeapp.repositories;

import com.shabloel.recipeapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : christiaan.griffioen
 * @since :  28-6-2021, ma
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
