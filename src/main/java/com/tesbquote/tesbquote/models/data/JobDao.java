package com.tesbquote.tesbquote.models.data;


import com.tesbquote.tesbquote.models.Job;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface JobDao extends CrudRepository<Job, Integer> {
}

