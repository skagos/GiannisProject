
package com.ikhGiannis.GiannisProject.Repository;


import com.ikhGiannis.GiannisProject.Model.BelongsTo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BelongsToRepository extends JpaRepository<BelongsTo, Integer> {

}


