package org.example.service;

import org.example.dto.Book;
import org.example.dto.Borrower;
import org.example.entity.BookEntity;
import org.example.entity.BorrowerEntity;

import java.util.List;

public interface BorrowerService {
    void addBorrower(Borrower borrower);
    List<BorrowerEntity> getBorrowers();
    boolean deleteBorrower(Long id);
    Borrower getBorrowerById(Long id);
}
