/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.librarytest.model;

import se.nackademin.librarytest.helpers.StringHelper;

/**
 *
 * @author nicklas
 */
public class UniqueBook extends Book{
    public UniqueBook(String useTitle,String useAuthor,String useDescription, String useIsbn,String useDatePublished, Integer useNbrAvailable){

        if(useTitle!=null){
            setTitle(useTitle);
        }
        else{
            setTitle(StringHelper.randomString());
        }

        if(useAuthor!=null){
            setAuthor(useAuthor);
        }
        else{
            setAuthor("Stephen Baxter");
        }

        if(useDescription!=null){
            setDescription(useDescription);
        }
        else{
            setDescription(StringHelper.randomString());
        }
        
        if(useIsbn!=null){
            setIsbn(useIsbn);
        }
        else{
            setIsbn(StringHelper.randomString());
        }
        if(useDatePublished!=null){
            setDatePublished(useDatePublished);
        }
        else{
            setDatePublished("2010-04-10");
        }
        if (useNbrAvailable!=null){
            setNbrAvailable(useNbrAvailable);
        }
        else{
            setNbrAvailable(5);
        }
    }
}
