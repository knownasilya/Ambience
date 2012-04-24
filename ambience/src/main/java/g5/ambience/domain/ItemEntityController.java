package g5.ambience.domain;

import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/itementitys")
@Controller
@RooWebScaffold(path = "itementitys", formBackingObject = ItemEntity.class)
public class ItemEntityController {
}
