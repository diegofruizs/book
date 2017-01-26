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
import co.edu.uniandes.csw.book.entities.AuthorEntity;
import co.edu.uniandes.csw.crud.spi.persistence.CrudPersistence;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * @generated
 */
@Stateless
public class AuthorPersistence {

    @PersistenceContext(unitName = "bookPU")
    protected EntityManager em;

    public AuthorEntity create(AuthorEntity entity) {
        em.persist(entity);
        return entity;
    }

    public AuthorEntity update(AuthorEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        AuthorEntity entity = em.find(AuthorEntity.class, id);
        em.remove(entity);
    }

    public AuthorEntity find(Long id) {
        return em.find(AuthorEntity.class, id);
    }

    public List<AuthorEntity> findAll() {
        TypedQuery q = em.createQuery("select u from AuthorEntity u", AuthorEntity.class);
        return q.getResultList();
    }

    public int count() {
        Query count = em.createQuery("select count(u) from AuthorEntity u");
        return Integer.parseInt(count.getSingleResult().toString());
    }

    public List<AuthorEntity> findAll(Integer page, Integer maxRecords) {
        Query q = em.createQuery("select u from AuthorEntity u");
        if (page != null && maxRecords != null) {
            q.setFirstResult((page - 1) * maxRecords);
            q.setMaxResults(maxRecords);
        }
        return q.getResultList();
    }

}
