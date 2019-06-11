package com.local.ysf.Proxy.proxSsecurity.infrastricture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.local.ysf.Proxy.proxSsecurity.Entity.BookReaderUser;

@Repository
public interface BookReaderUserRepository extends JpaRepository<BookReaderUser, Long> {

	public BookReaderUser findByUsername(String username);
}
