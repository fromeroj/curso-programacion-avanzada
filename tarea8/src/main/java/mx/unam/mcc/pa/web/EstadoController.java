package mx.unam.mcc.pa.web;
import mx.unam.mcc.pa.Estado;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/estadoes")
@Controller
@RooWebScaffold(path = "estadoes", formBackingObject = Estado.class)
public class EstadoController {
}
