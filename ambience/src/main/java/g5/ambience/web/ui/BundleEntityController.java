package g5.ambience.web.ui;

import g5.ambience.BundleEntity;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/bundleentitys")
@Controller
@RooWebScaffold(path = "bundleentitys", formBackingObject = BundleEntity.class)
public class BundleEntityController {
}
