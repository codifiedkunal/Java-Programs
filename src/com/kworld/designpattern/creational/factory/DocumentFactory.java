package com.kworld.designpattern.creational.factory;

import com.kworld.designpattern.creational.FileType;

import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

/*
 * Factory Method is related to the idea on which libraries work: a library uses abstract classes for defining and maintaining relations between objects. One type of responsibility is creating such objects. The library knows when an object needs to be created, but not what kind of object it should create, this being specific to the application using the library.
 * The Factory method works just the same way: it defines an interface for creating an object, but leaves the choice of its type to the subclasses, creation being deferred at run-time.
 *
 * In Java
 *      java.util.Calendar#getInstance()
 *      java.util.ResourceBundle#getBundle()
 *      java.text.NumberFormat#getInstance()
 */
public class DocumentFactory {
    public static Document createDocument(FileType fileType){
        if(fileType.compareTo(FileType.PDF) == 0)
            return new PDFDocument();
        else if(fileType.compareTo(FileType.TXT) == 0)
            return new TXTDocument();
        else if(fileType.compareTo(FileType.HTML) == 0)
            return new HTMLDocument();
        else
            throw new InvalidParameterException("Invalid Document type");
    }
}

abstract class Document{
    public abstract File createDocument() throws IOException;
}

class PDFDocument extends Document{
    @Override
    public File createDocument() throws IOException {
        File file = new File(System.getProperty("java.io.tmpdir") + "PDF_FILE_" +System.currentTimeMillis()+".pdf");
        file.createNewFile();
        return file;
    }
}

class TXTDocument extends Document{
    @Override
    public File createDocument() throws IOException{
        File file =  new File(System.getProperty("java.io.tmpdir") + "TXT_FILE_" +System.currentTimeMillis()+".txt");
        file.createNewFile();
        return file;
    }
}

class HTMLDocument extends Document{

    public static final String JAVA_IO_TMPDIR = "java.io.tmpdir";

    @Override
    public File createDocument() throws IOException{
        File file =  new File(System.getProperty(JAVA_IO_TMPDIR) + "HTML_FILE_" + System.currentTimeMillis() + ".html");
        file.createNewFile();
        return file;
    }
}

