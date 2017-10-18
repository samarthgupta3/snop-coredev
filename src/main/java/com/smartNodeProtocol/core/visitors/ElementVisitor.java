package com.smartNodeProtocol.core.visitors;

import com.smartNodeProtocol.core.dao.model.data.Book;

/**
 * Created by Samarth on 02-08-2017.
 */
public interface ElementVisitor <RESULT,DATA>{

    RESULT visitBook(Book book, DATA data);
}
