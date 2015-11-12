/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wallejr.cmarestservice;

import cmabackend.CMABackEndClass;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author wallejr
 */
@Path("CMARest")
public class CMARestResource
{

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CMARestResource
     */
    public CMARestResource()
    {
    }

    /**
     * Retrieves representation of an instance of com.wallejr.cmarestservice.CMARestResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getText()
    {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of CMARestResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putText(String content)
    {
    }
    
    @GET
    @Path("/validateCourse//{courseCode}/{term}/")
    @Produces("text/plain")
    public String CheckCourseExistence(@PathParam("courseCode") String curse, @PathParam("term") String termin)
    {
        CMABackEndClass backend = new CMABackEndClass();
        String anmCode;
        
        try
        {
            anmCode = backend.checkCourseExistence(curse, termin);
        } catch (Exception e)
        {
            anmCode = "Ett fel uppstod" + e.getMessage();
        }
        
        return anmCode;
    }
    
    @GET
    @Path("/checkStud/{anmcode}/{studentID}/")
    @Produces("text/plain")
    public String checkStudentOnCourse(@PathParam("anmCode") String anmCode, @PathParam("studentID") String studID)
    {
        CMABackEndClass backend = new CMABackEndClass();
        String response = "invalid";
        
        try
        {
            response = backend.checkStudonCourse(anmCode, studID);
            
            
        } catch (Exception e)
        {
            response = "Ett fel uppstod" + e.getMessage();
        }
        
        return response;
    }
    
    @POST
    @Path("/post/{studentID}/{anmcode}/{examnr}/{grade}")
    @Consumes("text/plain")
    public String saveAssignmetResult(
                    @PathParam("studentID")String studID,
                    @PathParam("anmcode")String anmCode,
                    @PathParam("examnr")String assignr,
                    @PathParam("grade")String asignGrade)
    {
        String response = "invalid";
        
        CMABackEndClass backend = new CMABackEndClass();
        
        
        try
        {
            response = backend.aissgnGrades(studID, anmCode, assignr, asignGrade);
            
            
        } catch (Exception e)
        {
            response = "Ett fel uppstod" + e.getMessage();
        }
        
        return response;
    }
    
    
}
