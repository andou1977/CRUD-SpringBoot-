package com.example.thymeleaf.Repositorie;

import com.example.thymeleaf.Model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorieMvc  extends JpaRepository<Etudiant, Long> {
    Etudiant findByNom(final String nom);
}
