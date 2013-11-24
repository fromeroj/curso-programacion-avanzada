package mx.unam.mcc.pa;
import org.springframework.roo.addon.dbre.RooDbManaged;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooJpaActiveRecord(versionField = "", table = "estado", schema = "public")
@RooDbManaged(automaticallyDelete = true)
@RooToString(excludeFields = { "usuarios" })
public class Estado {
}
