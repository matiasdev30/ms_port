package com.ms_user.users.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.ms_user.users.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    
}
