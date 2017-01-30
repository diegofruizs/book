/*
The MIT License (MIT)

Copyright (c) 2015 Los Andes University

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package co.edu.uniandes.csw.book.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import co.edu.uniandes.csw.book.entities.BookEntity;
import java.util.List;
import javax.persistence.Query;

/**
 * @generated
 */
@Stateless
public class BookPersistence {

    @PersistenceContext(unitName="bookPU")
    protected EntityManager em;

    /**
     * @generated
     */
    
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     * @generated
     */
    
    protected Class<BookEntity> getEntityClass() {
        return BookEntity.class;
    }

    /**
     * Retrieves the ammount of records in the database for the handled entity
     *
     * @return Number of records of handled entity
     */
    public int count() {
        Query count = getEntityManager().createQuery("select count(u) from BookEntity u");
        return Integer.parseInt(count.getSingleResult().toString());
    }

    /**
     * Creates a new record in database for the handled instance
     *
     * @param entity Record information
     * @return New instance of handled entity with it's ID
     */
    public BookEntity create(BookEntity entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    /**
     * Updates an existing instance of handled entity.
     *
     * @param entity Updated instance
     * @return Updated instance
     */
    public BookEntity update(BookEntity entity) {
        return getEntityManager().merge(entity);
    }

    /**
     * Deletes a record of handled entity from database.
     *
     * @param id ID of the record to delete
     */
    public void delete(Long id) {
        BookEntity entity = getEntityManager().find(getEntityClass(), id);
        getEntityManager().remove(entity);
    }

    /**
     * Retrieves an instance of handled entity by ID.
     *
     * @param id ID of the instance to retrieve
     * @return Instance of handled entity
     */
    public BookEntity find(Long id) {
        return getEntityManager().find(getEntityClass(), id);
    }

    /**
     * Retrieves a collection of all instances of handled entity
     *
     * @return Colecction of instances of handled entity
     */
    public List<BookEntity> findAll() {
        Query q = getEntityManager().createQuery("select u from BookEntity u");
        return q.getResultList();
    }

    /**
     * Retrieves a collection of all instances of handled entity allowing
     * pagination.
     *
     * @param page Number of page to retrieve
     * @param maxRecords Number of records per page
     * @return Colecction of instances of handled entity
     */
    public List<BookEntity> findAll(Integer page, Integer maxRecords) {
        Query q = getEntityManager().createQuery("select u from BookEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        return q.getResultList();
    }



}
