/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.codejava.spring.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.faces.FacesException;
import javax.annotation.Resource;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import net.codejava.spring.bean.BookFacade;
import net.codejava.spring.model.util.JsfUtil;
import net.codejava.spring.model.util.PagingInfo;

/**
 *
 * @author DIEGO
 */
public class BookController {

    public BookController() {
        pagingInfo = new PagingInfo();
        converter = new BookConverter();
    }
    private Book book = null;
    private List<Book> bookItems = null;
    private BookFacade jpaController = null;
    private BookConverter converter = null;
    private PagingInfo pagingInfo = null;
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "angularMYSQLPU")
    private EntityManagerFactory emf = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(getJpaController().count());
        }
        return pagingInfo;
    }

    public BookFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (BookFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "bookJpa");
        }
        return jpaController;
    }

    public SelectItem[] getBookItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getBookItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public Book getBook() {
        if (book == null) {
            book = (Book) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentBook", converter, null);
        }
        if (book == null) {
            book = new Book();
        }
        return book;
    }

    public String listSetup() {
        reset(true);
        return "book_list";
    }

    public String createSetup() {
        reset(false);
        book = new Book();
        return "book_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(book);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Book was successfully created.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("book_detail");
    }

    public String editSetup() {
        return scalarSetup("book_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        book = (Book) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentBook", converter, null);
        if (book == null) {
            String requestBookString = JsfUtil.getRequestParameter("jsfcrud.currentBook");
            JsfUtil.addErrorMessage("The book with id " + requestBookString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String bookString = converter.getAsString(FacesContext.getCurrentInstance(), null, book);
        String currentBookString = JsfUtil.getRequestParameter("jsfcrud.currentBook");
        if (bookString == null || bookString.length() == 0 || !bookString.equals(currentBookString)) {
            String outcome = editSetup();
            if ("book_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit book. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(book);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Book was successfully updated.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return detailSetup();
    }

    public String remove() {
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentBook");
        Long id = new Long(idAsString);
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().remove(getJpaController().find(id));
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("Book was successfully deleted.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return relatedOrListOutcome();
    }

    private String relatedOrListOutcome() {
        String relatedControllerOutcome = relatedControllerOutcome();
        if (relatedControllerOutcome != null) {
            return relatedControllerOutcome;
        }
        return listSetup();
    }

    public List<Book> getBookItems() {
        if (bookItems == null) {
            getPagingInfo();
            bookItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return bookItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "book_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "book_list";
    }

    private String relatedControllerOutcome() {
        String relatedControllerString = JsfUtil.getRequestParameter("jsfcrud.relatedController");
        String relatedControllerTypeString = JsfUtil.getRequestParameter("jsfcrud.relatedControllerType");
        if (relatedControllerString != null && relatedControllerTypeString != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Object relatedController = context.getApplication().getELResolver().getValue(context.getELContext(), null, relatedControllerString);
            try {
                Class<?> relatedControllerType = Class.forName(relatedControllerTypeString);
                Method detailSetupMethod = relatedControllerType.getMethod("detailSetup");
                return (String) detailSetupMethod.invoke(relatedController);
            } catch (ClassNotFoundException e) {
                throw new FacesException(e);
            } catch (NoSuchMethodException e) {
                throw new FacesException(e);
            } catch (IllegalAccessException e) {
                throw new FacesException(e);
            } catch (InvocationTargetException e) {
                throw new FacesException(e);
            }
        }
        return null;
    }

    private void reset(boolean resetFirstItem) {
        book = null;
        bookItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Book newBook = new Book();
        String newBookString = converter.getAsString(FacesContext.getCurrentInstance(), null, newBook);
        String bookString = converter.getAsString(FacesContext.getCurrentInstance(), null, book);
        if (!newBookString.equals(bookString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}