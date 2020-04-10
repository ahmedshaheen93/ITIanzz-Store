package eg.gov.iti.jets.tlds;

import eg.gov.iti.jets.model.User;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @author Noura
 */
public class UserTLD extends SimpleTagSupport {

    private User user;

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {

            out.println("<tr class=\"unread\">" +
                    "    <td><img class=\"rounded-circle\" style=\"width:40px;\" src='" + user.getUserImage().getImagePath() + "'" +
                    "     alt=\"activity-user\"></td>" +
                    "    <td>" +
                    "        <h6 class=\"mb-1\">" + user.getFirstName() + " " + user.getLastName() + "</h6>" +
                    "        <p class=\"m-0\" style='font-size: 15px'>" + user.getPhone() + "</p>" +
                    "    </td>" +
                    "    <td>" +
                    "        <p class=\"text-muted\" style='font-size: 15px'>" +
                    "           <i class=\"fas fa-circle text-c-green f-10 m-r-15\"></i>" + user.getBirthDate().toString() +
                    "        </p>" +
                    "    </td>" +
                    "    <td>" +
                    "       <a href=\"update-profile?id=" +  user.getUserId() +"\" class=\"label theme-bg3 text-white f-12\">edit profile</a>" +
                    "       <a href=\"view-profile?id=" +  user.getUserId() +"\" class=\"label theme-bg2 text-white f-12\">view profile</a>" +
                    "    </td>" +
                    "</tr>");

        } catch (java.io.IOException ex) {
            throw new JspException("Error in CutomerCustomTag tag", ex);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}