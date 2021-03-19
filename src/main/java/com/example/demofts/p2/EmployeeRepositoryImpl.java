package com.example.demofts.p2;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.BooleanJunction;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.transaction.annotation.Transactional;

import com.example.demofts.objects.Employee;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepositoryExt {
	@PersistenceContext
	private  EntityManager entityManager;

	@Override
	@Transactional(readOnly = true)
	public List<Employee> search(final String keywords) {

		final FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

		// Search query builder
		final QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
				.forEntity(Employee.class).get();

		// Use a boolean junction and then add queries to it
		final BooleanJunction<BooleanJunction> outer = queryBuilder.bool();
		outer.must(queryBuilder.keyword().onFields("firstName", "lastName").matching(keywords).createQuery());

		@SuppressWarnings("unchecked")
		List<Employee> resultList = fullTextEntityManager.createFullTextQuery(outer.createQuery(), Employee.class)
				.getResultList();
		return resultList;
	}
    public List<Employee> getPostBasedOnWord(String word){
        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Employee.class).get();
        Query foodQuery = qb.keyword().onFields("firstName","lastName").matching(word).createQuery();
        FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(foodQuery, Employee.class);
        return (List<Employee>) fullTextQuery.getResultList();
    }
    @Transactional
    public List<Employee> getListyKey(String searchTerm){
    	FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Employee.class).get();
        Query luceneQuery = qb.keyword().fuzzy().withEditDistanceUpTo(1).withPrefixLength(1).onFields("lastName")
                .matching(searchTerm).createQuery();

        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Employee.class);

        // execute search

        List<Employee> BaseballCardList = null;
        try {
            BaseballCardList = jpaQuery.getResultList();
        } catch (NoResultException nre) {
            ;// do nothing

        }

        return BaseballCardList;
    }
}