package exam.util.validator;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidationUtil {


    <E> boolean isValid (E entity);


}
