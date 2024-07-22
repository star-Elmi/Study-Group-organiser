package com.group10.StudyGroupOrganizer.repository;

import com.group10.StudyGroupOrganizer.model.SessionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<SessionDetails,Long> {
}
