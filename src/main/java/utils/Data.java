package utils;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;


@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({ METHOD })

public @interface Data {

    /**
     * Specifies the name of the file to read.
     * 
     */
	

	public String sheetName() default "Sheet1";
	
	public String propertiesFileName() default "config.properties";

    
  

    
}
