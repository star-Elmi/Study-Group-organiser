package com.group10.StudyGroupOrganizer.repository;

import com.group10.StudyGroupOrganizer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User ,Long> {
}
