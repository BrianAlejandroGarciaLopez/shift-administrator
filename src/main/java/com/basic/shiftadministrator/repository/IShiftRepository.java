package com.basic.shiftadministrator.repository;

import com.basic.shiftadministrator.model.ShiftModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShiftRepository extends JpaRepository<ShiftModel, Long>, PagingAndSortingRepository<ShiftModel, Long> {
}
