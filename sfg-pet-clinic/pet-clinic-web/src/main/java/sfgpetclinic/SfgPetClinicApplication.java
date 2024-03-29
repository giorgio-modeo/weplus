package sfgpetclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"sfgpetclinic"})
public class SfgPetClinicApplication {
 public static void main(String[] args) {
  SpringApplication.run(SfgPetClinicApplication.class, args);
 }
}