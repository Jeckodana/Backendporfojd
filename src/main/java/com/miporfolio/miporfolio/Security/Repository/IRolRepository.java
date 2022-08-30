package com.miporfolio.miporfolio.Security.Repository;

import com.miporfolio.miporfolio.Security.Entity.Rol;
import com.miporfolio.miporfolio.Security.Enum.RolName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository <Rol, Integer>{
    Optional<Rol> findByRolName (RolName rolName);
}
