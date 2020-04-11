package eg.gov.iti.jets.tlds;

import eg.gov.iti.jets.model.Role;
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
                    "    <td><img class='rounded-circle' style=\"width:40px;\" src='" + user.getUserImage().getImagePath() + "'\n" +
                    "     alt=\"activity-user\"></td>\n" +
                    "    <td>\n" +
                    "      <h6 class=\"mb-1\">" + user.getFirstName() + " " + user.getLastName() + "</h6>\n" +
                    "       <p class=\"m-0\" style='font-size: 15px'>" + user.getPhone() + "</p>\n" +
                    "      </td>\n" +
                    "     <td style='tab-size=16;'>\n" +
                    "         <a href=view-profile?id=" + user.getUserId() +
                    "            class='label theme-bg3 text-white f-12'>view profile</a>");

            if(user.getRole() == Role.CUSTOMER_ROLE){
                out.println("<a href=make-as-admin?id=" + user.getUserId() +
                        "            class='label theme-bg2 text-white f-12'>make as admin</a>");
            }
            out.println("</td></tr>");

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