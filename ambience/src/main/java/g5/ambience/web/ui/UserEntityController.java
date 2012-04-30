package g5.ambience.web.ui;

import g5.ambience.UserEntity;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/userentitys")
@Controller
@RooWebScaffold(path = "userentitys", formBackingObject = UserEntity.class)
public class UserEntityController {
	public UserEntityController() {
		// TODO Auto-generated constructor stub
		 
	}
}
