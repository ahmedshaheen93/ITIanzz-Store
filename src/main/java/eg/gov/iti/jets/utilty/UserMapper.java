package eg.gov.iti.jets.utilty;

import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.model.dto.UserDto;

public class UserMapper {
    public static UserDto mapUser(User user) {
        String image = (user.getUserImage() != null
                ? "/iti-store/images?imageId=" + user.getUserImage().getImageId()
                : "images/user/avatar.jpg");
        UserDto userDto = new UserDto(user.getUserId(), user.getFirstName(), user.getLastName(), user.getPhone(), user.getEmail(), user.getRole().name(), user.getBalance(),
                "" + user.getBirthDate(),
                image, user.getAddress(), user.getOrders().size());
        return userDto;
    }
}
