package com.group10.StudyGroupOrganizer.repository;

import com.group10.StudyGroupOrganizer.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
