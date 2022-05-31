/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.mil.fab.sisrh2.util;

/**
 *
 * @author fernando
 */

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesMessages implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private void add(String msg, FacesMessage.Severity severity) {
        FacesMessage facesMessage = new FacesMessage(msg);
        facesMessage.setSeverity(severity);
        
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
    
    public void info(String msg) {
        add(msg, FacesMessage.SEVERITY_INFO);
    }

    
}
