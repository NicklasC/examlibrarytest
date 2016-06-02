/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin.librarytest.helpers;

import com.codeborne.selenide.SelenideElement;

/**
 *
 * @author nicklas
 */
public class Table {
     private SelenideElement rootElement;
    
    public Table(SelenideElement rootElement){
        this.rootElement = rootElement;
    }
    public int getRowCount(){
        return rootElement.$$("tr").size();
    }
    public int getColCount(){
        return rootElement.$("tr").$$("th").size();
    }
}
