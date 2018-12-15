package com.kworld.designpattern.creational.factory;

import com.kworld.designpattern.creational.FileType;

import java.io.IOException;

import org.junit.Test;

import static com.kworld.util.Util.logger;

public class DocFactoryTest {
	
	@Test
    public void testFactoru() throws IOException {
        Document file = DocumentFactory.createDocument(FileType.PDF);
        logger.info(String.format("%s %n", file.createDocument().getAbsolutePath()));

        file = DocumentFactory.createDocument(FileType.TXT);
        logger.info(String.format("%s %n", file.createDocument().getAbsolutePath()));

        file = DocumentFactory.createDocument(FileType.HTML);
        logger.info(String.format("%s %n", file.createDocument().getAbsolutePath()));

        DocumentFactory.createDocument(null);
    }
}
