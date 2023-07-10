package com.ikhGiannis.GiannisProject.Repository;

import java.util.Set;

public interface SportCenterDTO {
    Integer getSportCenterId();
    String getSportCenterName();
    String getAddress();
    Long getCourtCount();

    Set<String> getSports();



}
