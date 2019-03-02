package com.tesbquote.tesbquote.models.data;

import com.tesbquote.tesbquote.models.RateFactor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RateFactorDao extends CrudRepository<RateFactor, Integer> {
}
