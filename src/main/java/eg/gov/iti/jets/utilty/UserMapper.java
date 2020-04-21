package eg.gov.iti.jets.utilty;

import eg.gov.iti.jets.model.Order;
import eg.gov.iti.jets.model.User;
import eg.gov.iti.jets.model.dto.OrderDto;
import eg.gov.iti.jets.model.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserDto mapUser(User user) {
        List<OrderDto> orders = new ArrayList<>(0);
        for (Order order : user.getOrders()) {
            orders.add(OrderMapper.mapOrder(order));
        }
        String image = (user.getUserImage() != null
                ? "/iti-store/images?imageId=" + user.getUserImage().getImageId()
                : "images/user/avatar.jpg");
        UserDto userDto = new UserDto(user.getUserId(), user.getFirstName(), user.getLastName(), user.getPhone(), user.getEmail(), user.getRole().name(), user.getBalance(),
                "" + user.getBirthDate(),
                image, user.getAddress(), orders);
        return userDto;
    }
}
