package com.ikhGiannis.GiannisProject.Repository;
import com.ikhGiannis.GiannisProject.Model.Court;
import com.ikhGiannis.GiannisProject.Model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

}
