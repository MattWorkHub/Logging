package logging.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BasicService {

    private static final Logger logger = LoggerFactory.getLogger(BasicService.class);

    @Value("${var1}")
    private int var1;

    @Value("${var2}")
    private int var2;


    public double exponent() {
        logger.debug("Calculating power of {} and {}", var1, var2);
        double result = Math.pow(var1, var2);
        logger.debug("Calculation finished. Result: {}", result);
        return result;
    }


}