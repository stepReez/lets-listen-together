package ru.project.llt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.project.llt.model.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {
}
