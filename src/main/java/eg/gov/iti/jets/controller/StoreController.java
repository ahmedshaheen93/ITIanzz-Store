package eg.gov.iti.jets.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eg.gov.iti.jets.model.Address;
import eg.gov.iti.jets.model.Store;
import eg.gov.iti.jets.service.StoreService;

import java.io.IOException;

@WebServlet(name = "store", urlPatterns = "/store")
public class StoreController extends HttpServlet {

    private static final long serialVersionUID = 3867803697941680936L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("store.jsp").include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        StoreService storeService = (StoreService) req.getServletContext().getAttribute("storeService");

        Store storeInstance = storeService.getStoreInfo();

        storeInstance.setStoreName(req.getParameter("name"));
        storeInstance.setDescription(req.getParameter("description"));
        storeInstance.setEmail(req.getParameter("email"));
        storeInstance.setPhoneNumber(req.getParameter("phone"));
        storeInstance.setFaxNumber(req.getParameter("fax"));
        
        Address address = new Address();
        address.setCountry(req.getParameter("country"));
        address.setState(req.getParameter("state"));
        address.setCity(req.getParameter("city"));
        address.setStreet(req.getParameter("street"));
        address.setZipCode(req.getParameter("zipcode"));        
        storeInstance.setAddress(address);

        storeInstance.setFaceBook(req.getParameter("facebook"));
        storeInstance.setTwitter(req.getParameter("twitter"));
        storeInstance.setYoutube(req.getParameter("youtube"));
        storeInstance.setLinkedin(req.getParameter("linkedin"));
        storeInstance.setInstagram(req.getParameter("instagram"));

        storeInstance.setLinksTitle(req.getParameter("linksTitle"));
        storeInstance.setLink1(req.getParameter("link1"));
        storeInstance.setLinkAddress1(req.getParameter("linkAddress1"));
        storeInstance.setLink2(req.getParameter("link2"));
        storeInstance.setLinkAddress2(req.getParameter("linkAddress2"));
        storeInstance.setLink3(req.getParameter("link3"));
        storeInstance.setLinkAddress3(req.getParameter("linkAddress3"));
        storeInstance.setLink4(req.getParameter("link4"));
        storeInstance.setLinkAddress4(req.getParameter("linkAddress4"));

        storeInstance.setSliderTitle1(req.getParameter("sliderTitle1"));
        storeInstance.setSliderSubTitle1(req.getParameter("sliderSubTitle1"));
        storeInstance.setSliderTitle2(req.getParameter("sliderTitle2"));
        storeInstance.setSliderSubTitle2(req.getParameter("sliderSubTitle2"));
        storeInstance.setSliderTitle3(req.getParameter("sliderTitle3"));
        storeInstance.setSliderSubTitle3(req.getParameter("sliderSubTitle3"));
        storeInstance.setSliderTitle4(req.getParameter("sliderTitle4"));
        storeInstance.setSliderSubTitle4(req.getParameter("sliderSubTitle4"));

        storeService.updateStoreInfo(storeInstance);

        Store newStoreInstance = storeService.getStoreInfo();

        req.getServletContext().setAttribute("storeInstance", newStoreInstance);
        
        // super.doPost(req, resp);
    }
}
